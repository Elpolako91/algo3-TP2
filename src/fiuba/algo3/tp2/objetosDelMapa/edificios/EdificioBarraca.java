package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;

public class EdificioBarraca extends EdificioDeUnidades{
	
	public EdificioBarraca(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles){	
		
		super("Barraca", 1000, 0, 12, new RecursosDelJugador(150,0), new Tamanio(2,2), recursosDisponibles, suministrosDisponibles);
	}

	public UnidadMarine construirMarine() throws RecursosInsuficientes{
		
		UnidadMarine marine = new UnidadMarine();
		this.crearUnidad(marine);
		return marine;
	}
}
