package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;

public class TestPosicion {
	
	@Test
	public void TestDistanciaEntrePosicionesIgualesEsCero(){
		
		Posicion p1 = new Posicion(3,3);
		Posicion p2 = new Posicion(3,3);
		
		int distancia = p1.distancia(p2);
		assertEquals(distancia, 0);
	}
	
	@Test
	public void TestDistanciaEntrePosiciones(){
		
		Posicion p1 = new Posicion(3,3);
		Posicion p2 = new Posicion(5,5);
		
		int distancia = p1.distancia(p2);
		assertEquals(distancia, 4);
	}
	
	@Test
	public void TestDireccionEntrePuntos(){
		
		Posicion posicion1= new Posicion(3,4);
		Posicion posicion2 = new Posicion(6,5);
		
		Posicion direccion= posicion1.direccion(posicion2);
		
		assertEquals(direccion.x(), 4);
		assertEquals(direccion.y(), 5);
	}
	
	@Test
	public void TestObtenerUnaNuevaPosicionMovidaConRespectoAlaOtra(){
		
		Posicion posicion = new Posicion(2,4);
		
		posicion = posicion.obtenerNuevaMovidaEn(7,-5);
		
		assertEquals(posicion.x(), 9);
		assertEquals(posicion.y(), -1);
	}
	
	@Test
	public void TestPosicionDentroDeTamanio(){
		
		Posicion posicion = new Posicion(2,4);
		
		Tamanio tamanio = new Tamanio(3,5);
		
		assertTrue(posicion.estaDentro(tamanio));
	}
	
	@Test
	public void TestPosicionFueraDeTamanio(){
		
		Posicion posicion = new Posicion(0,2);
		
		Tamanio tamanio = new Tamanio(3,5);
		
		assertTrue(!posicion.estaDentro(tamanio));
	}
	
	@Test
	public void TestPosicionEspiral(){
		
		Posicion p1 = new Posicion(6,10);
		Posicion p2 = new Posicion(5,9);
		Posicion p3 = new Posicion(6,9);
		
		Posicion p4 = p1.posicionEnEspiral(p2);
		assertEquals(p3, p4);
	}
	
	@Test
	public void TestPosicionEspiralBis(){
		
		Posicion p1 = new Posicion(6,10);
		Posicion p2 = new Posicion(10,10);
		Posicion p3 = new Posicion(10,11);
		
		Posicion p4 = p1.posicionEnEspiral(p2);
		assertEquals(p3, p4);
	}
}