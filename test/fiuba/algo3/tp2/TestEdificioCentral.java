package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAcceso;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAsimilador;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentroMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioFabrica;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioNexoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPilon;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRefineria;

public class TestEdificioCentral {

	private ArrayList<Edificio> edificios;
	private RecursosDelJugador recursos;
	private Suministro suministros;
	
	private EdificioCentralTerran centralTerran;
	private EdificioCentralProtos centralProtos;
	
	@Before
	public void setUp(){
		
		edificios = new ArrayList<Edificio>();
		recursos = new RecursosDelJugador(1000,1000);
		suministros = new Suministro();
		
		centralTerran = new EdificioCentralTerran(recursos, suministros, edificios);
		centralProtos = new EdificioCentralProtos(recursos, suministros, edificios);	
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaBarraca() {
		
		try {
			EdificioBarraca barraca = centralTerran.construirBarraca();
			
			assertTrue( barraca instanceof EdificioBarraca);
			assertEquals(recursos.mineral(), 850);
			
		} catch (RecursosInsuficientes e) {}		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeGasVespeno() {
		
		try {
			EdificioRefineria recGas = centralTerran.construirRecolectorGasVespeno();
			
			assertTrue( recGas instanceof EdificioRefineria);
			assertEquals(recursos.mineral(), 900);
			
		} catch (RecursosInsuficientes e) {}			
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeMineral() {
		
		try {
			EdificioCentroMineral recMineral = centralTerran.construirRecolectorMineral();
			
			assertTrue( recMineral instanceof EdificioCentroMineral);
			assertEquals(recursos.mineral(), 950);
			
		} catch (RecursosInsuficientes e) {}		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaDepositoDeSuministros() {
		
		try {
			EdificioDeposito deposito = centralTerran.construirAsentamiento();
			
			assertTrue( deposito instanceof EdificioDeposito);
			assertEquals(recursos.mineral(), 900);
			
		} catch (RecursosInsuficientes e) {}				
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaUnaFabrica() {
				 
		try {
			EdificioBarraca barraca = centralTerran.construirBarraca();
			edificios.add(barraca);
			EdificioFabrica fabrica = centralTerran.construirFabrica();		
			
			assertTrue( fabrica instanceof EdificioFabrica);
			assertEquals(recursos.mineral(), 650);
			assertEquals(recursos.vespeno(), 900);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}		
	}
	
	@Test
	public void testNoDebeUnaFabricaSinBarraca() {
		
		try {
			centralTerran.construirFabrica();
			
			assertTrue(false);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}		
		
		assertEquals(recursos.mineral(), 1000);
		assertEquals(recursos.vespeno(), 1000);		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaPuertoEstelar() {
		
		try {
			EdificioBarraca barraca = centralTerran.construirBarraca();
			edificios.add(barraca);
			EdificioFabrica fabrica = centralTerran.construirFabrica();
			edificios.add(fabrica);
		
			EdificioPuertoEstelarTerran puerto = centralTerran.construirPuertoEstelarTerran();		
		
			assertTrue( puerto instanceof EdificioPuertoEstelarTerran);
			assertEquals(recursos.mineral(), 500);
			assertEquals(recursos.vespeno(), 800);
		
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}	
	}
	
	@Test
	public void testNoDebeCreaPuertoEstelarSinFabrica() {
				
		try {
			centralTerran.construirPuertoEstelarTerran();
			
			assertTrue(false);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}		
		
		assertEquals(recursos.mineral(), 1000);
		assertEquals(recursos.vespeno(), 1000);		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaNexoMineral() {
		
		try {
			EdificioNexoMineral nexo = centralProtos.construirRecolectorMineral();
			
			assertTrue( nexo instanceof EdificioNexoMineral);
			assertEquals(recursos.mineral(), 950);
			
		} catch (RecursosInsuficientes e) {}		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAsimilador() {
		
		try {
			EdificioAsimilador asimilador = centralProtos.construirRecolectorGasVespeno();
			
			assertTrue( asimilador instanceof EdificioAsimilador);
			assertEquals(recursos.mineral(), 900);
			
		} catch (RecursosInsuficientes e) {}			
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPilon() {
		
		try {
			EdificioPilon pilon = centralProtos.construirAsentamiento();
			
			assertTrue( pilon instanceof EdificioPilon);
			assertEquals(recursos.mineral(), 900);
			
		} catch (RecursosInsuficientes e) {}	
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAcceso() {
		
		try {
			EdificioAcceso acceso = centralProtos.construirAcceso();
			
			assertTrue( acceso instanceof EdificioAcceso);
			assertEquals(recursos.mineral(), 850);
			
		} catch (RecursosInsuficientes e) {}	
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPuertoEstelar() {
		
		try {
			EdificioAcceso acceso = centralProtos.construirAcceso();
			edificios.add(acceso);
			EdificioPuertoEstelarProtos puerto = centralProtos.construirPuertoEstelarProtos();		
			
			assertTrue( puerto instanceof EdificioPuertoEstelarProtos);
			assertEquals(recursos.mineral(), 700);
			assertEquals(recursos.vespeno(), 850);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}			
	}
	
	@Test
	public void testNoDebeCreaPuertoEstelarProtosSinAcceso() {
		
		try {
			centralProtos.construirPuertoEstelarProtos();		
			
			assertTrue(false);			
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}
		
		assertEquals(recursos.mineral(), 1000);
		assertEquals(recursos.vespeno(), 1000);
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaArchivosTemplarios() {
		
		try {
			EdificioAcceso acceso = centralProtos.construirAcceso();
			edificios.add(acceso);
			EdificioPuertoEstelarProtos puerto = centralProtos.construirPuertoEstelarProtos();
			edificios.add(puerto);
			EdificioArchivosTemplarios archivosTemplarios = centralProtos.crearArchivosTemplarios();
			
			assertTrue( archivosTemplarios instanceof EdificioArchivosTemplarios);
			assertEquals(recursos.mineral(), 550);
			assertEquals(recursos.vespeno(), 650);
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}	
	}
	
	@Test
	public void testNoDebeCrearArchivosTemplariosSinPuertoEstelarProtos() {
		
		try {
			centralProtos.crearArchivosTemplarios();		
			
			assertTrue(false);			
			
		} catch (RecursosInsuficientes | RequerimientosInsuficientes e) {}
		
		assertEquals(recursos.mineral(), 1000);
		assertEquals(recursos.vespeno(), 1000);
	}
	
	@Test
	public void testNoHayRecursosParaConstruir(){
		
		try {			
			for(int i = 0; i<20; i++){
				
				EdificioPilon pilon = centralProtos.construirAsentamiento();
				edificios.add(pilon);
			}
			
			assertTrue(false);
			
		} catch (RecursosInsuficientes e) {}
		
		assertEquals(recursos.mineral(), 0);
		assertEquals(edificios.size(), 10);
	}
}
