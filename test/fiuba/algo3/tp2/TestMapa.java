package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMapa {

	@Test
	public void testCrearMapa() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		for (int i=1; i<=10;i++)
			for(int j=1; j<=10;j++)
		assertTrue(mapa.hayVacio(new Posicion(i,j)));
	}
	
	@Test
	public void testCrearMapaYConsultarTamanio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,12));
		
		assertEquals(mapa.tamanio().enX(),10);
		assertEquals(mapa.tamanio().enY(),12);
	}
	
	@Test
	public void testPosicionInvalidaEnElMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		for (int i=-2; i<=12;i++)
		assertTrue(mapa.estaFueraDelMapa(new Posicion(0,i)));
	}
	
	@Test
	public void testInsertarObjetoDentroDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		RecursoMineral mineral = new RecursoMineral();
		Posicion posicion = new Posicion(1,1);
		
		mapa.colocarObjeto(posicion, mineral);
		
		assertEquals(mineral, mapa.contenido(posicion));		
	}
	
	@Test
	public void testNoDebeInsertarObjetoFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		RecursoMineral mineral = new RecursoMineral();
		Posicion posicion = new Posicion(0,0);
		
		mapa.colocarObjeto(posicion, mineral);
		
		assertTrue( mapa.estaFueraDelMapa(posicion));
	}
	
	@Test
	public void testInsertarObjetoConTamanioEnLaEsquinaInferiorDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(1, 1);
		Posicion posicion2 = new Posicion(1, 2);
		Posicion posicion3 = new Posicion(2, 1);
		Posicion posicion4 = new Posicion(2, 2);
		
		mapa.colocarObjeto(posicion1, barraca,barraca.tamanio());
		
		assertEquals(barraca, mapa.contenido(posicion1));
		assertEquals(barraca, mapa.contenido(posicion2));
		assertEquals(barraca, mapa.contenido(posicion3));
		assertEquals(barraca, mapa.contenido(posicion4));		
	}
	
	@Test
	public void testInsertarObjetoConTamanioEnLaEsquinaSuperiorDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(9, 9);
		Posicion posicion2 = new Posicion(9, 10);
		Posicion posicion3 = new Posicion(10, 9);
		Posicion posicion4 = new Posicion(10, 10);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertEquals(barraca, mapa.contenido(posicion1));
		assertEquals(barraca, mapa.contenido(posicion2));
		assertEquals(barraca, mapa.contenido(posicion3));
		assertEquals(barraca, mapa.contenido(posicion4));		
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(16, 3);
		Posicion posicion2 = new Posicion(16, 4);
		Posicion posicion3 = new Posicion(17, 3);
		Posicion posicion4 = new Posicion(17, 4);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertTrue( mapa.estaFueraDelMapa(posicion1));
		assertTrue( mapa.estaFueraDelMapa(posicion2));
		assertTrue( mapa.estaFueraDelMapa(posicion3));
		assertTrue( mapa.estaFueraDelMapa(posicion4));
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioEnElBordeInferiorFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(0, 0);
		Posicion posicion2 = new Posicion(0, 1);
		Posicion posicion3 = new Posicion(1, 0);
		Posicion posicion4 = new Posicion(1, 1);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertTrue( mapa.estaFueraDelMapa(posicion1));
		assertTrue( mapa.estaFueraDelMapa(posicion2));
		assertTrue( mapa.estaFueraDelMapa(posicion3));
		assertTrue( mapa.hayVacio(posicion4));
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioEnElBordeSuperiorSaliendoseDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(10, 10);
		Posicion posicion2 = new Posicion(10, 11);
		Posicion posicion3 = new Posicion(11, 10);
		Posicion posicion4 = new Posicion(11, 11);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertTrue( mapa.hayVacio(posicion1));
		assertTrue( mapa.estaFueraDelMapa(posicion2));
		assertTrue( mapa.estaFueraDelMapa(posicion3));
		assertTrue( mapa.estaFueraDelMapa(posicion4));
	}
	
	@Test
	public void testIntercambiarObjetosSinTamanioDePosicion(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		UnidadMarine marine1 = new UnidadMarine();
		UnidadMarine marine2 = new UnidadMarine();
		
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(8,7);
		
		mapa.colocarObjeto(posicion1, marine1);
		mapa.colocarObjeto(posicion2, marine2);
		
		mapa.intercambiarObjetos(posicion1, posicion2);
		
		assertEquals(mapa.contenido(posicion1), marine2);
		assertEquals(mapa.contenido(posicion2), marine1);		
	}
	
	@Test
	public void testNoDeberiaIntercambiarConObjetoConPosicionFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		UnidadMarine marine = new UnidadMarine();
		
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(-2,4);
		
		mapa.colocarObjeto(posicion1, marine);
		
		mapa.intercambiarObjetos(posicion1, posicion2);
		
		assertEquals(mapa.contenido(posicion1), marine);
		assertTrue(mapa.estaFueraDelMapa(posicion2));		
	}
	
	@Test
	public void testRemoverObjeto(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		UnidadMarine marine = new UnidadMarine();
		
		Posicion posicion = new Posicion(1,5);
		
		mapa.colocarObjeto(posicion, marine);
		mapa.removerObjeto(posicion);
		
		assertTrue(mapa.hayVacio(posicion));	
	}
	
	@Test
	public void testRemoverUnaPosicionVacia(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
				
		Posicion posicion = new Posicion(1,5);
		mapa.removerObjeto(posicion);
		
		assertTrue(mapa.hayVacio(posicion));	
	}
	
	@Test
	public void testRemoverUnaPosicionFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
				
		Posicion posicion = new Posicion(12,15);
		mapa.removerObjeto(posicion);
		
		assertTrue(mapa.estaFueraDelMapa(posicion));
	}
}
