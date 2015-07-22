package fiuba.algo3.tp2.objetosDelMapa.unidades;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;


public class UnidadEspectro extends UnidadAerea {

	public UnidadEspectro() {
		
		super("Espectro", 120, 0, 8, 7, new RecursosDelJugador(150,100), 2, 8, 20, 5, 5, new ImageIcon(UnidadEspectro.class.getResource("/imagenes/unidadesTerrestre.jpg")));		
	}
}