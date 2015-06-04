package fiuba.algo3.tp2;

public class JuegoCraft {
	
	private Mapa mapa;
	private Jugador jugador1;
	private Jugador jugador2;

	public JuegoCraft() {
		mapa = new Mapa (1000);
	}

	public void cargarJugador1(String unNombre, String unColor, String unaRaza) {
		jugador1 = new Jugador(unNombre, unColor, unaRaza);		
	}
	
	public void cargarJugador2(String unNombre, String unColor, String unaRaza) {
		jugador2 = new Jugador(unNombre, unColor, unaRaza);		
	}

	public String jugador1Nombre() {
		
		return jugador1.nombre();
	}
	
	public String jugador2Nombre() {
		
		return jugador2.nombre();
	}

	public boolean mapaestavacio() {
			
		return mapa.estaVacio();
	}
	
}
