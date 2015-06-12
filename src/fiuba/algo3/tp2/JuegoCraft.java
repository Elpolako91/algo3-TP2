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
		jugador1.juego(this);
		jugador2.juego(this);
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

	public void atacar(Jugador jugadorAtacante,UnidadTerran unidadAtacante, Posicion posicionDestino) {
		if(unidadAtacante.posicion().distancia(posicionDestino)<= unidadAtacante.rango()&&(mapa.hayUnidad(posicionDestino))){
			UnidadTerran unidadAtacada = (UnidadTerran) mapa.contenido(posicionDestino);
			unidadAtacada.disminuirVida(unidadAtacante.danioTierra());
			if (unidadAtacada.estaDestruido()){
				mapa.colocarTerreno(posicionDestino);
				Jugador jugadorAtacado = this.jugadorEnemigo(jugadorAtacante);
				jugadorAtacado.eliminarUnidad(unidadAtacada);					//ACA DEBE IR UNIDADES DEL ENEMIG
			}
		}
	}

	private Jugador jugadorEnemigo(Jugador jugadorAtacante) {
		if(jugadorAtacante== jugador1) 
			return jugador2;
		else
			return jugador1;
	}
}