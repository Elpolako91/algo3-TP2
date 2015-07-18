package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadEspectro;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadNaveCiencia;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadNaveTransporteTerran;

public class EdificioPuertoEstelarTerran extends EdificioDeUnidades{
	
	public EdificioPuertoEstelarTerran(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles){
		
		super("Puerto estelar terran", 1300, 0, 10, new RecursosDelJugador(150,100), new Tamanio(2,2), recursosDisponibles, suministrosDisponibles);
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
