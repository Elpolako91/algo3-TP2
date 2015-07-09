package fiuba.algo3.tp2;

public abstract class AccionDelJugador extends Accion {

	public AccionDelJugador(Mapa unMapa) {
		super(unMapa);
	}
	
	public abstract void realizar(Posicion unaPosicion, Raza objeto);

}
