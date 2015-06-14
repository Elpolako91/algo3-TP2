package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEdificioCentral {

	@Test
	public void testCrearEdificioCentralTerranQueCreaBarraca() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		Barraca barraca = base.construirBarraca();		
		
		assertTrue( barraca.getClass() == Barraca.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeGasVespeno() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		EdificioRefineria recGas = base.construirRecolectorGasVespeno();		
		
		assertTrue( recGas.getClass() == EdificioRefineria.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaRecolectorDeMineral() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		EdificioCentroMineral recMineral = base.construirRecolectorMineral();		
		
		assertTrue( recMineral.getClass() == EdificioCentroMineral.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaDepositoDeSuministros() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		EdificioDeposito deposito = base.construirDeposito();		
		
		assertTrue( deposito.getClass() == EdificioDeposito.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaUnaFabrica() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		Barraca barraca = base.construirBarraca();
		EdificioFabrica fabrica = base.construirFabrica();		
		
		assertTrue( fabrica.getClass() == EdificioFabrica.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralTerranQueCreaPuertoEstelar() {
		
		EdificioCentralTerran base = new EdificioCentralTerran();
		
		Barraca barraca = base.construirBarraca();
		EdificioFabrica fabrica = base.construirFabrica();
		EdificioPuertoEstelarTerran puerto = base.construirPuertoEstelar();		
		
		assertTrue( puerto.getClass() == EdificioPuertoEstelarTerran.class);
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaNexoMineral() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioNexoMineral nexo = base.construirNexoMineral();
		
		assertTrue( nexo.getClass() == EdificioNexoMineral.class );
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAsimilador() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioAsimilador asimilador = base.construirAsimilador();
		
		assertTrue( asimilador.getClass() == EdificioAsimilador.class );
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPilon() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioPilon pilon = base.construirPilon();
		
		assertTrue( pilon.getClass() == EdificioPilon.class );
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaAcceso() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioAcceso acceso = base.construirAcceso();
		
		assertTrue( acceso.getClass() == EdificioAcceso.class );
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaPuertoEstelar() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioAcceso acceso = base.construirAcceso();
		EdificioPuertoEstelarProtos puerto = base.construirPuertoEstelar();
		
		assertTrue( puerto.getClass() == EdificioPuertoEstelarProtos.class );
		
	}
	
	@Test
	public void testCrearEdificioCentralProtosQueCreaArchivosTemplarios() {
		
		EdificioCentralProtos base = new EdificioCentralProtos();
		
		EdificioAcceso acceso = base.construirAcceso();
		EdificioPuertoEstelarProtos puerto = base.construirPuertoEstelar();
		EdificioArchivosTemplarios archivosTemplarios = base.crearArchivosTemplarios();
		
		assertTrue( archivosTemplarios.getClass() == EdificioArchivosTemplarios.class );
		
	}

}
