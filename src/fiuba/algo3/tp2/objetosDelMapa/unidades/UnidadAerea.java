package fiuba.algo3.tp2.objetosDelMapa.unidades;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.Aereo;

public abstract class UnidadAerea extends Unidad implements Aereo{

	protected UnidadAerea(String unNombre, int vida, int escudo, int unTiempoConstruccion, int unaVision, 
			RecursosDelJugador costoRecurso, int unCostoSuministro, int unDanioTierra, int unDanioAire, int unRangoTierra,
			int unRangoAire) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, unaVision, costoRecurso,unCostoSuministro, 
				unDanioTierra, unDanioAire, unRangoTierra, unRangoAire);
	}

}
