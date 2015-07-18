package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;

public abstract class AccionDelJugador extends Accion {

	public AccionDelJugador(Mapa unMapa) {
		super(unMapa);
	}
	
	public abstract void realizar(Posicion unaPosicion, ObjetoDelMapa objeto) throws PosicionInvalida, UnidadMovimientoTerminado;
}
