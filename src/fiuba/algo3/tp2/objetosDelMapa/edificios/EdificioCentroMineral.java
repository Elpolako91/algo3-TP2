package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioCentroMineral extends EdificioRecolectorDeMineral {

	public EdificioCentroMineral(RecursosDelJugador recursosDisponibles) {
		
		super("Centro de mineral", 500, 0, 4, new RecursosDelJugador(50,0), recursosDisponibles, new ImageIcon(EdificioCentroMineral.class.getResource("/imagenes/razaTerran.jpg")));
	}			
}