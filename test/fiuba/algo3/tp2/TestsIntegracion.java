package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestsIntegracion {
	
	@Test
	public void TestJugadoresConUnEdificioYunSoldado(){
		
		Mapa mapa= new Mapa(1000);
			
		Jugador jugador1 = new Jugador("Tincho", "rojo", "terran");
		Jugador jugador2 = new Jugador("Facu", "verde","terran");
		
		Posicion posicion1 = new Posicion(12,15);
		Posicion posicion2 = new Posicion(981,960);
		
		
		jugador1.colocarEdificioBarraca(posicion1);
		jugador1.pasarTurno();
		
		jugador2.colocarEdificioBarraca(posicion2);
		jugador2.pasarTurno();
		
		jugador1.construirMarine();
		jugador1.pasarTurno();
		
		jugador2.contruirMarine();
		jugador2.pasarTurno();
		
		jugador1.moverMarine(posicion2);
				
		mapa.colocarEdificiosDelJugador(edificio, posicion);		
	}

}
