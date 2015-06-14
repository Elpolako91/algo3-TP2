package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsEdificiosRazaProtos {

	@Test
	public void testCrearEdificioCentral() {
		
		EdificioCentralProtos edCentral = new EdificioCentralProtos();
		
		assertEquals(1000, edCentral.vidaActual() );
		assertEquals(1000, edCentral.escudoActual() );
		
	}
	
	@Test
	public void testCrearRecolectorMineral() {
		
		EdificioNexoMineral ceMineral = new EdificioNexoMineral();
		
		assertEquals(250, ceMineral.vidaActual() );
		assertEquals(250, ceMineral.escudoActual() );
	}
	
	@Test
	public void testCrearRecolectorDeGasVespeno() {
		
		EdificioAsimilador recGas = new EdificioAsimilador();
		
		assertEquals(450, recGas.vidaActual() );
		assertEquals(450, recGas.escudoActual() );
		
	}
	
	@Test
	public void testCrearAcceso() {
		
		EdificioAcceso edificio = new EdificioAcceso();
		
		assertEquals(500, edificio.vidaActual() );
		assertEquals(500, edificio.escudoActual() );
		assertEquals(edificio.nombre(), "acceso");
		
	}


}
