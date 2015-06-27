package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJuegoCraftConProtos {

	@Test
	public void TestJuegoSeInicia(){
		
		JuegoCraft juego = new JuegoCraft();
		
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		Jugador jugador2 = juego.cargarJugador("tincho","verde","protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(8,8);
		
		assertEquals(jugador1.edificioCentral().posicion(), posicion1);
		assertEquals(jugador2.edificioCentral().posicion(), posicion2);
	}
	
	@Test
	public void TestJugadorCreaNexoMineral(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioNexoMineral nexo = edCentral.construirRecolectorMineral();
		
		Posicion posicion = new Posicion(1,10);
		
		jugador1.construirEdificio(posicion, nexo);
		
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
	public void TestJugadorCreaAsimilador(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAsimilador asimilador = edCentral.construirRecolectorGasVespeno();
		
		Posicion posicion = new Posicion(10,1);
		
		jugador1.construirEdificio(posicion, asimilador);
		
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
	public void TestJugadorCreaPilon(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
				
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioPilon pilon = edCentral.construirAsentamiento();
		int suministroInicial = jugador1.suministros().suministroTotal();
		Posicion posicion = new Posicion(5,5);
		
		jugador1.construirEdificio(posicion, pilon);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 5; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.suministros().suministroTotal(), suministroInicial+5);
	}
	
	@Test
	public void TestJugadorCreaAcceso(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.construirEdificio(posicion, acceso);
		
		assertEquals(jugador1.edificios(), 0);
		
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.edificios(), 1);
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarProtos(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();		
		Posicion posicion = new Posicion(3,6);		
		jugador1.construirEdificio(posicion, acceso);
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
		Posicion posicionBarraca = new Posicion(7,6);
		jugador1.construirEdificio(posicionBarraca, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 2);
		assertEquals(jugador1.recursos().mineral(), 700);
		assertEquals(jugador1.recursos().vespeno(), 850);
	}
	
	@Test
	public void TestJugadorCreaArchivosTemplarios(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();		
		Posicion posicion = new Posicion(3,6);		
		jugador1.construirEdificio(posicion, acceso);
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
		Posicion posicionBarraca = new Posicion(7,6);
		jugador1.construirEdificio(posicionBarraca, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		EdificioArchivosTemplarios archivosTemplarios = edCentral.crearArchivosTemplarios();
		Posicion posicionArchivosTemplarios = new Posicion(1,4);
		jugador1.construirEdificio(posicionArchivosTemplarios, archivosTemplarios);
		
		for (int i= 0; i < 9; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 3);
		assertEquals(jugador1.recursos().mineral(), 550);
		assertEquals(jugador1.recursos().vespeno(), 650);
	}
		
	@Test
	public void TestJugadorCreaAccespYCreaUnidadZealotYUnidadDragon(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();		
		Posicion posicion = new Posicion(3,6);		
		jugador1.construirEdificio(posicion, acceso);
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		UnidadZealot zealot = acceso.construirZealot();
		assertEquals(jugador1.unidades(),0);
		
		for(int i= 0; i < 4; i++)
				jugador1.pasarTurno();
			
		assertEquals(jugador1.unidades(),1);
		UnidadDragon dragon = acceso.construirDragon();
		assertEquals(jugador1.unidades(),1);
		
		for(int i= 0; i < 6; i++)
				jugador1.pasarTurno();
			
		assertFalse(zealot.posicion() == null);
		assertFalse(dragon.posicion() == null);
		assertEquals(jugador1.unidades(),2);
	}
	/***********ACA FALLAN LAS VOLADORAS! Agregar crear la transporte en este mismo ***/
	@Test
	public void TestJugadorCreaPuertoEstelarYCreaUnidadadScoutYUnidadTransporte(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();		
		Posicion posicion = new Posicion(3,6);		
		jugador1.construirEdificio(posicion, acceso);
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
		Posicion posicionPuerto = new Posicion(1,4);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadScout scout = puerto.construirScout();
		UnidadNaveTransporteProtos naveTransporte = puerto.construirNaveTransporte();
		
		assertEquals(jugador1.recursos().mineral(), 200);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 5);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		assertEquals(jugador1.unidades(), 1);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.unidades(), 2);
		
		assertFalse(naveTransporte.posicion() == null);
		assertFalse(scout.posicion() == null);			
	}
	
	@Test
	public void TestJugadorCreaArchivosTemplariosYUnidadAltoTemplario(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "protos");
		juego.cargarMapa(new Mapa(new Tamanio (10,10)));
		
		juego.iniciarPartida();
		
		EdificioCentralProtos edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
		
		EdificioAcceso acceso = edCentral.construirAcceso();		
		Posicion posicion = new Posicion(3,6);		
		jugador1.construirEdificio(posicion, acceso);
				
		for (int i= 0; i < 8; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
		Posicion posicionPuerto = new Posicion(1,4);
		jugador1.construirEdificio(posicionPuerto, puerto);
				
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		EdificioArchivosTemplarios arch = edCentral.crearArchivosTemplarios();
		Posicion posicionArch = new Posicion(1,7);
		jugador1.construirEdificio(posicionArch, arch);
				
		for (int i= 0; i < 9; i++)
			jugador1.pasarTurno();
		
		UnidadAltoTemplario templario = arch.construirAltoTemplario();
		
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		for (int i= 0; i < 7; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.unidades(), 1);
		assertFalse(templario.posicion() == null);		
	}
}