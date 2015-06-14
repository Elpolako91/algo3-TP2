package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Turno {
	
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private Jugador turnoActual;

	public Turno(List<Jugador> unosJugadores) {
		jugadores = unosJugadores;
		turnoActual = jugadores.get(0);
	}

	public void pasarTurno() {
		
		int indiceDeJugador = jugadores.indexOf(turnoActual);
		
	if (indiceDeJugador == (jugadores.size()-1)){
			turnoActual = jugadores.get(0);
		}
		else
			turnoActual = jugadores.get(indiceDeJugador + 1);
	}

	public Jugador turnoActual() {
		return turnoActual;
	}
}