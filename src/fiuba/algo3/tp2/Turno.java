package fiuba.algo3.tp2;

public class Turno {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador turnoActual = jugador1;

	public Turno(Jugador unJugador1, Jugador unJugador2) {
		
		jugador1 = unJugador1;
		jugador2 = unJugador2;
		turnoActual = unJugador1;
	}
	
	public void pasarTurno() {		
		if (turnoActual == jugador1)turnoActual = jugador2;else turnoActual = jugador1;		
	}

	public Jugador jugador() {
		return turnoActual;
	}
}