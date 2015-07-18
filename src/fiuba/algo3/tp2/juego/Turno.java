package fiuba.algo3.tp2.juego;

import java.util.ArrayList;
import java.util.List;

public class Turno {
	
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private Jugador jugadorActual;

	public Turno(List<Jugador> unosJugadores) {
		jugadores = unosJugadores;
		jugadorActual = jugadores.get(0);
	}

	public void pasarTurno() {
		
		int indiceDeJugador = jugadores.indexOf(jugadorActual);
		
	if (indiceDeJugador == (jugadores.size()-1)){
			jugadorActual = jugadores.get(0);
		}
		else
			jugadorActual = jugadores.get(indiceDeJugador + 1);
	}

	public Jugador jugadorActual() {
		return jugadorActual;
	}
}