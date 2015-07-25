package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.*;
import fiuba.algo3.tp2.juego.*;
import fiuba.algo3.tp2.mapa.*;
import fiuba.algo3.tp2.objetosDelMapa.edificios.*;

public class TestJuegoCraftConTerran {
	
	private JuegoCraft juego = new JuegoCraft();
	private Mapa mapa1 = new Mapa(new Tamanio(10,10));
	
	private EdificioCentralTerran edCentral;
	
	private Posicion posicionMineral = new Posicion(1,10);
	private Posicion posicionGasVespeno = new Posicion(10,1);
	
	private Jugador jugador1;
	
	@Before
	public void setUp() {
				
		try {
			juego.cargarJugador("facu", "rojo", "terran");
		} catch (CargaJugadorInvalida e) {}
		
		juego.cargarMapa(mapa1);		
		juego.iniciarPartida();
		
		jugador1 = juego.jugadores().get(0);
		edCentral = (EdificioCentralTerran) jugador1.edificioCentral();
	}
	
	private void pasarTurno(int max){
		
		for(int i = 0; i<max; i++){
			juego.pasarTurno();
		}
	}
	
	@Test
	public void TestJuegoSeInicia(){
		
		Posicion posicionEdCentral = new Posicion(1,1);
		
		assertEquals(jugador1.edificioCentral().posicion(), posicionEdCentral);
		assertEquals(juego.jugadorActual().nombre(),"facu");
		assertEquals(juego.jugadorActual().color(),"rojo");
	}
		
	/**********************	Creacion De Edificios *********************************************/
	
	@Test
	public void TestJugadorCreaCentroDeMineral(){
			
		try {
			EdificioCentroMineral centroDeMineral = edCentral.construirRecolectorMineral();
			juego.colocarEdificio(centroDeMineral, posicionMineral);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
					
		assertEquals(jugador1.edificios(), 0);
			
		this.pasarTurno(4);			
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.recursos().mineral(),950);
			
		this.pasarTurno(5);
		assertEquals(jugador1.recursos().mineral(),1000);
	}
	
	@Test
	public void TestJugadorCreaRefineria(){
								
		try {
			EdificioRefineria refineria = edCentral.construirRecolectorGasVespeno();
			juego.colocarEdificio(refineria, posicionGasVespeno);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
						
		assertEquals(jugador1.edificios(), 0);
		assertEquals(jugador1.recursos().mineral(),900);
		assertEquals(jugador1.recursos().vespeno(),1000);
			
		this.pasarTurno(6);
		assertEquals(jugador1.edificios(), 1);
		
		this.pasarTurno(5);
		assertEquals(jugador1.recursos().vespeno(),1050);	
	}
	
	@Test
	public void TestJugadorCreaDepositoDeSuministro(){
		
		int suministroInicial = jugador1.suministros().suministroTotal();
		
		try {
			EdificioDeposito deposito = edCentral.construirAsentamiento();
			Posicion posicion = new Posicion(5,5);
			juego.colocarEdificio(deposito, posicion);
			
		} catch (RecursosInsuficientes | PosicionInvalida e){}		
			
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(6);		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.suministros().suministroTotal(), suministroInicial + 5);
	}
	
	@Test
	public void TestJugadorCreaBarraca(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicion = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicion);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
					
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(12);
		assertEquals(jugador1.edificios(), 1);
	}
	
	@Test
	public void TestJugadorCreaFabrica(){
				
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);
			
			this.pasarTurno(12);			
		
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida  e) {	}
		
		this.pasarTurno(12);		
		assertEquals(jugador1.edificios(), 2);
		assertEquals(jugador1.recursos().mineral(), 650);
		assertEquals(jugador1.recursos().vespeno(), 900);	
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelar(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);

			this.pasarTurno(12);
			
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);
			
			this.pasarTurno(12);
			
			EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
			Posicion posicionPuerto = new Posicion(1,7);
			juego.colocarEdificio(puerto, posicionPuerto);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
		
		this.pasarTurno(10);		
		assertEquals(jugador1.edificios(), 3);
		assertEquals(jugador1.recursos().mineral(), 500);
		assertEquals(jugador1.recursos().vespeno(), 800);
	}
	
	/************************* Creacion de Unidades *********************************************************/
	
	@Test
	public void TestJugadorCreaBarracaYCreaUnidadMarine(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicion = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicion);
			
			this.pasarTurno(12);			
			barraca.construirMarine();
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
		
		assertEquals(jugador1.unidades(),0);
		
		this.pasarTurno(3);
		assertEquals(jugador1.unidades(),1);
	}
	
	@Test
	public void TestJugadorCreaFabricaYUnidadGolliat(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);

			this.pasarTurno(12);
			
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);
			
			this.pasarTurno(12);			
			fabrica.crearGolliat();
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
						
		assertEquals(jugador1.recursos().mineral(), 550);
		assertEquals(jugador1.recursos().vespeno(), 850);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(6);		
		assertEquals(jugador1.unidades(), 1);	
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYUnidadEspectro(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);
				
			this.pasarTurno(12);
			
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);
			
			this.pasarTurno(12);
			
			EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
			Posicion posicionPuerto = new Posicion(1,7);
			juego.colocarEdificio(puerto, posicionPuerto);
			
			this.pasarTurno(10);			
			puerto.construirEspectro();
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
			
		assertEquals(jugador1.recursos().mineral(), 350);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(8);		
		assertEquals(jugador1.unidades(), 1);	
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYUnidadNaveCiencia(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);
			
			this.pasarTurno(12);
			
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);

			this.pasarTurno(12);
			
			EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
			Posicion posicionPuerto = new Posicion(1,7);
			juego.colocarEdificio(puerto, posicionPuerto);
					
			this.pasarTurno(10);
			puerto.construirNaveCiencia();
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
		
		assertEquals(jugador1.recursos().mineral(), 400);
		assertEquals(jugador1.recursos().vespeno(), 575);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(10);		
		assertEquals(jugador1.unidades(), 1);	
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarTerranYNaveTransporteTerran(){
		
		try {
			EdificioBarraca barraca = edCentral.construirBarraca();
			Posicion posicionBarraca = new Posicion(5,6);
			juego.colocarEdificio(barraca, posicionBarraca);
			
			this.pasarTurno(12);
			
			EdificioFabrica fabrica = edCentral.construirFabrica();
			Posicion posicionFabrica = new Posicion(1,4);
			juego.colocarEdificio(fabrica, posicionFabrica);
			
			this.pasarTurno(12);
			
			EdificioPuertoEstelarTerran puerto = edCentral.construirPuertoEstelarTerran();
			Posicion posicionPuerto = new Posicion(1,7);
			juego.colocarEdificio(puerto, posicionPuerto);
					
			this.pasarTurno(10);
			puerto.construirNaveTransporte();
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes | PosicionInvalida e) {}
		
		assertEquals(jugador1.recursos().mineral(), 400);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(7);
		assertEquals(jugador1.unidades(), 1);
	}
}
