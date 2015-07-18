package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;

public class TestJugador {
	
	/**************** Los Siguientes Test no prueban las cosas bien en general **************/
	
	@Test 
	public void testCrearJugador(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		assertEquals(jugador.nombre(), "facu");
		assertEquals(jugador.color(),"rojo");
		assertEquals(jugador.raza(), "terran");
		assertEquals(jugador.suministros().suministroTotal(), 5);
	}
	
	@Test 
	public void testJugadorAgregarEdificio(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		jugador.agregarEdificio(barraca);
		
		assertEquals(jugador.edificios(), 1);
	}
	
	@Test 
	public void testJugadorEliminarEdificio(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		jugador.agregarEdificio(barraca);
		jugador.eliminarEdificio(barraca);
		
		assertEquals(jugador.edificios(), 0);		
	}
	
	@Test 
	public void testJugadorAgregarUnidad(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		jugador.suministros().agregar(10);
		jugador.recursos().agregar(new RecursosDelJugador(1000, 1000));
		
		UnidadMarine marine = new UnidadMarine();
		
		
		try {
			jugador.agregarUnidad(marine);
		} catch (RecursosInsuficientes e) {}
		
		assertEquals(jugador.unidades(), 1);
		assertEquals(jugador.suministros().suministroGastados(), 1);
		assertEquals(jugador.recursos().mineral(), 950);
	}
		
	@Test 
	public void testJugadorEliminarUnidad(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		jugador.suministros().agregar(10);
		jugador.recursos().agregar(new RecursosDelJugador(1000, 1000));
		
		UnidadMarine marine = new UnidadMarine();
		try {
			jugador.agregarUnidad(marine);
		} catch (RecursosInsuficientes e) {}
		
		jugador.eliminarUnidad(marine);
		
		assertEquals(jugador.unidades(), 0);				
	}
	

	
	/*
	@Test
	public void testJugadorNoPuedePasarTurnoSinoEsSuTurno(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		
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
		EdificioBarraca barraca = new EdificioBarraca();
		jugador1.construirEdificio(new Posicion(1,5), barraca);
		
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
		EdificioBarraca barraca = new EdificioBarraca();
		jugador1.construirEdificio(new Posicion(1,5), barraca);
		jugador1.construirMarine(barraca);
		
		
		assertEquals(jugador1.recursos().mineral(), 800);
		assertEquals(jugador1.recursos().vespeno(), 1000);
	}
	*/
}
