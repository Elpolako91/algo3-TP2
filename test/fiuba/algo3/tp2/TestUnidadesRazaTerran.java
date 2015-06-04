package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnidadesRazaTerran {
	
	@Test
	public void testCrearMarine(){
		
		Unidad marine= new UnidadBasica("Terran");
		
		assertEquals(marine.vidaMaxima(),40);	
		
	}

}
