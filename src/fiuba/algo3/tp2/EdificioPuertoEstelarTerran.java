package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;


public class EdificioPuertoEstelarTerran extends EdificioDeUnidades{
	
	public EdificioPuertoEstelarTerran(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "Puerto Estelar Terran";
		tiempoConstruccion = 10;
		vidaActual = 1300;
		vidaMaxima = 1300;
		costoRecurso = new RecursosDelJugador(150,100);
	}
	
	public UnidadEspectro construirEspectro() throws RecursosInsuficientes {
		
		UnidadEspectro espectro = new UnidadEspectro();
		this.crearUnidad(espectro);
		return espectro;
	}
	
	public UnidadNaveCiencia construirNaveCiencia() throws RecursosInsuficientes {
		
		UnidadNaveCiencia naveCiencia = new UnidadNaveCiencia();
		this.crearUnidad(naveCiencia);
		return naveCiencia;
	}
	
	public UnidadNaveTransporteTerran construirNaveTransporte() throws RecursosInsuficientes {
		
		UnidadNaveTransporteTerran transporte = new UnidadNaveTransporteTerran();
		this.crearUnidad(transporte);
		return transporte;
	}	
}
