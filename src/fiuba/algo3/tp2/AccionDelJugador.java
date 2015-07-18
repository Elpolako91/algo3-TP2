package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;

public abstract class AccionDelJugador extends Accion {

	public AccionDelJugador(Mapa unMapa) {
		super(unMapa);
	}
	
	public abstract void realizar(Posicion unaPosicion, ObjetoDelMapa objeto) throws PosicionInvalida, UnidadMovimientoTerminado;
}
