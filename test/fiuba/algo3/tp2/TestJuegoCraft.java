package fiuba.algo3.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestJuegoCraft {
	
	@Test
	public void testCargarUnJugador(){

		JuegoCraft juego = new JuegoCraft();
		Jugador jugador = juego.cargarJugador("facu","rojo","terran");

		assertEquals(jugador.nombre(),"facu");		
		assertTrue(juego.jugadores()==1);
	}
	
	@Test
	public void testCargarDosJugadores(){

		JuegoCraft juego = new JuegoCraft();
		juego.cargarJugador("facu","rojo","terran");
		juego.cargarJugador("tincho","verde","terran");		
		
		assertTrue(juego.jugadores()==2);
	}
	
	@Test
	public void testNoDeberiaCargarDosJugadoresConMismoNombre(){

		JuegoCraft juego = new JuegoCraft();
		juego.cargarJugador("facu","rojo","terran");
		juego.cargarJugador("facu","verde","terran");
		
		assertTrue(juego.jugadores()==1);
	}
	
	@Test
	public void testNoDeberiaCargarDosJugadoresConMismoColor(){

		JuegoCraft juego = new JuegoCraft();
		juego.cargarJugador("facu","rojo","terran");
		juego.cargarJugador("thincho","rojo","terran");
		
		assertTrue(juego.jugadores()==1);
	}
	
	
}
