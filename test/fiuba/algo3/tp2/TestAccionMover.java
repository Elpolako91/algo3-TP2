package fiuba.algo3.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAccionMover {
	
	@Test
	public void testMoverUnidadMarineAPosicionConTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
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
	public void testMoverUnidadMarineAPosicionFueraDelMapaDebeQuedarseEnElBorde(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
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
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
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
}