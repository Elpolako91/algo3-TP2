package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.acciones.AccionPreguntar;
import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentroMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioFabrica;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRefineria;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadEspectro;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadGolliat;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadNaveTransporteTerran;

public class TestJuegoCraftConUnJugador {

	private JuegoCraft juego;
	private Mapa mapa1;
	private Jugador jugador;
	private EdificioCentralTerran edCentral;
		
	private EdificioBarraca barraca1;
	private EdificioBarraca barraca2;
	private EdificioFabrica fabrica;
	private EdificioPuertoEstelarTerran puerto;
	
	@Before
	public void setUp() {
		juego = new JuegoCraft();
		mapa1 = new Mapa(new Tamanio(10,10));
		juego.cargarMapa(mapa1);
		
		try {
			jugador = juego.cargarJugador("facu", "rojo", "terran");
		} catch (CargaJugadorInvalida e) {}
		
		juego.iniciarPartida();
		
		jugador.recursos().agregar(new RecursosDelJugador(2000,2000));
		edCentral = (EdificioCentralTerran) jugador.edificioCentral();
		
		try {
			EdificioDeposito asentamiento = edCentral.construirAsentamiento();
			Posicion posicion = new Posicion(4,1);
			jugador.construirEdificio(posicion, asentamiento);
			
			asentamiento = edCentral.construirAsentamiento();
			posicion = new Posicion(6,1);
			jugador.construirEdificio(posicion, asentamiento);
			
			barraca1 = edCentral.construirBarraca();
			posicion = new Posicion(2,4);
			jugador.construirEdificio(posicion, barraca1);
			
			barraca2 = edCentral.construirBarraca();
			posicion = new Posicion(2,8);
			jugador.construirEdificio(posicion, barraca2);
			
			this.pasarTurno(12);
			
			fabrica = edCentral.construirFabrica();
			posicion = new Posicion(6,8);
			jugador.construirEdificio(posicion, fabrica);
			
			this.pasarTurno(12);
			
			puerto = edCentral.construirPuertoEstelarTerran();
			posicion = new Posicion(6,4);
			jugador.construirEdificio(posicion, puerto);
			
			this.pasarTurno(12);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}
		
	}
	
	private void pasarTurno(int max){
		
		for(int i = 0; i<max; i++){
			jugador.pasarTurno();
		}
	}
	
	@Test
	public void TestJuegoSeInicia(){
		
		Posicion posicionEdCentral = new Posicion(1,1);
		
		assertEquals(juego.jugadores().size(),1);
		assertEquals(jugador.edificioCentral().posicion(), posicionEdCentral);
		assertEquals(jugador.edificios(), 6);
	}

	@Test
	public void TestJugadorCreaDosBarracasEnElMismoTurno(){
		
		try {
			EdificioBarraca barraca1 = edCentral.construirBarraca();
			EdificioBarraca barraca2 = edCentral.construirBarraca();
			
			Posicion posicion1 = new Posicion(9,9);
			Posicion posicion2 = new Posicion(9,7);
			
			jugador.construirEdificio(posicion1, barraca1);
			jugador.construirEdificio(posicion2, barraca2);
			
		} catch (RecursosInsuficientes e) {}
		
		this.pasarTurno(12);
		assertEquals(jugador.edificios(), 8);
	}
	
	@Test
	public void TestJugadorCreaDosBarracasEnDistintosTurnos(){
		
		try {
			EdificioBarraca barraca1 = edCentral.construirBarraca();
			EdificioBarraca barraca2 = edCentral.construirBarraca();
			
			Posicion posicion1 = new Posicion(5,6);
			Posicion posicion2 = new Posicion(2,6);
			
			jugador1.colocarEdificio(posicion1, barraca1);
			jugador1.pasarTurno();
			jugador1.colocarEdificio(posicion2, barraca2);
			
		} catch (RecursosInsuficientes e) {}
		
		for (int i= 0; i < 11; i++)
			jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(), 1);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.edificios(), 2);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarraca(){
	
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			
			Posicion posicion = new Posicion(5,6);			
			jugador1.colocarEdificio(posicion, barraca);
			
			for (int i= 0; i < 12; i++)
				jugador1.pasarTurno();
			
			barraca.construirMarine();
			barraca.construirMarine();
			
		} catch (RecursosInsuficientes e) {}
						
		for(int i= 0; i < 3; i++)
				jugador1.pasarTurno();
			
		assertEquals(jugador1.unidades(),2);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarracaEnDistintosTurnos(){
				
		EdificioBarraca barraca;
		try {
			barraca = edCentral.construirBarraca();
		} catch (RecursosInsuficientes e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Posicion posicion = new Posicion(5,6);
		
		jugador1.colocarEdificio(posicion, barraca);
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
	public void TestJugadorTransportaMarine(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		Mapa mapa = new Mapa(new Tamanio(10,10));
		juego.cargarMapa(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
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
		UnidadMarine marine = barraca.construirMarine();
		
		for (int i= 0; i < 7; i++)
			jugador1.pasarTurno();
		
		jugador1.moverUnidad(transporte, marine.posicion());
		jugador1.cargarUnidad(transporte,marine);
		jugador1.moverUnidad(transporte, new Posicion(4,4));
		jugador1.descargarUnidad(transporte);
		
		assertTrue(preguntar.hayEnTierra(new Posicion(4,4), marine));	
	}
	
	@Test
	public void TestJugadorLlenaUnidadDeTransporte(){
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugador("facu", "rojo", "terran");
		Mapa mapa = new Mapa(new Tamanio(10,10));
		juego.cargarMapa(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		juego.iniciarPartida();
		
		EdificioCentralTerran edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
		
		EdificioBarraca barraca = edCentral.construirBarraca();
		Posicion posicionBarraca = new Posicion(1,4);
		jugador1.construirEdificio(posicionBarraca, barraca);
		
		EdificioCentroMineral centroMineral = edCentral.construirRecolectorMineral();
		EdificioRefineria refineria = edCentral.construirRecolectorGasVespeno();
		EdificioDeposito suministro = edCentral.construirAsentamiento();
		
		jugador1.construirEdificio(new Posicion(1,10), centroMineral);
		jugador1.construirEdificio(new Posicion(10,1), refineria);
		jugador1.construirEdificio(new Posicion(3,4), suministro);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioFabrica fabrica = edCentral.construirFabrica();
		Posicion posicionFabrica = new Posicion(4,1);
		jugador1.construirEdificio(posicionFabrica, fabrica);
				
		for (int i= 0; i < 12; i++)
			jugador1.pasarTurno();
		
		EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
		Posicion posicionPuerto = new Posicion(1,7);
		jugador1.construirEdificio(posicionPuerto, puerto);
					
		for (int i= 0; i < 10; i++)
			jugador1.pasarTurno();
		
		UnidadNaveTransporteTerran transporte = puerto.construirNaveTransporte();
		UnidadGolliat golliat1 = fabrica.crearGolliat();
		UnidadGolliat golliat2 = fabrica.crearGolliat();
		UnidadGolliat golliat3 = fabrica.crearGolliat();
		UnidadGolliat golliat4 = fabrica.crearGolliat();
		
		for (int i= 0; i < 7; i++)
			jugador1.pasarTurno();
		
		jugador1.moverUnidad(transporte, golliat1.posicion());
		jugador1.cargarUnidad(transporte,golliat1);
		jugador1.moverUnidad(transporte, golliat2.posicion());
		jugador1.cargarUnidad(transporte,golliat2);
		jugador1.moverUnidad(transporte, golliat3.posicion());
		jugador1.cargarUnidad(transporte,golliat3);
		jugador1.moverUnidad(transporte, golliat4.posicion());
		jugador1.cargarUnidad(transporte,golliat4);
		
		jugador1.pasarTurno();
		jugador1.moverUnidad(transporte, new Posicion(1,9));
		jugador1.descargarUnidad(transporte);
				
		assertTrue(preguntar.hayEnTierra(new Posicion(1,9), golliat1));	
	}
}
