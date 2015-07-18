package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnidadesRazaTerran {
	
	@Test
	public void testCrearMarine(){
		
		Unidad unidad= new UnidadMarine();
		
		assertEquals(unidad.nombre(),"marine");
		assertEquals(unidad.vidaMaxima(),40);
		assertEquals(unidad.danioTierra(), 6);
		assertEquals(unidad.danioAire(), 6);
		
	}
	
	@Test
	public void testCrearGolliat(){
		
		Unidad unidad= new UnidadGolliat();
		
		assertEquals(unidad.nombre(),"golliat");
		assertEquals(unidad.vidaMaxima(),125);
		assertEquals(unidad.danioTierra(), 12);
		assertEquals(unidad.danioAire(), 10);
	}
	
	@Test
	public void testCrearEspectro(){
		
		Unidad unidad= new UnidadEspectro();
		
		assertEquals(unidad.nombre(),"espectro");
		assertEquals(unidad.vidaMaxima(),120);
		assertEquals(unidad.danioTierra(), 8);
		assertEquals(unidad.danioAire(), 20);
	}
	
	@Test
	public void testCrearNaveCiencia(){
		
		Unidad unidad= new UnidadNaveCiencia();
		
		assertEquals(unidad.nombre(),"nave ciencia");
		assertEquals(unidad.vidaMaxima(),200);
	}
	
	@Test
	public void testCrearNaveTransporte(){
		
		Unidad unidad= new UnidadNaveTransporteTerran();
		
		assertEquals(unidad.nombre(),"nave transporte");
		assertEquals(unidad.vidaMaxima(),150);
	}
}
