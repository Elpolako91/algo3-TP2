package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAtaque {

	@Test
	public void testUnidadesSeDanianUnaAlLadoDeLaOtra() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		Barraca barraca = new Barraca();
		
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
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		Barraca barraca = new Barraca();
		
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
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		Barraca barraca = new Barraca();
		
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
		Jugador jugador1 = juego.cargarJugadorUno("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugadorDos("tincho","verde","terran");
		juego.crearMapa(100);
		
		juego.iniciarPartida();
		Barraca barraca = new Barraca();
		
		Posicion posicionBarraca = new Posicion(50,50);
		Posicion posicionDestinoUnidad1 = new Posicion(60,50);
		Posicion PosicionDestinoUnidad2 = new Posicion(60,54);
		
		jugador1.construirEdificio(posicionBarraca, barraca);
		UnidadTerran unidad1 = jugador1.construirMarine(barraca);
		UnidadTerran unidad2 = jugador1.construirMarine(barraca);
		jugador1.moverUnidad(unidad2, PosicionDestinoUnidad2);
		jugador1.moverUnidad(unidad1, posicionDestinoUnidad1);
		
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		jugador1.atacar(unidad1, unidad2.posicion());
		
		assertEquals(jugador1.unidades(),1);
		assertTrue(juego.mapa().contenido(unidad2.posicion())instanceof Terreno);
	}

}
