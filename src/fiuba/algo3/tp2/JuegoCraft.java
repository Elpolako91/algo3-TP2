package fiuba.algo3.tp2;

public class JuegoCraft {
	
	private Mapa mapa;
	private Jugador jugador1;
	private Jugador jugador2;
	private Turno turno;
	
	public void crearPartida(Jugador unJugador1, Jugador unJugador2, Mapa unMapa) {
		
		this.jugador1 = unJugador1;
		this.jugador2 = unJugador2;
		this.mapa = unMapa;
		turno = new Turno(jugador1, jugador2);
		
		this.jugador1.juego(this);
		this.jugador2.juego(this);
	}	

	public boolean mapaestavacio() {
			
		return mapa.estaVacio();
	}
	
	public Mapa mapa(){
		return this.mapa;
	}

	public void pasarTurno() {
		turno.pasarTurno();
		
	}

	public Jugador turno() {
		return turno.jugador();
	}

}
