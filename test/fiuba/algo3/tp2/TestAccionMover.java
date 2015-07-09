package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccionMover {
	
	@Test
	public void testMoverUnidadMarineAPosicionConTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionInicio, marine);
		mover.moverUnidadTerrestre(posicionFinal,marine);

		assertTrue(preguntar.hayEnTierra(posicionFinal, marine));
	}
	
	@Test
	public void testUnidadTerrestreMarineSeQuedaSinMovimiento(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionInicio, marine);
		mover.moverUnidadTerrestre(posicionFinal,marine);
		mover.moverUnidadTerrestre(posicionInicio,marine);
		mover.moverUnidadTerrestre(posicionFinal,marine);

		assertTrue(preguntar.hayEnTierra(new Posicion (3,3), marine));
	}
	
	@Test
	public void testMoverUnidadTerrestreMarineAPosicionFueraDelMapaDebeQuedarseEnElBorde(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(3,12);
		Posicion posicionBorde = new Posicion(3,10);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionInicio, marine);
		mover.moverUnidadTerrestre(posicionFinal,marine);

		
		assertTrue(preguntar.hayEnTierra(posicionBorde, marine));
	}
	
	@Test
	public void testMoverUnidadMarineAPosicionOcupadaPorOtraUnidad(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marineAmover = new UnidadMarine();
		UnidadMarine marineFijo = new UnidadMarine();
		
		Posicion posicionInicio = new Posicion(4,2);
		Posicion posicionFinal = new Posicion(7,7);
		Posicion posicionMarineFijo = new Posicion(7,8);		
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionInicio, marineAmover);
		colocar.colocarUnidadTerrestre(posicionMarineFijo, marineFijo);
		
		mover.moverUnidadTerrestre(posicionMarineFijo, marineAmover);;

		assertTrue(preguntar.hayEnTierra(posicionFinal, marineAmover));
	}
	
	@Test
	public void testMoverUnidadAereaEspectro(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadEspectro espectro = new UnidadEspectro();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		colocar.colocarUnidadAerea(posicionInicio, espectro);
		mover.moverUnidadAerea(posicionFinal,espectro);

		assertTrue(preguntar.hayEnAire(posicionFinal, espectro));
	}
	
	@Test
	public void testUnidadAereaEspectroSeQuedaSinMovimiento(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadEspectro espectro = new UnidadEspectro();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		colocar.colocarUnidadAerea(posicionInicio, espectro);
		mover.moverUnidadAerea(posicionFinal,espectro);
		mover.moverUnidadAerea(posicionInicio,espectro);
		mover.moverUnidadAerea(posicionFinal,espectro);

		assertTrue(preguntar.hayEnAire(new Posicion(3,3), espectro));
	}
	
	@Test
	public void testMoverUnidadAereaEspectroAPosicionOcupadaPorOtraUnidadAerea(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocarEnTierra colocar = new AccionColocarEnTierra(mapa);
		AccionMoverUnidadTerrestre mover = new AccionMoverUnidadTerrestre(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadEspectro espectroAmover = new UnidadEspectro();
		UnidadEspectro espectroFijo = new UnidadEspectro();
		
		Posicion posicionUnidadAMover = new Posicion(1,1);
		Posicion posicionUnidadFija = new Posicion(4,7);
		Posicion posicionFinal = new Posicion(4,6);
		
		colocar.colocarUnidadAerea(posicionUnidadAMover, espectroAmover);
		colocar.colocarUnidadAerea(posicionUnidadFija,espectroFijo);
		mover.moverUnidadAerea(posicionUnidadFija, espectroAmover);

		assertTrue(preguntar.hayEnAire(posicionFinal, espectroAmover));
	}
}