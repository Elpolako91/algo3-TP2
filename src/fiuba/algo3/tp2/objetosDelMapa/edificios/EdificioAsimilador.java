package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class EdificioAsimilador extends EdificioRecolectorDeVespeno {

	public EdificioAsimilador(RecursosDelJugador recursosDisponibles) {
		
		super("Asimilador", 450, 450, 6, new RecursosDelJugador(100,0), recursosDisponibles, new ImageIcon(EdificioAsimilador.class.getResource("/imagenes/razaTerran.jpg")));
	}
}