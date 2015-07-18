package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.Recurso;

public abstract class EdificioRecolectorRecurso extends Edificio{
	
	private RecursosDelJugador recursosAJuntar;
	private Recurso recurso;

	public EdificioRecolectorRecurso(String unNombre, int vida, int escudo,
			int unTiempoConstruccion, RecursosDelJugador costo, RecursosDelJugador recursosDelJugador) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, new Tamanio(1,1));
		recursosAJuntar = recursosDelJugador;
	}
	
	public void recolectar() {
		
		if(recurso.cantidad() >= 10){
			recurso.extraer(10);
			recursosAJuntar.agregar(new RecursosDelJugador(10,0));
		}
		else{
			recursosAJuntar.agregar(new RecursosDelJugador(recurso.cantidad(),0));
			recurso.extraer(recurso.cantidad());
		}
	}
	
	public void extraeDe(Recurso unRecurso) {		
		recurso = unRecurso;		
	}

}
