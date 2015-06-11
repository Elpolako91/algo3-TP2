package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAtaque {

	@Test
	public void testDosUnidadesSeAtacan() {
		
		Jugador jugador1 = new Jugador("goku","azul","Terran");
		Jugador jugador2 = new Jugador("gohan","verde","Terran");
		Mapa mapa = new Mapa(100);
		JuegoCraft juego = new JuegoCraft();
		
		juego.crearPartida(jugador1, jugador2, mapa);
		Barraca barraca1 = new Barraca();
		
		Posicion posicion1 = new Posicion(50,50);
		Posicion posicion2 = new Posicion(60,50);
		Posicion posicion3 = new Posicion(60,51);
		
		jugador1.colocarEdificio(posicion1, barraca1);
		UnidadTerran unidad1 = jugador1.construirMarine();
		UnidadTerran unidad2 = jugador1.construirMarine();
		jugador1.moverUnidad(unidad2, posicion2);
		jugador1.moverUnidad(unidad1, posicion3);
		
		jugador1.atacar(posicion2, unidad1);
		
		assertEquals(34, unidad2.vidaActual());
		
	}

}
