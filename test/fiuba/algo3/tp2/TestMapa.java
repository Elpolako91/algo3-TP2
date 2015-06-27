package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMapa {

	@Test
	public void testCrearMapa() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		for (int i=1; i<=10;i++)
			for(int j=1; j<=10;j++)
				for (int k = 0; k <= 2; k++)
		assertTrue(mapa.hayVacio(new PosicionMapa(i,j,k)));
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
		assertFalse(mapa.esPosicionValida(new Posicion(0,i)));
	}
	
	@Test
	public void testInsertarObjetoDentroDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		RecursoMineral mineral = new RecursoMineral(1000);
		PosicionMapa posicion = new PosicionMapa(1,1,0);
		
		mapa.colocarObjeto(posicion, mineral);
		
		assertEquals(mineral, mapa.contenido(posicion));		
	}
	
	@Test
	public void testNoDebeInsertarObjetoFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		RecursoMineral mineral = new RecursoMineral(1000);
		PosicionMapa posicion = new PosicionMapa(0,0,0);
		
		mapa.colocarObjeto(posicion, mineral);
		
		assertFalse( mapa.esPosicionValida(posicion));
	}
	
	@Test
	public void testInsertarObjetoConTamanioEnLaEsquinaInferiorDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		PosicionMapa posicion1 = new PosicionMapa(1, 1 ,1);
		PosicionMapa posicion2 = new PosicionMapa(1, 2, 1);
		PosicionMapa posicion3 = new PosicionMapa(2, 1, 1);
		PosicionMapa posicion4 = new PosicionMapa(2, 2, 1);
		
		mapa.colocarObjeto(posicion1, barraca,barraca.tamanio());
		
		assertEquals(barraca, mapa.contenido(posicion1));
		assertEquals(barraca, mapa.contenido(posicion2));
		assertEquals(barraca, mapa.contenido(posicion3));
		assertEquals(barraca, mapa.contenido(posicion4));		
	}
	
	@Test
	public void testInsertarObjetoConTamanioEnLaEsquinaSuperiorDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		
		PosicionMapa posicion1 = new PosicionMapa(9, 9 ,1);
		PosicionMapa posicion2 = new PosicionMapa(9, 10, 1);
		PosicionMapa posicion3 = new PosicionMapa(10, 9, 1);
		PosicionMapa posicion4 = new PosicionMapa(10, 10, 1);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertEquals(barraca, mapa.contenido(posicion1));
		assertEquals(barraca, mapa.contenido(posicion2));
		assertEquals(barraca, mapa.contenido(posicion3));
		assertEquals(barraca, mapa.contenido(posicion4));		
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		PosicionMapa posicionBarraca = new PosicionMapa(16,3,1);
		
		Posicion posicion1 = new Posicion(16, 3);		
		Posicion posicion2 = new Posicion(16, 4);
		Posicion posicion3 = new Posicion(17, 3);
		Posicion posicion4 = new Posicion(17, 4);
		
		mapa.colocarObjeto(posicionBarraca, barraca, barraca.tamanio());
		
		assertFalse( mapa.esPosicionValida(posicion1));
		assertFalse( mapa.esPosicionValida(posicion2));
		assertFalse( mapa.esPosicionValida(posicion3));
		assertFalse( mapa.esPosicionValida(posicion4));
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioEnElBordeInferiorFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		PosicionMapa posicionBarraca = new PosicionMapa(0,0,2);
		
		Posicion posicion1 = new Posicion(0, 0);
		Posicion posicion2 = new Posicion(0, 1);
		Posicion posicion3 = new Posicion(1, 0);
		PosicionMapa posicion4 = new PosicionMapa(1, 1, 2);
		
		mapa.colocarObjeto(posicionBarraca, barraca, barraca.tamanio());
		
		assertFalse( mapa.esPosicionValida(posicion1));
		assertFalse( mapa.esPosicionValida(posicion2));
		assertFalse( mapa.esPosicionValida(posicion3));
		assertTrue( mapa.hayVacio(posicion4));
	}
	
	@Test
	public void testNoDebeInsertarObjetoConTamanioEnElBordeSuperiorSaliendoseDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		PosicionMapa posicion1 = new PosicionMapa(10, 10, 1);
		PosicionMapa posicion2 = new PosicionMapa(10, 11, 1);
		PosicionMapa posicion3 = new PosicionMapa(11, 10, 1);
		PosicionMapa posicion4 = new PosicionMapa(11, 11, 1);
		
		mapa.colocarObjeto(posicion1, barraca, barraca.tamanio());
		
		assertTrue( mapa.hayVacio(posicion1));
		assertFalse( mapa.esPosicionValida(posicion2));
		assertFalse( mapa.esPosicionValida(posicion3));
		assertFalse( mapa.esPosicionValida(posicion4));
	}
	
	@Test
	public void testIntercambiarObjetosSinTamanioDePosicion(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		UnidadMarine marine1 = new UnidadMarine();
		UnidadMarine marine2 = new UnidadMarine();
		
		PosicionMapa posicion1 = new PosicionMapa(1,5,1);
		PosicionMapa posicion2 = new PosicionMapa(8,7,2);
		
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
		
		PosicionMapa posicion1 = new PosicionMapa(1,5,2);
		PosicionMapa posicion2 = new PosicionMapa(-2,4,2);
		
		mapa.colocarObjeto(posicion1, marine);
		
		mapa.intercambiarObjetos(posicion1, posicion2);
		
		assertEquals(mapa.contenido(posicion1), marine);
		assertFalse(mapa.esPosicionValida(posicion2));		
	}
	
	@Test
	public void testRemoverObjeto(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		
		UnidadMarine marine = new UnidadMarine();
		
		PosicionMapa posicion = new PosicionMapa(1,5,0);
		
		mapa.colocarObjeto(posicion, marine);
		mapa.removerObjeto(posicion);
		
		assertTrue(mapa.hayVacio(posicion));	
	}
	
	@Test
	public void testRemoverUnaPosicionVacia(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
				
		PosicionMapa posicion = new PosicionMapa(1,5, 2);
		mapa.removerObjeto(posicion);
		
		assertTrue(mapa.hayVacio(posicion));	
	}
	
	@Test
	public void testRemoverUnaPosicionFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
				
		PosicionMapa posicion = new PosicionMapa(12,15,0);
		mapa.removerObjeto(posicion);
		
		assertFalse(mapa.esPosicionValida(posicion));
	}
}
