package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioCentroMineral extends EdificioRecolectorDeMineral {

	public EdificioCentroMineral(RecursosDelJugador recursosDisponibles) {
		
		super("Centro de mineral", 500, 0, 4, new RecursosDelJugador(50,0), recursosDisponibles);
	}			
}