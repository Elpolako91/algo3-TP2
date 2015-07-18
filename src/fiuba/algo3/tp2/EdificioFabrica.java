package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;


public class EdificioFabrica extends EdificioDeUnidades {
	
	public EdificioFabrica(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "fabrica";
		tiempoConstruccion = 12;
		vidaActual = 1250;
		vidaMaxima = 1250;
		costoRecurso = new RecursosDelJugador(200,100);
	}
	
	public UnidadGolliat crearGolliat() throws RecursosInsuficientes{
		
		UnidadGolliat golliat = new UnidadGolliat();
		this.crearUnidad(golliat);
		return golliat;
	}
}
