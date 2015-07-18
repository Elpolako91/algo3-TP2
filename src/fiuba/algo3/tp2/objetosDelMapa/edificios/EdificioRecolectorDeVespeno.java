package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public abstract class EdificioRecolectorDeVespeno extends EdificioRecolectorRecurso{
		
	public EdificioRecolectorDeVespeno(String unNombre, int vida, int escudo, int unTiempoConstruccion,
			RecursosDelJugador costo, RecursosDelJugador recursosDisponibles) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, recursosDisponibles);
	}		
}