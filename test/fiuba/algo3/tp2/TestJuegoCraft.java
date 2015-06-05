package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestJuegoCraft {
	
	@Test
	public void testCrearJuegoConJugadores(){

		JuegoCraft juego = new JuegoCraft();
		juego.cargarJugador1("facu","rojo","terran");
		juego.cargarJugador2("tincho","verde","protos");

		assertEquals(juego.jugador1Nombre(),"facu");
		assertEquals(juego.jugador2Nombre(),"tincho");

		Assert.assertFalse(juego.mapaestavacio());
		
	}
	

}
