package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.Terrestre;


public abstract class Edificio extends ObjetoDelJugador implements Terrestre , Edificable{
	
	private Tamanio tamanio;
		
	public Edificio(String unNombre, int vida, int escudo,
			int unTiempoConstruccion, RecursosDelJugador costo, Tamanio unTamanio, ImageIcon unaImagen) {
				
		super(unNombre, vida, escudo, unTiempoConstruccion, 15, costo, unaImagen);
		tamanio = unTamanio;
	}
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	public EnConstruccion enConstruccion(){		
		return new EdificioEnConstruccion(this);
	}
}
