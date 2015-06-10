package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsIntegracion {
	
	@Test
	public void TestJugadoresConUnEdificioYunSoldado(){
		
		Jugador jugador1 = new Jugador("Tincho", "rojo", "terran");
		Jugador jugador2 = new Jugador("Facu", "verde","terran");
		
		JuegoCraft juego = new JuegoCraft();
		Mapa mapa = new Mapa(1000);
		
		juego.crearPartida(jugador1, jugador2, mapa);
			
		Posicion posicion1 = new Posicion(12,15);
		Posicion posicion1a = new Posicion(13,15);
		Posicion posicion1b = new Posicion(13,16);
		Posicion posicion1c = new Posicion(12,16);
		Posicion posicion2 = new Posicion(981,960);
		Posicion posicion3 = new Posicion(983,950);
						
		EdificioTerran barraca1 = new Barraca();
		jugador1.colocarEdificio(posicion1,barraca1);
		jugador1.pasarTurno();
		
		assertEquals(jugador1.edificios(),1);
		
		EdificioTerran barraca2 = new Barraca();
		jugador2.colocarEdificio(posicion2, barraca2);
						
		UnidadTerran marine1 = jugador1.construirMarine();
		assertEquals(jugador1.unidades(),1);
		
		assertTrue(juego.mapa().getContenido(posicion1) instanceof Barraca);
		assertTrue(juego.mapa().getContenido(marine1.posicion()) instanceof UnidadMarine);
		
		assertEquals(barraca1, juego.mapa().getContenido(posicion1a));
		assertEquals(barraca1, juego.mapa().getContenido(posicion1b));
		assertEquals(barraca1, juego.mapa().getContenido(posicion1c));
		
		assertEquals(barraca2, juego.mapa().getContenido(posicion2));
		
		UnidadTerran marine2 = jugador2.construirMarine();
		
		assertEquals(jugador2.unidades(),1);
		

		int distanciaInicial= marine1.posicion().distancia(marine2.posicion());
		System.out.println(distanciaInicial);
		
		Posicion posicionAntiguaMarine = marine1.posicion();
		
		assertTrue(mapa.getContenido(marine1.posicion()) instanceof UnidadMarine);
		jugador1.moverUnidad(marine1,posicion2);
		assertTrue(mapa.getContenido(new Posicion(44,47)) instanceof UnidadMarine);
		distanciaInicial= marine1.posicion().distancia(marine2.posicion());
		System.out.println(distanciaInicial);
		assertTrue(juego.mapa().getContenido(marine1.posicion()) instanceof UnidadMarine);
		assertTrue(juego.mapa().getContenido(posicionAntiguaMarine) instanceof Terreno);
		
		posicionAntiguaMarine = marine2.posicion();
		
		assertTrue(mapa.getContenido(marine2.posicion()) instanceof UnidadMarine);
		jugador2.moverUnidad(marine2,posicion3);
		jugador2.moverUnidad(marine2,posicion1);
		
		distanciaInicial= marine1.posicion().distancia(marine2.posicion());
		System.out.println(distanciaInicial);
		
		assertTrue(juego.mapa().getContenido(marine2.posicion()) instanceof UnidadMarine);
		assertTrue(juego.mapa().getContenido(posicionAntiguaMarine) instanceof Terreno);
					
	}

}
