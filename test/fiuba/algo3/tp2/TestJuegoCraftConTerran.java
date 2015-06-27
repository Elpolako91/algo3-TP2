package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJuegoCraftConTerran {
	
	@Test
	public void TestJuegoSeInicia(){
		
		JuegoCraft juego = new JuegoCraft();
		
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(8,8);
		
		assertEquals(jugador1.edificioCentral().posicion(), posicion1);
		assertEquals(jugador2.edificioCentral().posicion(), posicion2);
	}
	
	@Test
	public void TestJugadorCreaCentroDeMineral(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioCentroMineral centroDeMineral = edCentral.construirRecolectorMineral();
		
		Posicion posicion = new Posicion(1,10);
		
		jugador1.construirEdificio(posicion, centroDeMineral);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 4; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.recursos().mineral(),950);
		
		for (int i= 0; i < 5; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.recursos().mineral(),1000);
	}
	
	@Test
	public void TestJugadorCreaRefineria(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioRefineria refineria = edCentral.construirRecolectorGasVespeno();
		
		Posicion posicion = new Posicion(10,1);
		
		jugador1.construirEdificio(posicion, refineria);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 6; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.recursos().mineral(),900);
		assertEquals(jugador1.recursos().vespeno(),1000);
		
		for (int i= 0; i < 5; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.recursos().vespeno(),1050);
	}
	
	@Test
	public void TestJugadorCreaDepositoDeSuministro(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioDeposito deposito = edCentral.construirAsentamiento();
		int suministroInicial = jugador1.suministros().suministroTotal();
		Posicion posicion = new Posicion(5,5);
		
		jugador1.construirEdificio(posicion, deposito);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 6; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.suministros().suministroTotal(), suministroInicial+5);
	}
	
	@Test
	public void TestJugadorCreaBarraca(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.construirEdificio(posicion, barraca);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.edificios(), 1);
	}
	
	@Test
	public void TestJugadorCreaFabrica(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 2);
		assertEquals(jugador1.recursos().mineral(), 650);
		assertEquals(jugador1.recursos().vespeno(), 900);
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelar(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 3);
		assertEquals(jugador1.recursos().mineral(), 500);
		assertEquals(jugador1.recursos().vespeno(), 800);
	}
	
	@Test
	public void TestJugadorCreaBarracaYCreaUnidadMarine(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.construirEdificio(posicion, barraca);
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		UnidadMarine marine = barraca.construirMarine();
		assertEquals(jugador1.unidades(),0);
		
		for(int i= 0; i < 3; i++)
				jugador1.pasarTurno();
			
		assertEquals(jugador1.unidades(),1);
		assertEquals(marine.posicion(), new Posicion(7,8));
	}
	
	@Test
	public void TestJugadorCreaFabricaYUnidadGolliat(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		UnidadGolliat golliat = fabrica.crearGolliat();
		
		assertEquals(jugador1.recursos().mineral(), 550);
		assertEquals(jugador1.recursos().vespeno(), 850);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 6; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 1);
		assertFalse(golliat.posicion() == null);		
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYUnidadEspectro(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadEspectro espectro = puerto.construirEspectro();
		
		assertEquals(jugador1.recursos().mineral(), 350);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 1);
		assertFalse(espectro.posicion() == null);		
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYUnidadNaveCiencia(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadNaveCiencia naveCiencia = puerto.construirNaveCiencia();
		
		assertEquals(jugador1.recursos().mineral(), 400);
		assertEquals(jugador1.recursos().vespeno(), 575);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 1);
		assertFalse(naveCiencia.posicion() == null);		
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYNaveTransporteTerran(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadNaveTransporteTerran transporte = puerto.construirNaveTransporte();
		
		assertEquals(jugador1.recursos().mineral(), 400);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 7; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 1);
		assertFalse(transporte.posicion() == null);		
	}
	
	@Test
	public void TestJugadorCreaDosBarracasEnElMismoTurno(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca1 = edCentral.construirBarraca();
		EdificioBarraca barraca2 = edCentral.construirBarraca();
		
		Posicion posicion1 = new Posicion(5,6);
		Posicion posicion2 = new Posicion(2,6);
		
		jugador1.construirEdificio(posicion1, barraca1);
		jugador1.construirEdificio(posicion2, barraca2);
		
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 2);
	}
	
	@Test
	public void TestJugadorCreaDosBarracasEnDistintosTurnos(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca1 = edCentral.construirBarraca();
		EdificioBarraca barraca2 = edCentral.construirBarraca();
		
		Posicion posicion1 = new Posicion(5,6);
		Posicion posicion2 = new Posicion(2,6);
		
		jugador1.construirEdificio(posicion1, barraca1);
		
		jugador1.pasarTurno();
		
		jugador1.construirEdificio(posicion2, barraca2);
		
		for (int i= 0; i < 11; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.edificios(), 2);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarraca(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.construirEdificio(posicion, barraca);
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		UnidadMarine marine1 = barraca.construirMarine();
		UnidadMarine marine2 = barraca.construirMarine();
		assertEquals(jugador1.unidades(),0);
		
		for(int i= 0; i < 3; i++)
				jugador1.pasarTurno();
			
		assertEquals(jugador1.unidades(),2);
		assertEquals(marine1.posicion(), new Posicion(7,8));
		assertEquals(marine2.posicion(), new Posicion(8,9));
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarracaEnDistintosTurnos(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.construirEdificio(posicion, barraca);
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		UnidadMarine marine1 = barraca.construirMarine();
		
		jugador1.pasarTurno();
		UnidadMarine marine2 = barraca.construirMarine();
		
		for(int i= 0; i < 2; i++)
				jugador1.pasarTurno();
		assertEquals(jugador1.unidades(),1);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.unidades(),2);
		
		assertEquals(marine1.posicion(), new Posicion(7,8));
		assertEquals(marine2.posicion(), new Posicion(8,9));
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnDosBarracasDistintas(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca1 = edCentral.construirBarraca();
		EdificioBarraca barraca2 = edCentral.construirBarraca();
		
		Posicion posicion1 = new Posicion(5,6);
		Posicion posicion2 = new Posicion(4,1);
		
		jugador1.construirEdificio(posicion1, barraca1);
		jugador1.construirEdificio(posicion2, barraca2);
		
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		UnidadMarine marine1 = barraca1.construirMarine();
		UnidadMarine marine2 = barraca2.construirMarine();
		
		for (int i= 0; i < 3; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 2);
		assertEquals(marine1.posicion(), new Posicion(7,8));
		assertEquals(marine2.posicion(), new Posicion(6,3));
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnDosBarracasDistintasEnTurnosDistintos(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca1 = edCentral.construirBarraca();
		EdificioBarraca barraca2 = edCentral.construirBarraca();
		
		Posicion posicion1 = new Posicion(5,6);
		Posicion posicion2 = new Posicion(4,1);
		
		jugador1.construirEdificio(posicion1, barraca1);
		jugador1.construirEdificio(posicion2, barraca2);
		
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		UnidadMarine marine1 = barraca1.construirMarine();
		
		jugador1.pasarTurno();
		UnidadMarine marine2 = barraca2.construirMarine();
		
		for (int i= 0; i < 2; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.unidades(), 1);
		assertEquals(marine1.posicion(), new Posicion(7,8));
		assertTrue(marine2.posicion() == null);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.unidades(), 2);
		assertEquals(marine2.posicion(), new Posicion(6,3));
	}
	
	@Test
	public void TestJugadorCreaYMueveUnaUnidadTerrestre(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
		
		for (int i= 0; i < 12; i++){
			jugador1.pasarTurno();
		}
		UnidadMarine marine = barraca.construirMarine();
		for (int i= 0; i < 3; i++){
			jugador1.pasarTurno();
		}
		
		Posicion posicionDestino = new Posicion(10,10);
		
		jugador1.moverUnidad(marine, posicionDestino);
		
		assertEquals(marine.posicion(), posicionDestino);
	}
	
	@Test
	public void TestJugadorCreaYMueveUnaUnidadAerea(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
			
		juego.iniciarPartida();
			
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
			
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(5,6);
		jugador1.construirEdificio(posicionBarraca, barraca);
					
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(1,4);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadEspectro espectro = puerto.construirEspectro();
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		Posicion posicionDestino = new Posicion(10,10);
		
		jugador1.moverUnidad(espectro, posicionDestino);
		
		assertEquals(espectro.posicion(), posicionDestino);		
	}
	
	@Test
	public void TestDosJugadoresCreanUnaBarraca(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		Jugador jugador2 = juego.cargarJugador("tincho", "azul", "terran");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral1 = (EdificioCentralTerran) jugador1.edificioCentral();
		EdificioCentralTerran edCentral2 = (EdificioCentralTerran) jugador2.edificioCentral();
		
		EdificioBarraca barraca1 = edCentral1.construirBarraca();
		Posicion posicion1 = new Posicion(5,6);
		jugador1.construirEdificio(posicion1, barraca1);
		jugador1.pasarTurno();
		
		EdificioBarraca barraca2 = edCentral2.construirBarraca();		
		Posicion posicion2 = new Posicion(4,1);
		jugador2.construirEdificio(posicion2, barraca2);
		jugador2.pasarTurno();
		
		for (int i= 0; i < 12; i++){
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}
		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador2.edificios(), 1);
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
