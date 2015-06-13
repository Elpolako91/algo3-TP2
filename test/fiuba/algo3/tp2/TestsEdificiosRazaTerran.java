package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsEdificiosRazaTerran {

	@Test
	public void testCrearEdificioCentral() {
		
		EdificioCentralTerran edCentral = new EdificioCentralTerran();
		
		assertEquals(2000, edCentral.vidaActual() );
		
	}
	
	@Test
	public void testCrearRecolectorMineral() {
		
		EdificioCentroDeMineral ceMineral = new EdificioCentroDeMineral();
		
		assertEquals(500, ceMineral.vidaActual() );
		
	}
	
	@Test
	public void testCrearRecolectorDeGasVespeno() {
		
		EdificioRefineria recGas = new EdificioRefineria();
		
		assertEquals(750, recGas.vidaActual() );
		
	}
	
	@Test
	public void testCrearBarraca() {
		
		EdificioBarraca edificio = new EdificioBarraca();
		
		assertEquals(1000, edificio.vidaActual() );
		assertEquals(edificio.nombre(), "barraca");
		
	}

}
