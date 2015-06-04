package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsEdificiosRazaTerran {

	@Test
	public void testCrearEdificioCentral() {
		
		EdificioCentral edCentral = new EdificioCentral();
		
		assertEquals(2000, edCentral.getVidaActual() );
		
	}
	
	@Test
	public void testCrearRecolectorMineral() {
		
		RecolectorMineral ceMineral = new RecolectorMineral();
		
		assertEquals(500, ceMineral.getVidaActual() );
		
	}
	
	@Test
	public void testCrearRecolectorDeGasVespeno() {
		
		RecolectorGasVespeno recGas = new RecolectorGasVespeno();
		
		assertEquals(750, recGas.getVidaActual() );
		
	}

}
