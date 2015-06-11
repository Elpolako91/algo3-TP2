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
	
	@Test
	public void testJugadoresPasanTurnos(){
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();		
		assertTrue(juego.turno() == jugador1);
		
		jugador1.pasarTurno();		
		assertTrue(juego.turno() == jugador2);
		
		jugador2.pasarTurno();		
		assertTrue(juego.turno() == jugador1);		
	}
	
	@Test
	public void testJugadorNoPuedePasarTurnoSinoEsSuTurno(){
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();		
		assertTrue(juego.turno() == jugador1);
		
		jugador1.pasarTurno();		
		assertTrue(juego.turno() == jugador2);
		
		jugador1.pasarTurno();		
		assertTrue(juego.turno() == jugador2);		
	}
	
	@Test
	public void testJugadorColocaBarracaYGastaRecursos(){
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();		
		Barraca barraca = new Barraca();
		jugador1.colocarEdificio(new Posicion(1,5), barraca);
		
		assertEquals(jugador1.recursos().mineral(), 850);
		assertEquals(jugador1.recursos().vespeno(), 1000);
	}
	
	@Test
	public void testJugadorColocaBarracaYUnidadYGastaRecursos(){
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();		
		Barraca barraca = new Barraca();
		jugador1.colocarEdificio(new Posicion(1,5), barraca);
		jugador1.construirMarine(barraca);
		
		
		assertEquals(jugador1.recursos().mineral(), 800);
		assertEquals(jugador1.recursos().vespeno(), 1000);
	}
}
