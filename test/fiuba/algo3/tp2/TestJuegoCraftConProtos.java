package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAcceso;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAsimilador;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioNexoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPilon;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarProtos;

public class TestJuegoCraftConProtos {

	private JuegoCraft juego;
	private Mapa mapa1;
	private Jugador jugador1;
	private EdificioCentralProtos edCentral;
	
	private Posicion posicionMineral = new Posicion(1,10);
	private Posicion posicionGasVespeno = new Posicion(10,1);
	
	@Before
	public void setUp() {
		juego = new JuegoCraft();
		mapa1 = new Mapa(new Tamanio(10,10));
		juego.cargarMapa(mapa1);
		try {
			jugador1 = juego.cargarJugador("martin", "verde", "protos");
		} catch (CargaJugadorInvalida e) {}
		juego.iniciarPartida();
		edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
	}
	
	private void pasarTurno(int max){
		
		for(int i = 0; i<max; i++){
			jugador1.pasarTurno();
		}
	}
	
	@Test
	public void TestJuegoSeInicia(){
				
		Posicion posicionEdCentral = new Posicion(1,1);
		
		assertEquals(jugador1.edificioCentral().posicion(), posicionEdCentral);
	}
	/******************************* Creacion de Edificios ***************************************************/
	@Test
	public void TestJugadorCreaNexoMineral(){
		
		try {
			EdificioNexoMineral nexo = edCentral.construirRecolectorMineral();
			jugador1.construirEdificio(posicionMineral, nexo);
		
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
				
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(4);		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.recursos().mineral(),950);
		
		this.pasarTurno(5);		
		assertEquals(jugador1.recursos().mineral(),1000);
	}
	
	@Test
	public void TestJugadorCreaAsimilador(){
		
		try {
			EdificioAsimilador asimilador = edCentral.construirRecolectorGasVespeno();
			jugador1.construirEdificio(posicionGasVespeno, asimilador);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
		
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(6);		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.recursos().mineral(),900);
		assertEquals(jugador1.recursos().vespeno(),1000);
		
		this.pasarTurno(5);		
		assertEquals(jugador1.recursos().vespeno(),1050);
	}
	
	@Test
	public void TestJugadorCreaPilon(){
		
		int suministroInicial = jugador1.suministros().suministroTotal();
		
		try {
			EdificioPilon pilon = edCentral.construirAsentamiento();
			Posicion posicion = new Posicion(5,5);			
			jugador1.construirEdificio(posicion, pilon);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
			
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(5);		
		assertEquals(jugador1.edificios(), 1);
		assertEquals(jugador1.suministros().suministroTotal(), suministroInicial+5);
	}
	
	@Test
	public void TestJugadorCreaAcceso(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(5,6);			
			jugador1.construirEdificio(posicion, acceso);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}
				
		assertEquals(jugador1.edificios(), 0);
		
		this.pasarTurno(8);		
		assertEquals(jugador1.edificios(), 1);
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarProtos(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			jugador1.construirEdificio(posicion, acceso);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionBarraca = new Posicion(7,6);
			jugador1.construirEdificio(posicionBarraca, puerto);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}		
						
		this.pasarTurno(10);
		
		assertEquals(jugador1.edificios(), 2);
		assertEquals(jugador1.recursos().mineral(), 700);
		assertEquals(jugador1.recursos().vespeno(), 850);
	}
	
	@Test
	public void TestJugadorCreaArchivosTemplarios(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			jugador1.construirEdificio(posicion, acceso);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionBarraca = new Posicion(7,6);
			jugador1.construirEdificio(posicionBarraca, puerto);
					
			this.pasarTurno(10);
			
			EdificioArchivosTemplarios archivosTemplarios = edCentral.crearArchivosTemplarios();
			Posicion posicionArchivosTemplarios = new Posicion(1,4);
			jugador1.construirEdificio(posicionArchivosTemplarios, archivosTemplarios);
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}		
		
		this.pasarTurno(9);
		
		assertEquals(jugador1.edificios(), 3);
		assertEquals(jugador1.recursos().mineral(), 550);
		assertEquals(jugador1.recursos().vespeno(), 650);
	}
		
	/******************************* Creacion de Unidades *************************************************/
	@Test
	public void TestJugadorCreaAccespYCreaUnidadZealotYUnidadDragon(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			jugador1.construirEdificio(posicion, acceso);
					
			this.pasarTurno(8);			
			acceso.construirZealot();
			assertEquals(jugador1.unidades(),0);
			
			this.pasarTurno(4);				
			assertEquals(jugador1.unidades(),1);
			
			acceso.construirDragon();			
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}		
		
		assertEquals(jugador1.unidades(),1);
		
		this.pasarTurno(6);
		assertEquals(jugador1.unidades(),2);
	}
	
	@Test
	public void TestJugadorCreaPuertoEstelarYCreaUnidadadScoutYUnidadTransporte(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			jugador1.construirEdificio(posicion, acceso);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(1,4);
			jugador1.construirEdificio(posicionPuerto, puerto);
					
			this.pasarTurno(10);
			
			puerto.construirScout();
			puerto.construirNaveTransporte();
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}		
				
		assertEquals(jugador1.recursos().mineral(), 200);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 5);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(8);
		assertEquals(jugador1.unidades(), 1);
		
		jugador1.pasarTurno();
		assertEquals(jugador1.unidades(), 2);		
	}
	
	@Test
	public void TestJugadorCreaArchivosTemplariosYUnidadAltoTemplario(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			jugador1.construirEdificio(posicion, acceso);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(1,4);
			jugador1.construirEdificio(posicionPuerto, puerto);
					
			this.pasarTurno(10);
			
			EdificioArchivosTemplarios arch = edCentral.crearArchivosTemplarios();
			Posicion posicionArch = new Posicion(1,7);
			jugador1.construirEdificio(posicionArch, arch);
			
			this.pasarTurno(9);
			
			arch.construirAltoTemplario();
			
		} catch (RecursosInsuficientes | PosicionInvalida e) {}		
				
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(7);		
		assertEquals(jugador1.unidades(), 1);	
	}
}