package fiuba.algo3.tp2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAccionMover {
	
	@Test
	public void testMoverUnidadMarineAPosicionConTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(5,5);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidad(posicionInicio, marine);
		mover.moverUnidad(posicionFinal,marine);

		assertEquals(marine, mapa.contenido(posicionFinal));
		assertTrue(mapa.hayTerreno(posicionInicio));
	}
	
	@Test
	public void testMoverUnidadMarineAPosicionFueraDelMapaDebeQuedarseEnElBorde(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicionInicio = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(3,12);
		Posicion posicionBorde = new Posicion(3,10);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidad(posicionInicio, marine);
		mover.moverUnidad(posicionFinal,marine);

		
		assertEquals(marine.posicion(), posicionBorde);
		assertEquals(marine, mapa.contenido(posicionBorde));
	}
	
	@Test
	public void testMoverUnidadMarineAPosicionOcupadaPorOtraUnidad(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionMover mover = new AccionMover(mapa);
		
		UnidadMarine marineAmover = new UnidadMarine();
		UnidadMarine marineFijo = new UnidadMarine();
		
		Posicion posicionInicio = new Posicion(4,2);
		Posicion posicionFinal = new Posicion(7,7);
		Posicion posicionMarineFijo = new Posicion(7,8);		
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidad(posicionInicio, marineAmover);
		colocar.colocarUnidad(posicionMarineFijo, marineFijo);
		
		mover.moverUnidad(posicionMarineFijo, marineAmover);

		assertEquals(marineAmover, mapa.contenido(posicionFinal));
		assertEquals(marineAmover.posicion(), posicionFinal);
	}
}