package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadScout extends UnidadAerea {

	public UnidadScout() {
		
		super("Scout", 100, 150, 9, 7, new RecursosDelJugador(300,150), 3, 8, 14, 4, 4, new ImageIcon(UnidadScout.class.getResource("/imagenes/unidadesVoladoras.jpg")));
	}
}