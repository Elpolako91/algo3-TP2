package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPosicion {
	
	@Test
	public void TestDistanciaEntrePosiciones(){
		
		Posicion p1 = new Posicion(3,3);
		Posicion p2 = new Posicion(5,5);
		
		int distancia = p1.distancia(p2);
		assertEquals(distancia, 4);
			
	}
	
	@Test
	public void TestDireccionEntrePuntos(){
		Posicion p1= new Posicion(3,4);
		Posicion p2 = new Posicion(856,645);
		
		Posicion direccion1= p1.direccion(p2);
		assertEquals(direccion1.x(),4);
		assertEquals(direccion1.y(),5);
		
		Posicion direccion2= p2.direccion(p1);
		assertEquals(direccion2.x(),855);
		assertEquals(direccion2.y(),644);
	}

}
