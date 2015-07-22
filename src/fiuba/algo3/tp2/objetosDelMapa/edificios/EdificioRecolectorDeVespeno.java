package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public abstract class EdificioRecolectorDeVespeno extends EdificioRecolectorRecurso{
		
	public EdificioRecolectorDeVespeno(String unNombre, int vida, int escudo, int unTiempoConstruccion,
			RecursosDelJugador costo, RecursosDelJugador recursosDisponibles, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, recursosDisponibles, unaImagen);
	}
	
	@Override
	public void recolectar() {
			
		if(this.recurso().cantidad() >= 10){
			this.recurso().extraer(10);
			this.recursosJuntados().agregar(new RecursosDelJugador(0,10));
		}
		else{
			this.recursosJuntados().agregar(new RecursosDelJugador(0, this.recurso().cantidad()));
			this.recurso().extraer(this.recurso().cantidad());		
		}
	}	

	@Override
	public EnConstruccion enConstruccion(){		
		return new EdificioRecolectorVespenoEnConstruccion(this);
	}
}