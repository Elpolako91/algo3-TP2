package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEdificioCentral {

	/*********************   TEST a REFACTORIZAR *******************************/
	
	@Test
	public void testCrearEdificioCentral() {
		
		JuegoCraft juego = new JuegoCraft();
		Jugador jugador1 = juego.cargarJugadorUno("facu","azul","terran");
		Jugador jugador2 = juego.cargarJugadorDos("arian","rojo","terran");
		juego.crearMapa(100);
		Posicion posicion1 = new Posicion(10,10);
		Posicion posicion2 = new Posicion(20,20);
		Posicion posicion3 = new Posicion(30,30);
		VaporVespeno vapor = new VaporVespeno();
		Mineral mineral = new Mineral();
		
		juego.iniciarPartida();
		juego.mapa().colocarObjeto(vapor, posicion2);
		juego.mapa().colocarObjeto(mineral, posicion3);
		
		Barraca barraca = jugador1.construirBarraca
		RecolectorGasVespeno recGas = jugador1.construirRecolectorGasVespeno(posicion2);
		RecolectorMineral recMineral = jugador1.construirRecolectorMineral(posicion3);
		
		assertTrue(juego.mapa().contenido(posicion1) == barraca );
		assertTrue(juego.mapa().contenido(posicion2) == recGas );
		assertTrue(juego.mapa().contenido(posicion3) == recMineral );
				
		
		
	}

}
