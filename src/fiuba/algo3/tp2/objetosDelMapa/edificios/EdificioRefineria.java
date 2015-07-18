package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioRefineria extends EdificioRecolectorDeVespeno {

	public EdificioRefineria(RecursosDelJugador recursosDisponibles) {
		
		super("Refineria", 750, 0, 6, new RecursosDelJugador(100,0), recursosDisponibles);
	}
}