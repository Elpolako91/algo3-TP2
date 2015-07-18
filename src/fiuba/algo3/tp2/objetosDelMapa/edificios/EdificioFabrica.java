package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadGolliat;

public class EdificioFabrica extends EdificioDeUnidades {
	
	public EdificioFabrica(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles){
		
		super("fabrica", 1250, 0, 12, new RecursosDelJugador(200,100), new Tamanio(2,2), recursosDisponibles, suministrosDisponibles);
	}
	
	public UnidadGolliat crearGolliat() throws RecursosInsuficientes{
		
		UnidadGolliat golliat = new UnidadGolliat();
		this.crearUnidad(golliat);
		return golliat;
	}
}
