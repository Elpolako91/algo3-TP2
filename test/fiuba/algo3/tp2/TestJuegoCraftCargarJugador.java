package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Jugador;

public class TestJuegoCraftCargarJugador {
	
	@Test
	public void testCargarUnJugador(){

		JuegoCraft juego = new JuegoCraft();
		
		try{
			Jugador jugador = juego.cargarJugador("facu","rojo","terran");
			assertEquals(jugador.nombre(),"facu");
			assertEquals(jugador.color(), "rojo");
			assertEquals(jugador.raza(), "terran");
		}
		catch(CargaJugadorInvalida e){}
		
		assertTrue(juego.jugadores().size()==1);
	}
	
	@Test
	public void testCargarDosJugadores(){

		JuegoCraft juego = new JuegoCraft();
		
		try{
			juego.cargarJugador("facu","rojo","terran");
			juego.cargarJugador("tincho","verde","terran");	
		}
		catch(CargaJugadorInvalida e){}
		
		assertTrue(juego.jugadores().size()==2);
	}
	
	@Test
	public void testNoDeberiaCargarDosJugadoresConMismoNombre(){

		JuegoCraft juego = new JuegoCraft();
		
		try{		
			juego.cargarJugador("facu","rojo","terran");
			juego.cargarJugador("facu","verde","terran");
		}
		catch(CargaJugadorInvalida e){}
		
		assertTrue(juego.jugadores().size() == 0);
	}
	
	@Test
	public void testNoDeberiaCargarDosJugadoresConMismoColor(){

		JuegoCraft juego = new JuegoCraft();
		
		try{
			juego.cargarJugador("facu","rojo","terran");
			juego.cargarJugador("thincho","rojo","terran");
		}
		catch(CargaJugadorInvalida e){}
		
		assertTrue(juego.jugadores().size() == 0);
	}
	
	
}
