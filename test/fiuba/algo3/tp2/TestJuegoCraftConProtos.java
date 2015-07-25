package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.MapaDePrueba;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAcceso;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAsimilador;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioNexoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPilon;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarProtos;

public class TestJuegoCraftConProtos {

	private JuegoCraft juego = new JuegoCraft();
	private Mapa mapa1 = new MapaDePrueba();
	private Jugador jugador1;
	private EdificioCentralProtos edCentral;
	
	private Posicion posicionMineral = new Posicion(1,10);
	private Posicion posicionGasVespeno = new Posicion(10,1);
	
	@Before
	public void setUp() {
		
		try {
			juego.cargarJugador("martin", "verde", "protos");
		} catch (CargaJugadorInvalida e) {}
		
		juego.cargarMapa(mapa1);
		juego.iniciarPartida();
		
		jugador1 = juego.jugadores().get(0);
		edCentral = (EdificioCentralProtos) jugador1.edificioCentral();
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
	}
	/******************************* Creacion de Edificios ***************************************************/
	@Test
	public void TestJugadorCreaNexoMineral(){
		
		try {
			EdificioNexoMineral nexo = edCentral.construirRecolectorMineral();
			juego.colocarEdificio(nexo, posicionMineral);
		
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
			juego.colocarEdificio(asimilador, posicionGasVespeno);
			
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
			juego.colocarEdificio(pilon, posicion);
			
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
			juego.colocarEdificio(acceso, posicion);
			
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
			juego.colocarEdificio(acceso, posicion);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(7,6);
			juego.colocarEdificio(puerto, posicionPuerto);
			
		} catch (RecursosInsuficientes | PosicionInvalida | RequerimientosInsuficientes e) {}		
						
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
			juego.colocarEdificio(acceso, posicion);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(7,6);
			juego.colocarEdificio(puerto, posicionPuerto);
					
			this.pasarTurno(10);
			
			EdificioArchivosTemplarios archivosTemplarios = edCentral.crearArchivosTemplarios();
			Posicion posicionArchivosTemplarios = new Posicion(1,4);
			juego.colocarEdificio(archivosTemplarios, posicionArchivosTemplarios);
			
		} catch (RecursosInsuficientes | PosicionInvalida | RequerimientosInsuficientes e) {}		
		
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
			juego.colocarEdificio(acceso, posicion);
					
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
			juego.colocarEdificio(acceso, posicion);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(1,4);
			juego.colocarEdificio(puerto, posicionPuerto);
					
			this.pasarTurno(10);
			
			puerto.construirScout();
			puerto.construirNaveTransporte();
			
		} catch (RecursosInsuficientes | PosicionInvalida | RequerimientosInsuficientes e) {}		
				
		assertEquals(jugador1.recursos().mineral(), 200);
		assertEquals(jugador1.recursos().vespeno(), 700);
		assertEquals(jugador1.suministros().suministroGastados(), 5);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(8);
		assertEquals(jugador1.unidades(), 1);
		
		juego.pasarTurno();
		assertEquals(jugador1.unidades(), 2);		
	}
	
	@Test
	public void TestJugadorCreaArchivosTemplariosYUnidadAltoTemplario(){
		
		try {
			EdificioAcceso acceso = edCentral.construirAcceso();
			Posicion posicion = new Posicion(3,6);		
			juego.colocarEdificio(acceso, posicion);
					
			this.pasarTurno(8);
			
			EdificioPuertoEstelarProtos puerto = edCentral.construirPuertoEstelarProtos();
			Posicion posicionPuerto = new Posicion(1,4);
			juego.colocarEdificio(puerto, posicionPuerto);
					
			this.pasarTurno(10);
			
			EdificioArchivosTemplarios arch = edCentral.crearArchivosTemplarios();
			Posicion posicionArch = new Posicion(1,7);
			juego.colocarEdificio(arch, posicionArch);
			
			this.pasarTurno(9);
			
			arch.construirAltoTemplario();
			
		} catch (RecursosInsuficientes | PosicionInvalida | RequerimientosInsuficientes e) {}		
				
		assertEquals(jugador1.suministros().suministroGastados(), 2);
		assertEquals(jugador1.unidades(), 0);
		
		this.pasarTurno(7);		
		assertEquals(jugador1.unidades(), 1);	
	}
}