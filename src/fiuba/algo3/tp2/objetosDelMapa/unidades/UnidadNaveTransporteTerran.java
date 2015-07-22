package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadNaveTransporteTerran extends UnidadTransporte {

	public UnidadNaveTransporteTerran() {
		
		super("Nave transporte", 150, 0, 7, 8, new RecursosDelJugador(100,100), 2, 0, 0, 0, 0, new ImageIcon(UnidadNaveTransporteTerran.class.getResource("/imagenes/unidadesVoladoras.jpg")));
	}
}