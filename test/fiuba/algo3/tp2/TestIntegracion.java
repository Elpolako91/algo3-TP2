package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntegracion {

	@Test
	public void TestDosJugadoresCreanEdificioDeUnidadesYUnidadesBasicasSeMuevenYAtacan(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		Jugador jugador2 = juego.cargarJugador("tincho", "azul", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral1 = (EdificioCentralTerran) jugador1.edificioCentral();
		EdificioCentralProtos edCentral2 = (EdificioCentralProtos) jugador2.edificioCentral();
		
		EdificioBarraca barraca = edCentral1.construirBarraca();
		Posicion posicion1 = new Posicion(4,1);
		jugador1.construirEdificio(posicion1, barraca);
		jugador1.pasarTurno();
		
		EdificioAcceso acceso = edCentral2.construirAcceso();		
		Posicion posicion2 = new Posicion(5,5);
		jugador2.construirEdificio(posicion2, acceso);
		jugador2.pasarTurno();
		
		for (int i= 0; i < 11; i++){
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}	
		
		UnidadMarine marine = barraca.construirMarine();
		jugador1.pasarTurno();
		UnidadZealot zealot = acceso.construirZealot();
		jugador2.pasarTurno();
		
		for (int i= 0; i < 3; i++){
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}
		
		Posicion posicionDestinoMarine = new Posicion(6,3);
		Posicion posicionIntermediaZealot = new Posicion(7,4);
		Posicion posicionDestinoZealot = new Posicion(6,4);
		
		
		jugador1.moverUnidad(marine, posicionDestinoMarine);
		jugador1.pasarTurno();
		
		jugador2.moverUnidad(zealot, posicionIntermediaZealot);
		jugador2.pasarTurno();
		
		jugador1.atacarTierra(marine, posicionIntermediaZealot);
		jugador1.pasarTurno();
		
		assertEquals(zealot.escudoActual(),94);
		
		jugador2.atacarTierra(zealot, posicionDestinoMarine);
		
		assertEquals(marine.vidaActual(), 40);
		
		jugador2.moverUnidad(zealot, posicionDestinoZealot);
		jugador2.atacarTierra(zealot, posicionDestinoMarine);
		
		assertEquals(marine.vidaActual(), 32);
	}
		
	
	/************************* COMO GUIA FALTA REFACTORIZAR ******************************/
	
	/*
	@Test
	public void TestJugadoresConUnEdificioYunSoldado(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu","rojo","terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.cargarMapa(new Mapa(new Tamanio (100,100)));
		
		juego.iniciarPartida();
	
		Posicion posicionBarraca1 = new Posicion(12,15);
		Posicion posicionBarraca2 = new Posicion(95,95);
		Posicion posicion3 = new Posicion(97,94);
		
		EdificioBarraca barraca1 = new EdificioBarraca();
		jugador1.construirEdificio(posicionBarraca1,barraca1);
		jugador1.pasarTurno();
				
		EdificioBarraca barraca2 = new EdificioBarraca();
		jugador2.construirEdificio(posicionBarraca2, barraca2);
		jugador2.pasarTurno();
						
		UnidadMarine marine = jugador1.construirUnidad(barraca1);
		jugador1.pasarTurno();
		
		jugador2.construirUnidad(barraca2);
		jugador2.moverUnidadTerrestre(marine2,posicion3);
		jugador2.pasarTurno();

		while(marine1.posicion().distancia(marine2.posicion())!=1){
			
			jugador1.moverUnidad(marine1,marine2.posicion());
			jugador1.pasarTurno();		
		
			jugador2.moverUnidad(marine2,marine1.posicion());
			jugador2.pasarTurno();
		}
		
		while(jugador2.unidades()!=0){
			jugador1.atacar(marine1, marine2.posicion());
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}
		assertTrue(juego.mapa().contenido(marine2.posicion()) instanceof Vacio);
	}
	
	*/

}
