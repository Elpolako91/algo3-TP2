package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJugador {
	
	@Test 
	public void testCrearJugador(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		assertEquals(jugador.nombre(), "facu");
		assertEquals(jugador.color(),"rojo");
		assertEquals(jugador.raza(), "terran");
	}
}
