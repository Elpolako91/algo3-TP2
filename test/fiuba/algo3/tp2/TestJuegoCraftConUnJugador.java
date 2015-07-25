package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.excepciones.UnidadEnemigaSeleccionada;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.MapaDePrueba;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.edificios.*;
import fiuba.algo3.tp2.objetosDelMapa.unidades.*;

public class TestJuegoCraftConUnJugador {

	private JuegoCraft juego = new JuegoCraft();
	private Mapa mapa1 = new MapaDePrueba();
	private Jugador jugador;
	private EdificioCentralTerran edCentral;
		
	private EdificioBarraca barraca1;
	private EdificioBarraca barraca2;
	private EdificioFabrica fabrica;
	private EdificioPuertoEstelarTerran puerto;
	
	@Before
	public void setUp() {
				
		try {
			juego.cargarJugador("facu", "rojo", "terran");
		} catch (CargaJugadorInvalida e) {}
		
		juego.cargarMapa(mapa1);
		juego.iniciarPartida();
		
		jugador = juego.jugadores().get(0);
		jugador.recursos().agregar(new RecursosDelJugador(2000,2000));
		edCentral = (EdificioCentralTerran) jugador.edificioCentral();
		
		try {
			EdificioDeposito deposito = edCentral.construirAsentamiento();
			Posicion posicion = new Posicion(4,1);
			juego.colocarEdificio(deposito, posicion);
			
			deposito = edCentral.construirAsentamiento();
			posicion = new Posicion(6,1);
			juego.colocarEdificio(deposito, posicion);
			
			barraca1 = edCentral.construirBarraca();
			posicion = new Posicion(2,4);
			juego.colocarEdificio(barraca1, posicion);
			
			barraca2 = edCentral.construirBarraca();
			posicion = new Posicion(2,8);
			juego.colocarEdificio(barraca2, posicion);
			
			this.pasarTurno(12);
			
			fabrica = edCentral.construirFabrica();
			posicion = new Posicion(6,8);
			juego.colocarEdificio(fabrica, posicion);
			
			this.pasarTurno(12);
			
			puerto = edCentral.construirPuertoEstelarTerran();
			posicion = new Posicion(6,4);
			juego.colocarEdificio(puerto, posicion);
			
			this.pasarTurno(12);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
		
	}
	
	private void pasarTurno(int max){
		
		for(int i = 0; i<max; i++){
			juego.pasarTurno();
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
			EdificioBarraca barraca3 = edCentral.construirBarraca();
			EdificioBarraca barraca4 = edCentral.construirBarraca();
			
			Posicion posicion1 = new Posicion(9,9);
			Posicion posicion2 = new Posicion(9,7);
			
			juego.colocarEdificio(barraca3, posicion1);
			juego.colocarEdificio(barraca4, posicion2);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
		
		this.pasarTurno(12);
		assertEquals(jugador.edificios(), 8);
	}
	
	@Test
	public void TestJugadorCreaDosBarracasEnDistintosTurnos(){
		
		try {
			EdificioBarraca barraca3 = edCentral.construirBarraca();
			EdificioBarraca barraca4 = edCentral.construirBarraca();
			
			Posicion posicion1 = new Posicion(5,6);
			Posicion posicion2 = new Posicion(2,6);
			
			juego.colocarEdificio(barraca3, posicion1);
			juego.pasarTurno();
			juego.colocarEdificio(barraca4, posicion2);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
		
		this.pasarTurno(11);
		
		assertEquals(jugador.edificios(), 7);
		
		juego.pasarTurno();
		assertEquals(jugador.edificios(), 8);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarraca(){
			
		try {
			barraca1.construirMarine();
			barraca1.construirMarine();
			
		} catch (RecursosInsuficientes e) {}			
						
		this.pasarTurno(3);
			
		assertEquals(jugador.unidades(),2);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnLaMismaBarracaEnDistintosTurnos(){
				
		try {
			barraca1.construirMarine();
			juego.pasarTurno();
			barraca1.construirMarine();
			
		} catch (RecursosInsuficientes e) {}
				
		this.pasarTurno(2);		
		assertEquals(jugador.unidades(),1);
		
		juego.pasarTurno();
		assertEquals(jugador.unidades(),2);		
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnDosBarracasDistintas(){
				
		try {
			barraca1.construirMarine();
			barraca2.construirMarine();
			
		} catch (RecursosInsuficientes e) {}
		
		
		this.pasarTurno(3);
		
		assertEquals(jugador.unidades(), 2);
	}
	
	@Test
	public void TestJugadorCreaDosUnidadesEnDosBarracasDistintasEnTurnosDistintos(){
				
		try {
			barraca1.construirMarine();
			juego.pasarTurno();			
			barraca2.construirMarine();
			
		} catch (RecursosInsuficientes e) {}				
		
		this.pasarTurno(2);		
		assertEquals(jugador.unidades(), 1);
		
		juego.pasarTurno();
		assertEquals(jugador.unidades(), 2);
	}
	
	@Test
	public void TestJugadorCreaYMueveUnaUnidadTerrestre(){
				
		try {
			UnidadMarine marine = barraca1.construirMarine();
			this.pasarTurno(3);
			
			Posicion posicionDestino = new Posicion(10,10);
			
			juego.moverUnidad(marine, posicionDestino);
			
			assertEquals(marine.posicion(), posicionDestino);
			
		} catch (RecursosInsuficientes | UnidadEnemigaSeleccionada | PosicionInvalida | UnidadMovimientoTerminado e) {}		
	}
	
	@Test
	public void TestJugadorCreaYMueveUnaUnidadAerea(){
				
		try {
			UnidadEspectro espectro = puerto.construirEspectro();
			this.pasarTurno(8);
			
			Posicion posicionDestino = new Posicion(10,10);
			
			juego.moverUnidad(espectro, posicionDestino);
			
			assertEquals(espectro.posicion(), posicionDestino);
			
		} catch (RecursosInsuficientes | UnidadEnemigaSeleccionada | PosicionInvalida | UnidadMovimientoTerminado e) {}				
	}
	
	@Test
	public void TestJugadorTransportaMarine(){
				
		try {
			UnidadNaveTransporteTerran transporte = puerto.construirNaveTransporte();
			UnidadMarine marine = barraca1.construirMarine();
			this.pasarTurno(7);
			
			juego.moverUnidad(transporte, marine.posicion());
			juego.cargarUnidad(transporte, transporte.posicion());
			juego.pasarTurno();
			
			juego.moverUnidad(transporte, new Posicion(4,4));
			juego.descargarUnidad(transporte, transporte.posicion());
			
			assertEquals(marine.posicion(), transporte.posicion());	
			
		} catch (RecursosInsuficientes | UnidadEnemigaSeleccionada | PosicionInvalida | UnidadMovimientoTerminado e) {}		
	}
	
	@Test
	public void TestJugadorLlenaUnidadDeTransporte(){
				
		Posicion posicionDescarga = new Posicion(1,9);
		
		try {
			UnidadNaveTransporteTerran transporte = puerto.construirNaveTransporte();
			UnidadGolliat golliat1 = fabrica.crearGolliat();
			UnidadGolliat golliat2 = fabrica.crearGolliat();
			UnidadGolliat golliat3 = fabrica.crearGolliat();
			UnidadGolliat golliat4 = fabrica.crearGolliat();
			
			this.pasarTurno(7);
			
			juego.moverUnidad(transporte, golliat1.posicion());
			juego.cargarUnidad(transporte, transporte.posicion());
			
			juego.moverUnidad(transporte, golliat2.posicion());
			juego.cargarUnidad(transporte, transporte.posicion());
			
			juego.moverUnidad(transporte, golliat3.posicion());
			juego.cargarUnidad(transporte, transporte.posicion());
			
			juego.moverUnidad(transporte, golliat4.posicion());
			juego.cargarUnidad(transporte, transporte.posicion());
			
			juego.pasarTurno();
			juego.moverUnidad(transporte, posicionDescarga);
			juego.descargarUnidad(transporte, transporte.posicion());
					
			assertEquals(posicionDescarga, golliat1.posicion());
			
		} catch (RecursosInsuficientes | PosicionInvalida | UnidadEnemigaSeleccionada | UnidadMovimientoTerminado e) {}			
	}
}
