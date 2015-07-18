package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadAltoTemplario;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadDragon;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadNaveTransporteProtos;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadScout;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadZealot;

public class TestUnidadesRazaProtos {

	@Test
	public void testCrearZealot(){
		
		UnidadZealot unidad= new UnidadZealot();
		
		assertEquals(unidad.nombre(),"Zealot");
		assertEquals(unidad.vidaMaxima(),60);
		assertEquals(unidad.escudoActual(), 100);
		assertEquals(unidad.danioTierra(), 8);
	}
	
	@Test
	public void testCrearDragon(){
		
		UnidadDragon unidad= new UnidadDragon();
		
		assertEquals(unidad.nombre(),"Dragon");
		assertEquals(unidad.vidaMaxima(),80);
		assertEquals(unidad.escudoActual(), 100);
		assertEquals(unidad.danioTierra(), 20);
		assertEquals(unidad.danioAire(), 20);
	}
	
	@Test
	public void testCrearScout(){
		
		UnidadScout unidad = new UnidadScout();
		
		assertEquals(unidad.nombre(),"Scout");
		assertEquals(unidad.vidaMaxima(),100);
		assertEquals(unidad.escudoActual(), 150);
		assertEquals(unidad.danioTierra(), 8);
		assertEquals(unidad.danioAire(), 14);
	}
	
	@Test
	public void testCrearAltoTemplario(){
		
		UnidadAltoTemplario unidad = new UnidadAltoTemplario();
		
		assertEquals(unidad.nombre(),"Alto templario");
		assertEquals(unidad.vidaMaxima(),40);
		assertEquals(unidad.escudoActual(), 40);

	}
	
	@Test
	public void testCrearNaveTransporteProtos(){
		
		UnidadNaveTransporteProtos unidad = new UnidadNaveTransporteProtos();
		
		assertEquals(unidad.nombre(),"Nave transporte");
		assertEquals(unidad.vidaMaxima(),60);
		assertEquals(unidad.escudoActual(), 80);

	}

}
