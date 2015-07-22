package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Tamanio;

public abstract class EdificioDeSuministro extends Edificio{

	public EdificioDeSuministro(String unNombre, int vida, int escudo, int unTiempoConstruccion, RecursosDelJugador costo, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, new Tamanio(2,2), unaImagen);
	}
}
