package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;


public class EdificioPuertoEstelarProtos extends EdificioDeUnidades {
	
	public  EdificioPuertoEstelarProtos(RecursosDelJugador recursosJugador, Suministro suministroJugador) {
		
		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "Puerto estelar protos";
		tiempoConstruccion = 10;
		vidaActual = 600;
		vidaMaxima = 600;
		escudoActual = 600;
		escudoMaximo = 600;
		costoRecurso = new RecursosDelJugador(150,150);
	}
	
	public UnidadScout construirScout() throws RecursosInsuficientes {
		
		UnidadScout scout = new UnidadScout();
		this.crearUnidad(scout);
		return scout;
	}
	
	public UnidadNaveTransporteProtos construirNaveTransporte() throws RecursosInsuficientes {
		
		UnidadNaveTransporteProtos naveTransporte = new UnidadNaveTransporteProtos();
		this.crearUnidad(naveTransporte);
		return naveTransporte;
		
	}
}
