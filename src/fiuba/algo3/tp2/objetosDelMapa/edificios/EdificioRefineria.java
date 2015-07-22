package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioRefineria extends EdificioRecolectorDeVespeno {

	public EdificioRefineria(RecursosDelJugador recursosDisponibles) {
		
		super("Refineria", 750, 0, 6, new RecursosDelJugador(100,0), recursosDisponibles, new ImageIcon(EdificioRefineria.class.getResource("/imagenes/razaProtos.jpg")));
	}
}