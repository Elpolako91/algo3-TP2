package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;

public class EdificioBarraca extends EdificioDeUnidades{
	
	public EdificioBarraca(RecursosDelJugador recursosJugador, Suministro suministroJugador){		
		
		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "Barraca";
		tiempoConstruccion = 12;
		vidaActual = 1000;
		vidaMaxima = 1000;
		costoRecurso = new RecursosDelJugador(150,0);
	}

	public UnidadMarine construirMarine() throws RecursosInsuficientes{
		
		UnidadMarine marine = new UnidadMarine();
		this.crearUnidad(marine);
		return marine;
	}
}
