package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.mapa.Vision;

public class TestVision {
	
	private Vision vision;
	private Tamanio tamanio = new Tamanio(50,50);
	
	private Posicion posicion1 = new Posicion(25,25);
	
	@Before
	public void setUp(){
		vision = new Vision(tamanio);
	}
	
	@Test
	public void testCrearVision(){
		
		Posicion posicionActual;
		for(int i = 1; i <= tamanio.enX(); i++)
			for(int j = 1; j <= tamanio.enY();j++){
				
				posicionActual = new Posicion(i,j);				
				assertFalse(vision.hayVisibilidad(posicionActual));
			}
		assertEquals(vision.tamanio(), tamanio);		
	}
	
	@Test
	public void testPonerVisibilidad(){
		
		vision.descubrir(posicion1, 1);
		
		assertTrue(vision.hayVisibilidad(posicion1));
		assertTrue(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(1, 0)));
		assertTrue(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(0, 1)));
		assertTrue(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(-1, 0)));
		assertTrue(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(0, -1)));
		
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(-2, 0)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(0, -2)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(2, 0)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(0, 2)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(1, 1)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(1, -1)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(-1, 1)));
		assertFalse(vision.hayVisibilidad(posicion1.obtenerNuevaMovidaEn(-1, -1)));			
	}
}