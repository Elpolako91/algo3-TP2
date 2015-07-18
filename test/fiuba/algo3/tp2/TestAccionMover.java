package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;

public class TestAccionMover {
	
	private Mapa mapa;
	
	private AccionPreguntar preguntar;	
	private AccionColocarEnSuelo colocarSuelo;
	private AccionColocarUnidad	colocarUnidad;
	
	private AccionMoverUnidad mover;
	
	private UnidadMarine unidadTerrestre1;
	private UnidadMarine unidadTerrestre2;
	private UnidadEspectro unidadAerea1;
	private UnidadEspectro unidadAerea2;
		
	@Before
	public void setUp(){
		mapa = new Mapa(new Tamanio(10,10));
		preguntar = new AccionPreguntar(mapa);
		
		colocarSuelo = new AccionColocarEnSuelo(mapa);
		colocarUnidad = new AccionColocarUnidad(mapa);
		
		mover = new AccionMoverUnidad(mapa);
		
		unidadTerrestre1 = new UnidadMarine();
		unidadTerrestre2 = new UnidadMarine();
		unidadAerea1 = new UnidadEspectro();
		unidadAerea2 = new UnidadEspectro();
	}
	
	/**************************** Tests mover unidad terrestre ***************************************/
	
	@Test
	public void testMoverUnidadTerrestreAPosicionConTerreno(){
		
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		try {
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionInicio, unidadTerrestre1);
			mover.realizar(posicionFinal, unidadTerrestre1);
			
			assertTrue(preguntar.hayEnTierra(posicionFinal, unidadTerrestre1));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testUnidadTerrestreSeQuedaSinMovimiento(){
		
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionIntermedia = new Posicion(5,5);
		Posicion posicionFinal = new Posicion(4,4);
				
		try {
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionInicio, unidadTerrestre1);
			
			mover.realizar(posicionIntermedia, unidadTerrestre1);
			mover.realizar(posicionInicio, unidadTerrestre1);
			
			assertTrue(preguntar.hayEnTierra(posicionFinal, unidadTerrestre1));
			assertEquals(unidadTerrestre1.posicion(), posicionFinal);
			
		} catch (PosicionInvalida e) {}	
	}
	
	@Test
	public void testMoverUnidadTerrestreAPosicionFueraDelMapaDebeQuedarseEnElBorde(){
				
		Posicion posicionInicio = new Posicion(5,5);
		Posicion posicionFinal = new Posicion(3,12);
		Posicion posicionBorde = new Posicion(3,10);
		
		try {
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionInicio, unidadTerrestre1);		
			mover.realizar(posicionFinal, unidadTerrestre1);
			
		} catch (PosicionInvalida e) {}		

		try {
			assertTrue(preguntar.hayEnTierra(posicionBorde, unidadTerrestre1));
			assertEquals(unidadTerrestre1.posicion(), posicionBorde);
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testMoverUnidadMarineAPosicionOcupadaPorOtraUnidad(){
		
		Posicion posicionInicio = new Posicion(6,4);
		Posicion posicionFinal = new Posicion(7,7);
		Posicion posicionUnidadTerrestreFija = new Posicion(7,8);		
		
		try {
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionInicio, unidadTerrestre1);
			colocarUnidad.realizar(posicionUnidadTerrestreFija, unidadTerrestre2);
			mover.realizar(posicionUnidadTerrestreFija, unidadTerrestre1);
			
		} catch (PosicionInvalida e) {}	
		
		try {
			assertTrue(preguntar.hayEnTierra(posicionFinal, unidadTerrestre1));
			assertTrue(preguntar.hayEnTierra(posicionUnidadTerrestreFija, unidadTerrestre2));
			
		} catch (PosicionInvalida e) {}	
	}
	
	/******************************* Tests Mover Unidad Aerea ******************************************/
	
	@Test
	public void testMoverUnidadAerea(){
		
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		try {
			colocarUnidad.realizar(posicionInicio, unidadAerea1);
			mover.realizar(posicionFinal, unidadAerea1);
			
			assertTrue(preguntar.hayEnAire(posicionFinal, unidadAerea1));
			assertEquals(unidadAerea1.posicion(), posicionFinal);
			
		} catch (PosicionInvalida e) {}			
	}
	
	@Test
	public void testUnidadAereaSeQuedaSinMovimiento(){
		
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionAmover = new Posicion(3,10);
		Posicion posicionFinal = new Posicion(3,9);
		
		try {
			colocarUnidad.realizar(posicionInicio, unidadAerea1);
			mover.realizar(posicionAmover, unidadAerea1);
			
			assertTrue(preguntar.hayEnAire(posicionFinal, unidadAerea1));
			assertEquals(unidadAerea1.posicion(), posicionFinal);
			
		} catch (PosicionInvalida e) {}	
	}
	
	@Test
	public void testMoverUnidadAereaAFueraDelMapaDebeQuedarseEnElBorde(){
				
		Posicion posicionInicio = new Posicion(8,6);
		Posicion posicionFinal = new Posicion(10,12);
		Posicion posicionBorde = new Posicion(10,10);
		
		
		try {
			colocarUnidad.realizar(posicionInicio, unidadAerea1);
			mover.realizar(posicionFinal, unidadAerea1);
						
		} catch (PosicionInvalida e) {}	
		
		try {
			assertTrue(preguntar.hayEnAire(posicionBorde, unidadAerea1));
			assertEquals(unidadAerea1.posicion(), posicionBorde);
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testMoverUnidadAereaAPosicionOcupadaPorOtraUnidadAerea(){
				
		Posicion posicionInicio = new Posicion(3,3);
		Posicion posicionUnidadFija = new Posicion(4,7);
		Posicion posicionFinal = new Posicion(4,6);
		
		try {
			colocarUnidad.realizar(posicionInicio, unidadAerea1);
			colocarUnidad.realizar(posicionUnidadFija, unidadAerea2);
			mover.realizar(posicionUnidadFija, unidadAerea1);
						
		} catch (PosicionInvalida e) {}	
		
		try {
			assertTrue(preguntar.hayEnAire(posicionFinal, unidadAerea1));
			assertEquals(unidadAerea1.posicion(), posicionFinal);
			
		} catch (PosicionInvalida e) {}		
	}
	
	/************************************ Test mover unidades terrestres y aereas ********************************/
	
	@Test
	public void testMoverUnidadAereaYTerrestreALaMismaPosicion(){
				
		Posicion posicionInicio = new Posicion(3,3);
		Posicion posicionFinal = new Posicion(4,6);
		
		try {
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionInicio, unidadTerrestre1);
			colocarUnidad.realizar(posicionInicio, unidadAerea1);
			
			mover.realizar(posicionFinal, unidadTerrestre1);
			mover.realizar(posicionFinal, unidadAerea1);
			
			assertTrue(preguntar.hayEnAire(posicionFinal, unidadAerea1));
			assertTrue(preguntar.hayEnTierra(posicionFinal, unidadTerrestre1));
						
		} catch (PosicionInvalida e) {}				
	}
}