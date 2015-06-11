package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMapa {

	@Test
	public void testCrearMapaConTerreno() {			/* El Terreno tiene como valor una celda
																					vacia */
		Mapa mapa = new Mapa(1000);
		
		assertEquals(false, mapa.estaVacio());
		assertTrue(mapa.contenido(new Posicion(1,1)) instanceof Terreno);
		
	}
	
	@Test
	public void testColocarMineral(){
		
		Mapa mapa = new Mapa(100);
		Mineral mineral = new Mineral();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(5,5);
		
		mapa.colocarObjeto(mineral,posicion1);
		mapa.colocarObjeto(mineral,posicion2);
		
		assertEquals(mineral, mapa.contenido(posicion1));
		assertEquals(mineral, mapa.contenido(posicion2));
		
		
	}
	
	@Test
	public void testColocarVaporVespeno(){
		
		Mapa mapa = new Mapa(100);
		VaporVespeno vaporVespeno = new VaporVespeno();
		Posicion posicion1 = new Posicion(3,3);
		Posicion posicion2 = new Posicion(7,7);
		
		mapa.colocarObjeto(vaporVespeno,posicion1);
		mapa.colocarObjeto(vaporVespeno,posicion2);
		
		assertEquals(vaporVespeno, mapa.contenido(posicion1));
		assertEquals(vaporVespeno, mapa.contenido(posicion2));
		
		
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
		
		mapa.colocarObjeto(vaporVespeno, posicion1);
		mapa.colocarObjeto(mineral, posicion2);
		
		assertEquals(vaporVespeno, mapa.contenido(posicion1));
		assertEquals(mineral, mapa.contenido(posicion2));
		
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
		
		assertEquals(edfCentral, mapa.contenido(posicion1));
		assertEquals(edfCentral, mapa.contenido(posicion2));
		assertEquals(edfCentral, mapa.contenido(posicion3));
		assertEquals(edfCentral, mapa.contenido(posicion4));
		
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
		
		mapa.colocarObjeto(mineral, posicion1);
		mapa.colocarObjeto(vaporVespeno, posicion2);
		mapa.colocarEdificioMineral(recMineral, posicion1);
		mapa.colocarEdificioVespeno(recGas, posicion2);
		
		assertEquals(recMineral, mapa.contenido(posicion1));
		assertEquals(recGas, mapa.contenido(posicion2));
		
	}
	
	@Test
	public void testColocarUnidadesMovilesEnMapa(){
		
		Mapa mapa = new Mapa(1000);
		Posicion posicion = new Posicion(100,55);
		UnidadTerran marine = new UnidadMarine();
		
		mapa.colocarUnidad(marine, posicion);
		
		assertEquals(marine, mapa.contenido(posicion));		
	}
	
	@Test
	public void testColocarUnidadYMoverla(){
		
		JuegoCraft juego = new JuegoCraft();		
		Jugador jugador1 = juego.cargarJugadorUno("pipo", "azul", "terran");
		Jugador jugador2 = juego.cargarJugadorDos("pepe", "rojo", "terran");
		juego.crearMapa(100);	
		juego.iniciarPartida();
		
		Posicion posicionEdificio = new Posicion(1,1);
		Posicion posicionInicial = new Posicion(3,3);
		Posicion posicionFinal = new Posicion (20,20);
		
		Barraca barraca = new Barraca();
		jugador1.colocarEdificio(posicionEdificio, barraca);

		UnidadMarine marine = jugador1.construirMarine(barraca);
		assertTrue(marine instanceof UnidadMarine);
		
		assertTrue(juego.mapa().contenido(posicionInicial) instanceof UnidadMarine);
		assertEquals(jugador1.unidades(),1);
		assertEquals(jugador1.edificios(),1);

		jugador1.moverUnidad(marine,posicionFinal);
		
		assertTrue(juego.mapa().contenido(posicionFinal) instanceof UnidadMarine);
	}
}
