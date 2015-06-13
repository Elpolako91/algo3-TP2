package fiuba.algo3.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAccionColocar {
	
	@Test
	public void testColocarTerrenoEnPosicionValida(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		Posicion posicion = new Posicion(1,1);
		AccionColocar accion = new AccionColocar(mapa);
		
		accion.colocarTerrenoEn(posicion);
		
		assertTrue(mapa.contenido(posicion) instanceof Terreno);
	}
	
	@Test
	public void testColocarTerrenoEnTodoElMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		Posicion posicionAux;
		
		accion.colocarTerrenoEnTodoElMapa();
		
		for (int i = 1; i<= mapa.tamanio().enX(); i++)
			for (int j = 1; j<=mapa.tamanio().enY(); j++){

				posicionAux = new Posicion(i,j);
				assertTrue(mapa.contenido(posicionAux) instanceof Terreno);
		}
	}
	
	@Test
	public void testColocarRecursoMineral(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		RecursoMineral mineral = new RecursoMineral();
		Posicion posicion = new Posicion(1,1);
		
		accion.colocarRecurso(posicion, mineral);
		
		assertEquals(mineral, mapa.contenido(posicion));		
	}
		
	@Test
	public void testColocarRecursoGasVespeno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		RecursoGasVespeno gasVespeno = new RecursoGasVespeno();
		Posicion posicion = new Posicion(3,3);
		
		accion.colocarRecurso(posicion, gasVespeno);
		
		assertEquals(gasVespeno ,mapa.contenido(posicion));		
	}
	
	@Test
	public void testNoDebeColocarUnidadMarineCuandoNoHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);	
		UnidadMarine marine = new UnidadMarine();
		Posicion posicion = new Posicion(5,5);
		
		accion.colocarUnidad(posicion,marine);
				
		assertTrue( mapa.contenido(posicion) instanceof Vacio);
	}
	
	@Test
	public void testColocarUnidadMarine(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);	
		UnidadMarine marine = new UnidadMarine();
		Posicion posicion = new Posicion(5,5);
		
		accion.colocarTerrenoEn(posicion);
		accion.colocarUnidad(posicion,marine);
				
		assertEquals(marine, mapa.contenido(posicion));
		assertEquals(marine.posicion(), posicion);
	}
	
	@Test
	public void testColocarEdificioBarraca(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);	
		EdificioBarraca barraca = new EdificioBarraca();
		Posicion posicion1 = new Posicion(1, 1);
		Posicion posicion2 = new Posicion(1, 2);
		Posicion posicion3 = new Posicion(2, 1);
		Posicion posicion4 = new Posicion(2, 2);
		
		accion.colocarTerrenoEnTodoElMapa();
		accion.colocarEdificio(posicion1,barraca);
		
		assertEquals(barraca, mapa.contenido(posicion1));
		assertEquals(barraca, mapa.contenido(posicion2));
		assertEquals(barraca, mapa.contenido(posicion3));
		assertEquals(barraca, mapa.contenido(posicion4));
		assertEquals(barraca.posicion(), posicion1);
	}
	
	@Test
	public void testNoDebeColocarEdificioBarracaCuandoNoHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);	
		EdificioBarraca barraca = new EdificioBarraca();
		
		Posicion posicion1 = new Posicion(1, 1);
		Posicion posicion2 = new Posicion(1, 2);
		Posicion posicion3 = new Posicion(2, 1);
		Posicion posicion4 = new Posicion(2, 2);
		
		accion.colocarEdificio(posicion1,barraca);
			
		assertTrue(mapa.contenido(posicion1) instanceof Vacio);
		assertTrue(mapa.contenido(posicion2) instanceof Vacio);
		assertTrue(mapa.contenido(posicion3) instanceof Vacio);
		assertTrue(mapa.contenido(posicion4) instanceof Vacio);
	}
	
	@Test
	public void testColocarEdificioRecolectorDeMinerialSobreRecursoMineral(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		Recurso mineral = new RecursoMineral();
		EdificioTerran recolectorMineral = new EdificioCentroDeMineral();
		Posicion posicion = new Posicion(4,4);
		
		accion.colocarRecurso(posicion, mineral);
		accion.colocarRecolectorDeMineral(posicion, recolectorMineral);
		
		assertEquals(recolectorMineral, mapa.contenido(posicion));		
	}
	
	@Test
	public void testNoDebeColocarEdificioRecolectorDeMinerialSinRecursoMineral(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		EdificioTerran recolectorMineral = new EdificioCentroDeMineral();
		Posicion posicion = new Posicion(4,4);
		
		accion.colocarRecolectorDeMineral(posicion, recolectorMineral);
		
		assertTrue(mapa.contenido(posicion) instanceof Vacio);		
	}
	
	@Test
	public void testColocarEdificioRecolectorDeGasVespenoSobreRecursoGasVespeno(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		Recurso gasVespeno = new RecursoGasVespeno();
		EdificioTerran recolectorGasVespeno = new EdificioRefineria();
		Posicion posicion = new Posicion(4,4);
		
		accion.colocarRecurso(posicion, gasVespeno);
		accion.colocarRecolectorDeGasVespeno(posicion, recolectorGasVespeno);
		
		assertEquals(recolectorGasVespeno, mapa.contenido(posicion));		
	}
	
	@Test
	public void testNoDebeColocarEdificioRecolectorDeGasVespenoSinRecursoGasVespeno(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar accion = new AccionColocar(mapa);
		EdificioTerran recolectorGasVespeno = new EdificioRefineria();
		Posicion posicion = new Posicion(4,4);
		
		accion.colocarRecolectorDeGasVespeno(posicion, recolectorGasVespeno);
				
		assertTrue(mapa.contenido(posicion) instanceof Vacio);		
	}
}
