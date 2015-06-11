package fiuba.algo3.tp2;

public class JuegoCraft {
	
	private Mapa mapa;
	private Jugador jugador1;
	private Jugador jugador2;
	private Turno turno;
	
	public Jugador cargarJugadorUno(String unNombre, String unColor, String unaRaza) {
		jugador1 = new Jugador(unNombre,unColor,unaRaza);
		return jugador1;
	}

	public Jugador cargarJugadorDos(String unNombre, String unColor, String unaRaza) {
		jugador2 = new Jugador(unNombre,unColor,unaRaza);
		return jugador2;
	}

	public void iniciarPartida() {
		turno = new Turno(jugador1, jugador2);
		Posicion posicion1 = new Posicion(2,2);
		Posicion posicion2 = new Posicion(96,96);
		jugador1.juego(this);
		this.colocarEdificio(jugador1.base(), posicion1);
		jugador2.juego(this);
		this.colocarEdificio(jugador2.base(), posicion2);
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

	public void crearMapa(int tamanio) {
		mapa = new Mapa(tamanio);		
	}

	public boolean colocarEdificio(EdificioTerran unEdificio, Posicion posicion) {
		if(mapa.hayTerrenoConTamanio(posicion)){
			mapa.colocarObjetoConTamanio(unEdificio, posicion);
			unEdificio.posicion(posicion);
			return true;	
		
		}
		else return false;
	}

	public boolean colocarUnidad(UnidadTerran unaUnidad, EdificioTerran unEdificio) {
		Posicion posicionUnidad = mapa.encontrarPosicionParaUnidad(unEdificio.posicion());
		unaUnidad.posicion(posicionUnidad);
		mapa.colocarObjeto(unaUnidad, posicionUnidad);
		return true;
	}

	public void construirRecolectorVaporVespeno(Posicion posicion, RecolectorGasVespeno recGas) {
		
		if ( this.mapa().hayVaporVespeno(posicion) ){
			
			this.mapa().colocarObjetoConTamanio(recGas, posicion);
		}
	}
	
	public void construirRecolectorMineral(Posicion posicion, RecolectorMineral recMineral){
		
		if ( this.mapa().hayMineral(posicion) ){
			
			this.mapa().colocarObjetoConTamanio(recMineral, posicion);
		}
	}
}