package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;

public class TestMapa {

	private Mapa mapa;
	
	@Before
	public void setUp(){
		
		mapa = new Mapa(new Tamanio(10,10));		
	}
	
	
	@Test
	public void testConsultarTamanio(){
				
		assertEquals(mapa.tamanio().enX(),10);
		assertEquals(mapa.tamanio().enY(),10);
	}
	
	@Test
	public void testMapaTieneVacio() {
				
		for (int i=1; i<=10; i++)
			for(int j=1; j<=10; j++){
				
				try {
					assertTrue(mapa.contenido(new Posicion(i,j),  mapa.suelo) instanceof Vacio);
					assertTrue(mapa.contenido(new Posicion(i,j),  mapa.tierra) instanceof Vacio);
					assertTrue(mapa.contenido(new Posicion(i,j),  mapa.aire) instanceof Vacio);
					
				} catch (PosicionInvalida e) {
					assertTrue(false);
				}				
		}		
	}	
	
	@Test
	public void testPosicionInvalidaEnElMapa(){
		
		for (int i=-2; i<=12;i++)
			try {
				mapa.contenido(new Posicion(0,i), mapa.suelo);
				assertTrue(false);
				
			} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testColocarObjetoEnSuelo(){
		
		Terreno terreno = new Terreno();
		Posicion posicion = new Posicion(1,1);
		
		try {
			mapa.colocarObjeto(posicion, mapa.suelo, terreno);
			assertEquals(terreno, mapa.contenido(posicion, mapa.suelo));
			
		} catch (PosicionInvalida e) {}				
	}
	
	@Test
	public void testColocarObjetoEnTierra(){
		
		Terreno terreno = new Terreno();
		Posicion posicion = new Posicion(1,1);
		
		try {
			mapa.colocarObjeto(posicion, mapa.tierra, terreno);
			assertEquals(terreno, mapa.contenido(posicion, mapa.tierra));
			
		} catch (PosicionInvalida e) {}				
	}
	
	@Test
	public void testColocarObjetoEnAire(){
		
		Terreno terreno = new Terreno();
		Posicion posicion = new Posicion(1,1);
		
		try {
			mapa.colocarObjeto(posicion, mapa.aire, terreno);
			assertEquals(terreno, mapa.contenido(posicion, mapa.aire));
			
		} catch (PosicionInvalida e) {}				
	}
	
	@Test
	public void testNoDebeInsertarObjetoFueraDelMapa(){
		
		Terreno terreno = new Terreno();
		Posicion posicion = new Posicion(0,0);
		
		try {
			mapa.colocarObjeto(posicion, mapa.aire, terreno);
			assertTrue(false);
			
		} catch (PosicionInvalida e) {}
		
		try {
			assertTrue(mapa.contenido(posicion, mapa.aire) instanceof Vacio);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testInsertarObjetoConTamanio(){
		
		EdificioDeposito edificio = new EdificioDeposito();
		Posicion posicion = new Posicion(1, 1);
		
		try {
			mapa.colocarObjeto(posicion, mapa.tierra, edificio, edificio.tamanio());
			
			assertEquals(edificio, mapa.contenido(posicion, mapa.tierra));
			assertEquals(edificio, mapa.contenido(posicion.obtenerNuevaMovidaEn(1, 0), mapa.tierra));
			assertEquals(edificio, mapa.contenido(posicion.obtenerNuevaMovidaEn(0, 1), mapa.tierra));
			assertEquals(edificio, mapa.contenido(posicion.obtenerNuevaMovidaEn(1, 1), mapa.tierra));
			
		} catch (PosicionInvalida e) {}				
	}
		
	@Test
	public void testNoDebeInsertarObjetoConTamanioFueraDelMapa(){
		
		EdificioDeposito edificio = new EdificioDeposito();
		Posicion posicion = new Posicion(10, 10);
		
		try {
			mapa.colocarObjeto(posicion, mapa.tierra, edificio, edificio.tamanio());
			assertTrue(false);
			
		} catch (PosicionInvalida e) {}
		
		try {
			assertTrue(mapa.contenido(posicion, mapa.tierra) instanceof Vacio);
			
		} catch (PosicionInvalida e) {}
	}
			
	@Test
	public void testIntercambiarObjetos(){
		
		UnidadMarine marine1 = new UnidadMarine();
		UnidadMarine marine2 = new UnidadMarine();
		
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(8,7);
		
		try {
			mapa.colocarObjeto(posicion1, mapa.tierra, marine1);
			mapa.colocarObjeto(posicion2, mapa.tierra, marine2);			
			mapa.intercambiarObjetos(posicion1, posicion2, mapa.tierra);
			
			assertEquals(mapa.contenido(posicion1, mapa.tierra), marine2);
			assertEquals(mapa.contenido(posicion2, mapa.tierra), marine1);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testNoDeberiaIntercambiarConObjetoConPosicionFueraDelMapa(){
		
		UnidadMarine marine = new UnidadMarine();
		
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(-2,4);
		
		try {
			mapa.colocarObjeto(posicion1, mapa.tierra, marine);
			mapa.intercambiarObjetos(posicion1, posicion2, mapa.tierra);
			
			assertTrue(false);
			
		} catch (PosicionInvalida e) {}
				
		try {
			assertEquals(mapa.contenido(posicion1, mapa.tierra), marine);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testRemoverObjeto(){
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicion = new Posicion(1,5);
		
		try {
			mapa.colocarObjeto(posicion, mapa.tierra, marine);
			mapa.removerObjeto(posicion, mapa.tierra);
			
			assertTrue(mapa.contenido(posicion, mapa.tierra) instanceof Vacio);	
			
		} catch (PosicionInvalida e) {}					
	}
	
	@Test
	public void testRemoverUnaPosicionVacia(){
				
		Posicion posicion = new Posicion(1,5);
		try {
			mapa.removerObjeto(posicion, mapa.tierra);
			assertTrue(mapa.contenido(posicion, mapa.tierra) instanceof Vacio);
			
		} catch (PosicionInvalida e) {}			
	}
	
	@Test
	public void testRemoverUnaPosicionFueraDelMapa(){
		
		Posicion posicion = new Posicion(12,15);
		
		try {
			mapa.removerObjeto(posicion, mapa.tierra);
			
			assertTrue(false);
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testRemoverObjetoConTamanio(){
		
		Posicion posicion = new Posicion(5,6);
		EdificioDeposito edificio = new EdificioDeposito();
		
		try {
			mapa.colocarObjeto(posicion, mapa.tierra, edificio, edificio.tamanio());
			mapa.removerObjeto(posicion, mapa.tierra, edificio.tamanio());
			
			assertTrue(mapa.contenido(posicion, mapa.tierra) instanceof Vacio);
			assertTrue(mapa.contenido(posicion.obtenerNuevaMovidaEn(1, 0), mapa.tierra) instanceof Vacio);
			assertTrue(mapa.contenido(posicion.obtenerNuevaMovidaEn(0, 1), mapa.tierra) instanceof Vacio);
			assertTrue(mapa.contenido(posicion.obtenerNuevaMovidaEn(1, 1), mapa.tierra) instanceof Vacio);
			
		} catch (PosicionInvalida e) {}		
	}
	
}
