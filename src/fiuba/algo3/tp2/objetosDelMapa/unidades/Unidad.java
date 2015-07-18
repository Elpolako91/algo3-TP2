package fiuba.algo3.tp2.objetosDelMapa.unidades;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelJugador;

public abstract class Unidad extends ObjetoDelJugador{
	
	final int MOVIMIENTO_MAXIMO_POR_TURNO = 10;
	
	private int danioTierra;
	private int danioAire;	
	private int rangoTierra;
	private int rangoAire;
	private int costoSuministro;
	
	private int movimientoPosible = MOVIMIENTO_MAXIMO_POR_TURNO;
	private boolean ataquePosible = true;

	protected Unidad(String unNombre, int vida, int escudo,	int unTiempoConstruccion, int unaVision, RecursosDelJugador costoRecurso,
			int unCostoSuministro, int unDanioTierra, int unDanioAire, int unRangoTierra, int unRangoAire) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, unaVision, costoRecurso);
		
		danioTierra = unDanioTierra;
		danioAire = unDanioAire;
		rangoTierra = unRangoTierra;
		rangoAire = unRangoAire;
		costoSuministro = unCostoSuministro;		
	}
	
	public int costoSuministro(){
		return costoSuministro;
	}
	
	public int danioTierra() {		
		return danioTierra;
	}
	
	public int danioAire(){		
		return danioAire;
	}

	public int rangoTierra(){		
		return rangoTierra;
	}
	
	public int rangoAire(){		
		return rangoAire;
	}
	
	public boolean movimientoPosible(int i){
		
		if(movimientoPosible >= i)
			return true;
		else
			return false;
	}
	
	public boolean ataquePosible(){
		return ataquePosible;
	}

	public void turnoTerminado() {
		
		ataquePosible = false;
		movimientoPosible = 0;
	}
	
	public void pasoDado(int pasosDados) {
		
		movimientoPosible = movimientoPosible - pasosDados;
	}
	
	public void empezarTurno(){
		movimientoPosible = MOVIMIENTO_MAXIMO_POR_TURNO;
		ataquePosible = true;
	}	
}
