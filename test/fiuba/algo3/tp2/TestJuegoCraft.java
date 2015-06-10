package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestJuegoCraft {
	
	@Test
	public void testCrearJuegoConJugadores(){

		JuegoCraft juego = new JuegoCraft();
		Mapa mapa = new Mapa(1000);
		Jugador jugador1 = new Jugador("facu","rojo","terran");
		Jugador jugador2 = new Jugador("tincho","verde","protos");
		
		juego.crearPartida(jugador1, jugador2, mapa);

		assertEquals(jugador1.nombre(),"facu");
		assertEquals(jugador2.nombre(),"tincho");

		Assert.assertFalse(juego.mapaestavacio());
		assertFalse(juego.mapaestavacio());
		assertFalse(jugador1.juego().mapaestavacio());
		
	}
}
