package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class UnidadDragon extends UnidadTerrestre {

	public UnidadDragon() {
		
		super("Dragon", 80, 100, 6, 8, new RecursosDelJugador(125,50), 2, 20, 20, 4, 4, 4, new ImageIcon(UnidadDragon.class.getResource("/imagenes/unidadesTerrestre.jpg")));
	}	
}