package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class EdificioPilon extends EdificioDeSuministro {
	
	public EdificioPilon(){		
		
		super("Pilon", 300, 300, 5, new RecursosDelJugador(100,0), new ImageIcon(EdificioPilon.class.getResource("/imagenes/razaProtos.jpg")));
	}
}
