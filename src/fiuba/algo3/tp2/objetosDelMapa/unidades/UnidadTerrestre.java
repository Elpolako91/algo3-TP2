package fiuba.algo3.tp2.objetosDelMapa.unidades;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.Terrestre;

public abstract class UnidadTerrestre extends Unidad implements Terrestre{

	private int ocupacionTransporte;
	
	protected UnidadTerrestre(String unNombre, int vida, int escudo, int unTiempoConstruccion, int unaVision, 
			RecursosDelJugador costoRecurso, int unCostoSuministro,	int unDanioTierra, int unDanioAire, int unRangoTierra,
			int unRangoAire, int unaOcupacionDeTransporte) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, unaVision, costoRecurso, unCostoSuministro, 
				unDanioTierra, unDanioAire, unRangoTierra, unRangoAire);
		
		ocupacionTransporte = unaOcupacionDeTransporte;
	}
	
	public int ocupacionTransporte(){
		return ocupacionTransporte;
	}
}
