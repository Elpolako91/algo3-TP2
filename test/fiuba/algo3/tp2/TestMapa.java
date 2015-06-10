package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMapa {

	@Test
	public void testCrearMapaConTerreno() {			/* El Terreno tiene como valor una celda
																					vacia */
		Mapa mapa = new Mapa(1000);
		
		assertEquals(false, mapa.estaVacio());
		assertTrue(mapa.getContenido(new Posicion(1,1)) instanceof Terreno);
		
	}
	
	@Test
	public void testColocarMineral(){
		
		Mapa mapa = new Mapa(1000);
		Mineral mineral = new Mineral();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(5,5);
		
		mapa.colocarRecursosEnMapa(mineral,posicion1);
		mapa.colocarRecursosEnMapa(mineral,posicion2);
		
		assertEquals(mineral, mapa.getContenido(posicion1));
		assertEquals(mineral, mapa.getContenido(posicion2));
		
		
	}
	
	@Test
	public void testColocarVaporVespeno(){
		
		Mapa mapa = new Mapa(1000);
		VaporVespeno vaporVespeno = new VaporVespeno();
		Posicion posicion1 = new Posicion(3,3);
		Posicion posicion2 = new Posicion(7,7);
		
		mapa.colocarRecursosEnMapa(vaporVespeno,posicion1);
		mapa.colocarRecursosEnMapa(vaporVespeno,posicion2);
		
		assertEquals(vaporVespeno, mapa.getContenido(posicion1));
		assertEquals(vaporVespeno, mapa.getContenido(posicion2));
		
		
	}
	
	@Test
	public void testColocarRecursosEnPosicionesAleatorias(){
		
		Mapa mapa = new Mapa(1000);
		VaporVespeno vaporVespeno = new VaporVespeno();
		Mineral mineral = new Mineral();
		GeneradorDeNumerosAleatorios numRandom = new GeneradorDeNumerosAleatorios();
		
		int num1 = numRandom.generarNumeroAleatorio();
		int num2 = numRandom.generarNumeroAleatorio();
		int num3 = numRandom.generarNumeroAleatorio();
		int num4 = numRandom.generarNumeroAleatorio();		/*Falta validar que no se pisen las posiciones*/
		
		Posicion posicion1 = new Posicion(num1, num2);
		Posicion posicion2 = new Posicion(num3, num4);
		
		mapa.colocarRecursosEnMapa(vaporVespeno, posicion1);
		mapa.colocarRecursosEnMapa(mineral, posicion2);
		
		assertEquals(vaporVespeno, mapa.getContenido(posicion1));
		assertEquals(mineral, mapa.getContenido(posicion2));
		
	}
	
	@Test
	public void testColocarEdificiosCentralEnMapa(){
		
		Mapa mapa = new Mapa(1000);
		EdificioCentral edfCentral = new EdificioCentral();
		Posicion posicion1 = new Posicion(100, 100);
		Posicion posicion2 = new Posicion(100, 101);
		Posicion posicion3 = new Posicion(101, 100);
		Posicion posicion4 = new Posicion(101, 101);
		
		mapa.colocarEdificio(edfCentral, posicion1);
		
		assertEquals(edfCentral, mapa.getContenido(posicion1));
		assertEquals(edfCentral, mapa.getContenido(posicion2));
		assertEquals(edfCentral, mapa.getContenido(posicion3));
		assertEquals(edfCentral, mapa.getContenido(posicion4));
		
	}
	
	@Test
	public void testColocarEdificiosDeMinerialYDeGasVespenoEnMapa(){ /*Prueba colocar los edificios sobre los recursos*/
		
		Mapa mapa = new Mapa(1000);
		RecolectorMineral recMineral = new RecolectorMineral();
		RecolectorGasVespeno recGas = new RecolectorGasVespeno();
		VaporVespeno vaporVespeno = new VaporVespeno();
		Mineral mineral = new Mineral();
		Posicion posicion1 = new Posicion(100,55);
		Posicion posicion2 = new Posicion(55,50);
		
		mapa.colocarRecursosEnMapa(mineral, posicion1);
		mapa.colocarRecursosEnMapa(vaporVespeno, posicion2);
		mapa.colocarEdificioDeRecoleccion(recMineral, posicion1);
		mapa.colocarEdificioDeRecoleccion(recGas, posicion2);
		
		assertEquals(recMineral, mapa.getContenido(posicion1));
		assertEquals(recGas, mapa.getContenido(posicion2));
		
	}
	
	@Test
	public void testColocarUnidadesMovilesEnMapa(){
		
		Mapa mapa = new Mapa(1000);
		Posicion posicion = new Posicion(100,55);
		UnidadTerran marine = new UnidadMarine();
		
		mapa.colocarUnidad(marine, posicion);
		
		assertEquals(marine, mapa.getContenido(posicion));

		
	}
	

}
