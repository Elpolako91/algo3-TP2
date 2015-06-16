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
		
		EdificioCentroMineral ceMineral = new EdificioCentroMineral();
		
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
	
	@Test
	public void testCrearDepositosDeSuministros() {
		
		EdificioDeposito edificio = new EdificioDeposito();
		
		assertEquals(500, edificio.vidaActual() );
		assertEquals(edificio.nombre(), "deposito");
		
	}
	
	@Test
	public void testCrearFabrica() {
		
		EdificioFabrica edificio = new EdificioFabrica();
		
		assertEquals(1250, edificio.vidaActual() );
		assertEquals(edificio.nombre(), "fabrica");
		
	}
	
	@Test
	public void testCrearPuertoEstelarTerran() {
		
		EdificioPuertoEstelarTerran edificio = new EdificioPuertoEstelarTerran();
		
		assertEquals(1300, edificio.vidaActual() );
		assertEquals(edificio.nombre(), "puerto estelar terran");
		
	}

}