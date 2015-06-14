package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAtaque {

	/********************* Test Viejo Q nos sirve como guia para integracion ******************/
	
	@Test
	public void testUnidadesSeDanianUnaAlLadoDeLaOtra() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		EdificioBarraca barraca = new EdificioBarraca();
		
		Posicion posicionBarraca = new Posicion(50,50);
		Posicion posicionDestinoUnidad1 = new Posicion(60,50);
		Posicion PosicionDestinoUnidad2 = new Posicion(60,51);
		
		jugador1.construirEdificio(posicionBarraca, barraca);
		UnidadTerran unidad1 = jugador1.construirMarine(barraca);
		UnidadTerran unidad2 = jugador1.construirMarine(barraca);
		jugador1.moverUnidad(unidad2, PosicionDestinoUnidad2);
		jugador1.moverUnidad(unidad1, posicionDestinoUnidad1);
		
		jugador1.atacar(unidad1, unidad2.posicion());
		
		assertEquals(34, unidad2.vidaActual());		
	}
	
	@Test
	public void testUnidadesSeDanianADistancia() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		EdificioBarraca barraca = new EdificioBarraca();
		
		Posicion posicionBarraca = new Posicion(50,50);
		Posicion posicionDestinoUnidad1 = new Posicion(60,50);
		Posicion PosicionDestinoUnidad2 = new Posicion(60,54);
		
		jugador1.construirEdificio(posicionBarraca, barraca);
		UnidadTerran unidad1 = jugador1.construirMarine(barraca);
		UnidadTerran unidad2 = jugador1.construirMarine(barraca);
		jugador1.moverUnidad(unidad2, PosicionDestinoUnidad2);
		jugador1.moverUnidad(unidad1, posicionDestinoUnidad1);
		
		jugador1.atacar(unidad1, unidad2.posicion());
		
		assertEquals(34, unidad2.vidaActual());		
	}
	
	@Test
	public void testUnidadIntentaAtacarFueraDeSuRango() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		EdificioBarraca barraca = new EdificioBarraca();
		
		Posicion posicionBarraca = new Posicion(50,50);
		Posicion posicionDestinoUnidad1 = new Posicion(60,50);
		Posicion PosicionDestinoUnidad2 = new Posicion(60,55);
		
		jugador1.construirEdificio(posicionBarraca, barraca);
		UnidadTerran unidad1 = jugador1.construirMarine(barraca);
		UnidadTerran unidad2 = jugador1.construirMarine(barraca);
		jugador1.moverUnidad(unidad2, PosicionDestinoUnidad2);
		jugador1.moverUnidad(unidad1, posicionDestinoUnidad1);
		
		jugador1.atacar(unidad1, unidad2.posicion());
		
		assertEquals(40, unidad2.vidaActual());		
	}
	
	@Test
	public void testUnidadMataAOtraUnidad() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		EdificioBarraca barraca1 = new EdificioBarraca();
		EdificioBarraca barraca2 = new EdificioBarraca();
		
		Posicion posicionBarraca1 = new Posicion(4,4);
		Posicion posicionBarraca2 = new Posicion(70,70);
		Posicion posicionDestinoUnidad1 = new Posicion(60,50);
		Posicion posicionIntermedioUnidad2 = new Posicion(72,60);
		Posicion posicionDestinoUnidad2 = new Posicion(60,51);
		
		jugador1.construirEdificio(posicionBarraca1, barraca1);
		UnidadTerran marine1 = jugador1.construirMarine(barraca1);
		jugador1.moverUnidad(marine1, posicionDestinoUnidad1);
		jugador1.moverUnidad(marine1, posicionDestinoUnidad1);
		jugador1.pasarTurno();
		
		jugador2.construirEdificio(posicionBarraca2, barraca2);
		UnidadMarine marine2 = jugador2.construirMarine(barraca2);
		jugador2.moverUnidad(marine2, posicionIntermedioUnidad2);
		jugador2.moverUnidad(marine2, posicionDestinoUnidad2);
		jugador2.pasarTurno();
		
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());
		jugador1.atacar(marine1, marine2.posicion());

		assertEquals(jugador1.unidades(),1);

		assertEquals(marine2.vidaActual(),0);

		assertEquals(jugador2.unidades(),0);
		assertTrue(juego.mapa().contenido(marine2.posicion())instanceof Vacio);

	}

}