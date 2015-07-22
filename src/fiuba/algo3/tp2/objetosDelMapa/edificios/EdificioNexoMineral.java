package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioNexoMineral extends EdificioRecolectorDeMineral {

	public EdificioNexoMineral(RecursosDelJugador recursosDisponibles) {
		
		super("Centro de mineral", 250, 250, 4, new RecursosDelJugador(50,0), recursosDisponibles, new ImageIcon(EdificioNexoMineral.class.getResource("/imagenes/razaProtos.jpg")));
	}	
}