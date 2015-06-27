package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestEdificioCentral {

	@Test
	public void testCrearEdificioCentralTerranQueCreaBarraca() {
		
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), new ArrayList<Edificio>());
		
		EdificioBarraca barraca = base.construirBarraca();		
		
		assertTrue( barraca instanceof EdificioBarraca);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeGasVespeno() {
		
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), new ArrayList<Edificio>());
		
		EdificioRefineria recGas = base.construirRecolectorGasVespeno();		
		
		assertTrue( recGas instanceof EdificioRefineria);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeMineral() {
		
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), new ArrayList<Edificio>());
		
		EdificioCentroMineral recMineral = base.construirRecolectorMineral();		
		
		assertTrue( recMineral instanceof EdificioCentroMineral);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaDepositoDeSuministros() {
		
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), new ArrayList<Edificio>());
		
		EdificioDeposito deposito = base.construirAsentamiento();		
		
		assertTrue( deposito instanceof EdificioDeposito);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaUnaFabrica() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioBarraca barraca = base.construirBarraca();
		edificios.add(barraca);
		EdificioFabrica fabrica = base.construirFabrica();		
		
		assertTrue( fabrica instanceof EdificioFabrica);
		
	}
	
	@Test
	public void testNoDebeUnaFabricaSinBarraca() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioFabrica fabrica = base.construirFabrica();		
		
		assertFalse( fabrica instanceof EdificioFabrica);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaPuertoEstelar() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioBarraca barraca = base.construirBarraca();
		edificios.add(barraca);
		EdificioFabrica fabrica = base.construirFabrica();
		edificios.add(fabrica);
		
		EdificioPuertoEstelarTerran puerto = base.construirPuertoEstelarTerran();		
		
		assertTrue( puerto instanceof EdificioPuertoEstelarTerran);
	}
	
	@Test
	public void testNoDebeCreaPuertoEstelarSinFabrica() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralTerran base = new EdificioCentralTerran(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioPuertoEstelarTerran puerto = base.construirPuertoEstelarTerran();		
		
		assertFalse( puerto instanceof EdificioPuertoEstelarTerran);
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaNexoMineral() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioNexoMineral nexo = base.construirRecolectorMineral();
		
		assertTrue( nexo instanceof EdificioNexoMineral);
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAsimilador() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioAsimilador asimilador = base.construirRecolectorGasVespeno();
		
		assertTrue( asimilador instanceof EdificioAsimilador);
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPilon() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioPilon pilon = base.construirAsentamiento();
		
		assertTrue( pilon instanceof EdificioPilon);
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAcceso() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioAcceso acceso = base.construirAcceso();
		
		assertTrue( acceso instanceof EdificioAcceso);
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPuertoEstelar() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioAcceso acceso = base.construirAcceso();
		edificios.add(acceso);
		EdificioPuertoEstelarProtos puerto = base.construirPuertoEstelarProtos();
		
		assertTrue( puerto instanceof EdificioPuertoEstelarProtos);
		
	}
	
	@Test
	public void testNoDebeCreaPuertoEstelarProtosSinAcceso() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioPuertoEstelarProtos puerto = base.construirPuertoEstelarProtos();
		
		assertFalse( puerto instanceof EdificioPuertoEstelarProtos);
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaArchivosTemplarios() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioAcceso acceso = base.construirAcceso();
		edificios.add(acceso);
		EdificioPuertoEstelarProtos puerto = base.construirPuertoEstelarProtos();
		edificios.add(puerto);
		EdificioArchivosTemplarios archivosTemplarios = base.crearArchivosTemplarios();
		
		assertTrue( archivosTemplarios instanceof EdificioArchivosTemplarios);
	}
	
	@Test
	public void testNoDebeCrearArchivosTemplariosSinPuertoEstelarProtos() {
		
		List<Edificio> edificios = new ArrayList<Edificio>();
		EdificioCentralProtos base = new EdificioCentralProtos(new RecursosDelJugador(1000,1000), new Suministro(), edificios);
		
		EdificioArchivosTemplarios archivosTemplarios = base.crearArchivosTemplarios();
		
		assertFalse( archivosTemplarios instanceof EdificioArchivosTemplarios);
	}

}
