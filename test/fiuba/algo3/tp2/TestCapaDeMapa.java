package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.objetosDelMapa.*;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;

public class TestCapaDeMapa {
	
	private CapaDeMapa capa;
	
	@Before
	public void setUp(){
		capa = new CapaDeMapa(new Tamanio(5,8));
	}
	
	@Test
	public void testCrearCapaDeMapa(){
				
		assertEquals(capa.tamanio().enX(),5);
		assertEquals(capa.tamanio().enY(),8);
	}
	
	@Test
	public void testContenidoDePosicionValida(){
		
		try {
			for (int i = 1; i <= 5; i++)
				for (int j = 1; j <= 8; j++)
						assertTrue(capa.contenido(new Posicion(i,j)) instanceof Vacio);
						
		} catch (PosicionInvalida e) {			
			assertTrue(false);
		}
	}
	
	@Test
	public void testContenidoDePosicionInvalida(){
		
		try {
			capa.contenido(new Posicion(0,0));
			assertTrue(false);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testColocarObjeto(){
		
		Posicion posicionTerreno = new Posicion(5,5);
		try {
			capa.colocarObjeto(posicionTerreno, new Terreno());
			assertTrue(capa.contenido(posicionTerreno) instanceof Terreno);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testColocarObjetoFueraDelMapa(){
		
		Posicion posicionTerreno = new Posicion(8,8);
		try {
			capa.colocarObjeto(posicionTerreno, new Terreno());
			assertTrue(false);		
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testNoDebeColocarObjetoArribaDeOtro(){
		
		Posicion posicionTerreno = new Posicion(5,2);
		try {
			capa.colocarObjeto(posicionTerreno, new Terreno());
			capa.colocarObjeto(posicionTerreno, new RecursoMineral(1000));
			
			assertTrue(false);
						
		} catch (PosicionInvalida e) {}
		
		try {
			assertTrue(capa.contenido(posicionTerreno) instanceof Terreno);
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testColocarObjetoConTamanio(){
		
		Posicion posicionEdificio =new Posicion(2,2);
		EdificioDeposito edificio = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio, edificio, edificio.tamanio());
				
		} catch (PosicionInvalida e1) {
			assertTrue(false);
		}		
	}
	
	@Test
	public void testNoDebeColocarObjetoConTamanioEncimaDeOtroObjetoConTamanio(){
		
		Posicion posicionEdificio =new Posicion(2,2);
		EdificioDeposito edificio1 = new EdificioDeposito();
		EdificioDeposito edificio2 = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio, edificio1, edificio1.tamanio());
				capa.colocarObjeto(posicionEdificio, edificio2, edificio2.tamanio());
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertEquals(capa.contenido(posicionEdificio), edificio1);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testNoDebeColocarObjetoConTamanioEncimaDeOtroConTamanioBis(){
		
		Posicion posicionEdificio1 =new Posicion(3,3);
		Posicion posicionEdificio2 =new Posicion(2,2);
		EdificioDeposito edificio1 = new EdificioDeposito();
		EdificioDeposito edificio2 = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio1, edificio1, edificio1.tamanio());
				capa.colocarObjeto(posicionEdificio2, edificio2, edificio2.tamanio());
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertEquals(capa.contenido(posicionEdificio1), edificio1);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testNoDebeColocarObjetoConTamanioFueraDelMapa(){
		
		Posicion posicionEdificio =new Posicion(5,8);
		EdificioDeposito edificio = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio, edificio, edificio.tamanio());
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertTrue(capa.contenido(posicionEdificio) instanceof Vacio);
		} catch (PosicionInvalida e) {}
	}
		
	@Test
	public void testNoDebeColocarObjetoConTamanioFueraDelMapaBis(){
		
		Posicion posicionEdificio =new Posicion(0,0);
		EdificioDeposito edificio = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio, edificio, edificio.tamanio());
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertTrue(capa.contenido(new Posicion(1,1)) instanceof Vacio);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testRemoverObjeto(){
		
		Posicion posicion =new Posicion(1,1);
		Terreno terreno = new Terreno();
				
		try {
				capa.colocarObjeto(posicion, terreno);
				capa.removerObjeto(posicion);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertTrue(capa.contenido(posicion) instanceof Vacio);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testRemoverPosicionFueraDelMapa(){
		
		Posicion posicion =new Posicion(10,1);
				
		try {
				capa.removerObjeto(posicion);
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
	}
	
	@Test
	public void testRemoverObjetoConTamanio(){
		
		Posicion posicionEdificio =new Posicion(1,1);
		EdificioDeposito edificio = new EdificioDeposito();
				
		try {
				capa.colocarObjeto(posicionEdificio, edificio, edificio.tamanio());
				capa.removerObjeto(posicionEdificio, edificio.tamanio());
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertTrue(capa.contenido(posicionEdificio) instanceof Vacio);
			assertTrue(capa.contenido(new Posicion(2,2)) instanceof Vacio);
			assertTrue(capa.contenido(new Posicion(1,2)) instanceof Vacio);
			assertTrue(capa.contenido(new Posicion(2,1)) instanceof Vacio);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testIntercambiarObjetos(){
		
		Posicion posicion1 =new Posicion(1,1);
		Posicion posicion2 =new Posicion(3,3);
		Terreno terreno1 = new Terreno();
		Terreno terreno2 = new Terreno();
				
		try {
				capa.colocarObjeto(posicion1, terreno1);
				capa.colocarObjeto(posicion2, terreno2);
				capa.intercambiarObjetos(posicion1, posicion2);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertEquals(capa.contenido(posicion1), terreno2);
			assertEquals(capa.contenido(posicion2), terreno1);
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testNoDebeIntercambiarConPosicionInvalidaObjetos(){
		
		Posicion posicion1 =new Posicion(1,1);
		Posicion posicion2 =new Posicion(9,9);
		Terreno terreno1 = new Terreno();
				
		try {
				capa.colocarObjeto(posicion1, terreno1);
				capa.intercambiarObjetos(posicion1, posicion2);
				
				assertTrue(false);
				
		} catch (PosicionInvalida e1) {}
		
		try {
			assertEquals(capa.contenido(posicion1), terreno1);
		} catch (PosicionInvalida e) {}
	}
}