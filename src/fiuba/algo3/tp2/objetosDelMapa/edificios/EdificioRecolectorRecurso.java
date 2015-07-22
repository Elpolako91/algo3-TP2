package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.Recurso;

public abstract class EdificioRecolectorRecurso extends Edificio{
	
	private RecursosDelJugador recursosAJuntar;
	private Recurso recurso;

	public EdificioRecolectorRecurso(String unNombre, int vida, int escudo,
			int unTiempoConstruccion, RecursosDelJugador costo, RecursosDelJugador recursosDelJugador, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, new Tamanio(1,1), unaImagen);
		recursosAJuntar = recursosDelJugador;
	}
	
	public abstract void recolectar();
	
	public void extraeDe(Recurso unRecurso) {		
		recurso = unRecurso;		
	}
	
	protected Recurso recurso(){
		return recurso;
	}
	
	protected RecursosDelJugador recursosJuntados(){
		return recursosAJuntar;
	}

}
