package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccionColocar {
	
	@Test
	public void testColocarTerrenoEnPosicionValida(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		Posicion posicion = new Posicion(1,1);
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		colocar.colocarTerrenoEn(posicion);
		
		assertTrue(preguntar.hayTerreno(posicion));
	}
	
	@Test
	public void testColocarTerrenoEnTodoElMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		Posicion posicionAux;
		
		colocar.colocarTerrenoEnTodoElMapa();
		
		for (int i = 1; i<= mapa.tamanio().enX(); i++)
			for (int j = 1; j<=mapa.tamanio().enY(); j++){

				posicionAux = new Posicion(i,j);
				assertTrue(preguntar.hayTerreno(posicionAux));
		}
	}
	
	@Test
	public void testColocarRecursoMineral(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		RecursoMineral mineral = new RecursoMineral(2000);
		Posicion posicion = new Posicion(1,1);
		
		colocar.colocarRecurso(posicion, mineral);
		
		assertTrue(preguntar.hayMineral(posicion));		
	}
		
	@Test
	public void testColocarRecursoGasVespeno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		RecursoGasVespeno gasVespeno = new RecursoGasVespeno(2000);
		Posicion posicion = new Posicion(1,1);
		
		colocar.colocarRecurso(posicion, gasVespeno);
		
		assertTrue(preguntar.hayGasVespeno(posicion));	
	}
	
	@Test
	public void testNoDebeColocarUnidadMarineCuandoNoHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarUnidadTerrestre(posicion,marine);
				
		assertFalse(preguntar.hayUnidadTerrestre(posicion));
	}
	
	@Test
	public void testColocarUnidadTerrestreMarine(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarTerrenoEn(posicion);
		colocar.colocarUnidadTerrestre(posicion,marine);
				
		assertTrue(preguntar.hayUnidadTerrestre(posicion));
		assertEquals(marine.posicion(), posicion);
	}
	
	@Test
	public void testColocarUnidadTerrestreGolliat(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadGolliat golliat = new UnidadGolliat();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarTerrenoEn(posicion);
		colocar.colocarUnidadTerrestre(posicion,golliat);
				
		assertTrue(preguntar.hayEnTierra(posicion, golliat));
		assertEquals(golliat.posicion(), posicion);
	}
	
	@Test
	public void testColocarEdificioBarraca(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		Posicion posicion1 = new Posicion(1, 1);
		Posicion posicion2 = new Posicion(1, 2);
		Posicion posicion3 = new Posicion(2, 1);
		Posicion posicion4 = new Posicion(2, 2);
		
		colocar.colocarTerrenoEnTodoElMapa();
		colocar.colocarEdificio(posicion1,barraca);
		
		assertTrue(preguntar.hayEdificio(posicion1));
		assertTrue(preguntar.hayEdificio(posicion2));
		assertTrue(preguntar.hayEdificio(posicion3));
		assertTrue(preguntar.hayEdificio(posicion4));
		assertEquals(barraca.posicion(), posicion1);
	}
	
	@Test
	public void testNoDebeColocarEdificioBarracaCuandoNoHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());		
		Posicion posicion1 = new Posicion(1, 1);
		Posicion posicion2 = new Posicion(1, 2);
		Posicion posicion3 = new Posicion(2, 1);
		Posicion posicion4 = new Posicion(2, 2);
		
		colocar.colocarEdificio(posicion1,barraca);
			
		assertFalse(preguntar.hayEdificio(posicion1));
		assertFalse(preguntar.hayEdificio(posicion2));
		assertFalse(preguntar.hayEdificio(posicion3));
		assertFalse(preguntar.hayEdificio(posicion4));
		assertTrue(barraca.posicion() == null);
	}
	
	@Test
	public void testColocarEdificioRecolectorDeMinerialSobreRecursoMineral(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		Recurso mineral = new RecursoMineral(1000);
		EdificioCentroMineral recolectorMineral = new EdificioCentroMineral(new RecursosDelJugador(1000,1000));
		Posicion posicion = new Posicion(4,4);
		
		colocar.colocarRecurso(posicion, mineral);
		colocar.colocarRecolectorDeMineral(posicion, recolectorMineral);
		
		assertTrue(preguntar.hayEnSuelo(posicion, mineral));
		assertTrue(preguntar.hayEnTierra(posicion, recolectorMineral));
	}
	
	@Test
	public void testNoDebeColocarEdificioRecolectorDeMinerialSinRecursoMineral(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		EdificioCentroMineral recolectorMineral = new EdificioCentroMineral(new RecursosDelJugador(1000,1000));
		Posicion posicion = new Posicion(4,4);
		
		colocar.colocarRecolectorDeMineral(posicion, recolectorMineral);
		
		assertFalse(preguntar.hayEnTierra(posicion, recolectorMineral));		
	}
	
	@Test
	public void testColocarEdificioRecolectorDeGasVespenoSobreRecursoGasVespeno(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		Recurso gasVespeno = new RecursoGasVespeno(2000);
		EdificioRefineria recolectorGasVespeno = new EdificioRefineria(new RecursosDelJugador(1000,1000));
		Posicion posicion = new Posicion(4,4);
		
		colocar.colocarRecurso(posicion, gasVespeno);
		colocar.colocarRecolectorDeGasVespeno(posicion, recolectorGasVespeno);
		
		assertTrue(preguntar.hayEnSuelo(posicion, gasVespeno));
		assertTrue(preguntar.hayEnTierra(posicion, recolectorGasVespeno));	
	}
	
	@Test
	public void testNoDebeColocarEdificioRecolectorDeGasVespenoSinRecursoGasVespeno(){ 
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		EdificioRefineria recolectorGasVespeno = new EdificioRefineria(new RecursosDelJugador(1000,1000));
		Posicion posicion = new Posicion(4,4);
		
		colocar.colocarRecolectorDeGasVespeno(posicion, recolectorGasVespeno);
				
		assertFalse(preguntar.hayEnTierra(posicion, recolectorGasVespeno));
	}
	
	@Test
	public void testNoDebeColocarUnidadTerrestreMarineSobreOtraUnidadTerrestre(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine1 = new UnidadMarine();
		UnidadMarine marine2 = new UnidadMarine();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarTerrenoEn(posicion);
		colocar.colocarUnidadTerrestre(posicion,marine1);
		colocar.colocarUnidadTerrestre(posicion,marine2);
				
		assertTrue(preguntar.hayEnTierra(posicion, marine1));
	}
	
	@Test
	public void testNoDebeColocarUnidadTerrestreMarineSobreEdificio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		EdificioBarraca edificio = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarTerrenoEnTodoElMapa();;
		colocar.colocarEdificio(posicion, edificio);
		colocar.colocarUnidadTerrestre(posicion,marine);
				
		assertTrue(preguntar.hayEnTierra(posicion, edificio));
	}
	
	@Test
	public void testNoDebeColocarEdificioSobreUnidadTerrestre(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadMarine marine = new UnidadMarine();
		EdificioBarraca edificio = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		
		Posicion posicion1 = new Posicion(5,5);
		Posicion posicion2 = new Posicion(6,6);
		
		colocar.colocarTerrenoEnTodoElMapa();;
		colocar.colocarUnidadTerrestre(posicion2 ,marine);
		colocar.colocarEdificio(posicion1 , edificio);
				
		assertTrue(preguntar.hayEnTierra(posicion2, marine));
		assertFalse(preguntar.hayEnTierra(posicion1, edificio));
	}
	
	@Test
	public void testNoDebeColocarEdificioSobreOtroEdificio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		EdificioBarraca edificio1 = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());;
		EdificioBarraca edificio2 = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		Posicion posicion1 = new Posicion(5,5);
		Posicion posicion2 = new Posicion(6,6);
		
		colocar.colocarTerrenoEnTodoElMapa();;
		colocar.colocarEdificio(posicion2, edificio2);
		colocar.colocarEdificio(posicion1, edificio1 );
				
		assertFalse(preguntar.hayEnTierra(posicion1, edificio1));
		assertTrue(preguntar.hayEnTierra(posicion2, edificio2));
	}
	
	@Test
	public void testColocarUnidadAereaEspectro(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadEspectro espectro = new UnidadEspectro();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarUnidadAerea(posicion, espectro);
				
		assertTrue(preguntar.hayEnAire(posicion, espectro));
		assertEquals(espectro.posicion(), posicion);
	}
	
	@Test
	public void testNoDebeColocarUnidadAereaEspectroSobreOtraUnidadAerea(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionColocar colocar = new AccionColocar(mapa);
		AccionPreguntar preguntar = new AccionPreguntar(mapa);
		
		UnidadEspectro espectro1 = new UnidadEspectro();
		UnidadEspectro espectro2 = new UnidadEspectro();
		Posicion posicion = new Posicion(5,5);
		
		colocar.colocarUnidadAerea(posicion, espectro1);
		colocar.colocarUnidadAerea(posicion, espectro2);
				
		assertTrue(preguntar.hayEnAire(posicion, espectro1));
	}
}
