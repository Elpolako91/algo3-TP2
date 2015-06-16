package fiuba.algo3.tp2;


import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccionAtacar {
	
	// este comentario es una prueba del merge
	
	@Test
	public void testUnidadAtacaAOtra() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionAtacar atacar  = new AccionAtacar(mapa);
	
		UnidadMarine marineAtacante = new UnidadMarine();
		UnidadMarine marineAtacado = new UnidadMarine();
	
		Posicion posicionAtacante = new Posicion(4,4);
		Posicion posicionAtacado = new Posicion(6,6);	
	
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionAtacante, marineAtacante);
		colocar.colocarUnidadTerrestre(posicionAtacado, marineAtacado);
	
		atacar.atacarTierra(posicionAtacado, marineAtacante);

		assertEquals(34, marineAtacado.vidaActual());	
	}
	
	@Test
	public void testUnidadNoDebeAtacarEstaFueraDeRango() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionAtacar atacar  = new AccionAtacar(mapa);
	
		UnidadMarine marineAtacante = new UnidadMarine();
		UnidadMarine marineAtacado = new UnidadMarine();
	
		Posicion posicionAtacante = new Posicion(3,3);
		Posicion posicionAtacado = new Posicion(8,3);	
	
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionAtacante, marineAtacante);
		colocar.colocarUnidadTerrestre(posicionAtacado, marineAtacado);
	
		atacar.atacarTierra(posicionAtacado, marineAtacante);

		assertEquals(40, marineAtacado.vidaActual());	
	}
	
	@Test
	public void testUnidadAtacaEdificio() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionAtacar atacar  = new AccionAtacar(mapa);
	
		UnidadMarine marine = new UnidadMarine();
		EdificioBarraca edificio = new EdificioBarraca();
	
		Posicion posicionAtacante = new Posicion(3,3);
		Posicion posicionAtacado = new Posicion(7,3);	
	
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionAtacante, marine);
		colocar.colocarEdificio(posicionAtacado, edificio);
	
		atacar.atacarTierra(posicionAtacado, marine);

		assertEquals(994, edificio.vidaActual());	
	}
	
	@Test
	public void testUnidadMataAOtra() {
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		AccionAtacar atacar  = new AccionAtacar(mapa);
	
		UnidadMarine marineAtacante = new UnidadMarine();
		UnidadMarine marineAtacado = new UnidadMarine();
	
		Posicion posicionAtacante = new Posicion(4,4);
		Posicion posicionAtacado = new Posicion(6,6);	
	
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarUnidadTerrestre(posicionAtacante, marineAtacante);
		colocar.colocarUnidadTerrestre(posicionAtacado, marineAtacado);
	
		for(int i = 0; i<10; i++)
		atacar.atacarTierra(posicionAtacado, marineAtacante);

		assertEquals(0, marineAtacado.vidaActual());
		assertFalse(preguntar.hayEnTierra(posicionAtacado, marineAtacado)); //devuelve Vacio, necesidad de capas
	}
}
