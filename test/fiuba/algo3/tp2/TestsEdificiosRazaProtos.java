package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsEdificiosRazaProtos {

	@Test
	public void testCrearEdificioCentral() {
		
		EdificioCentral edCentral = new EdificioCentral();
		
		assertEquals(2000, edCentral.getVidaActual() );
		assertEquals(1000, edCentral.getEscudoActual() );
		
	}
	
	@Test
	public void testCrearRecolectorMineral() {
		
		RecolectorMineral ceMineral = new RecolectorMineral();
		
		assertEquals(500, ceMineral.getVidaActual() );
		assertEquals(250, ceMineral.getEscudoActual() );
		
	}
	
	@Test
	public void testCrearRecolectorDeGasVespeno() {
		
		RecolectorGasVespeno recGas = new RecolectorGasVespeno();
		
		assertEquals(750, recGas.getVidaActual() );
		assertEquals(450, recGas.getEscudoActual() );
		
	}

}
