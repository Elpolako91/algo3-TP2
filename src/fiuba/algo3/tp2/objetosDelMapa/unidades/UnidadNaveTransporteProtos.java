package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadNaveTransporteProtos extends UnidadTransporte {

	public UnidadNaveTransporteProtos() {
		
		super("Nave transporte", 60, 80, 8, 8, new RecursosDelJugador(200,0), 2, 0, 0, 0, 0, new ImageIcon(UnidadNaveTransporteProtos.class.getResource("/imagenes/unidadesVoladoras.jpg")));
	}
}