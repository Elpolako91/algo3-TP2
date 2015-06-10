package fiuba.algo3.tp2;

public class Turno {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador miTurno = jugador1;

	public Turno(Jugador unJugador1, Jugador unJugador2) {

		this.jugador1 = unJugador1;
		this.jugador2 = unJugador2;
		this.miTurno = unJugador1;
	}
	
	public void pasarTurno() {
		
		if (miTurno == jugador1){miTurno = jugador2;}else{miTurno = jugador1;}
		
	}

	public Jugador jugador() {
		return miTurno;
	}
}
