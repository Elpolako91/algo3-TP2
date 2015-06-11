package fiuba.algo3.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestJuegoCraft {
	
	@Test
	public void testCrearJuegoConJugadores(){

		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();

		assertEquals(jugador1.nombre(),"facu");
		assertEquals(jugador2.nombre(),"tincho");
		assertFalse(juego.mapa().estaVacio());
	}
}
