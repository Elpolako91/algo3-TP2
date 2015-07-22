package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadMarine extends UnidadTerrestre {

	public UnidadMarine() {
		
		super("Marine", 40, 0, 3, 7, new RecursosDelJugador(50,0),1, 6, 6, 4, 4, 1, new ImageIcon(UnidadMarine.class.getResource("/imagenes/unidadesTerrestre.jpg")));
	}
}
