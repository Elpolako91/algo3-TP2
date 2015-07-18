package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTurno {
	
	@Test
	public void DosJugadoresIniciaJugadorUno(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Turno turno = new Turno(jugadores);
		
		assertEquals(turno.jugadorActual(), jugador1);
	}
	
	@Test
	public void DosJugadoresPasarUnTurno(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Turno turno = new Turno(jugadores);
		
		turno.pasarTurno();
		assertEquals(turno.jugadorActual(), jugador2);
	}
	
	@Test
	public void DosJugadoresPasarDosTurnos(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		Turno turno = new Turno(jugadores);
		
		turno.pasarTurno();
		turno.pasarTurno();
		assertEquals(turno.jugadorActual(), jugador1);
	}
	
	@Test
	public void TresjugadoresPasarUnTurno(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		Jugador jugador3 = new Jugador("arian","azul","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		Turno turno = new Turno(jugadores);
		
		turno.pasarTurno();
		assertEquals(turno.jugadorActual(), jugador2);
	}
	
	@Test
	public void TresjugadoresPasarDosTurno(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		Jugador jugador3 = new Jugador("arian","azul","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		Turno turno = new Turno(jugadores);
		
		turno.pasarTurno();
		turno.pasarTurno();
		assertEquals(turno.jugadorActual(), jugador3);
	}
	
	@Test
	public void TresjugadoresPasarTresTurno(){
		
		List<Jugador> jugadores = new ArrayList<Jugador> ();
		Jugador jugador1 = new Jugador("tincho","verde","terran");
		Jugador jugador2 = new Jugador("facu","rojo","terran");
		Jugador jugador3 = new Jugador("arian","azul","terran");
		
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		Turno turno = new Turno(jugadores);
		
		turno.pasarTurno();
		turno.pasarTurno();
		turno.pasarTurno();
		assertEquals(turno.jugadorActual(), jugador1);
	}

}
