package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadNaveTransporteProtos;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadScout;

public class EdificioPuertoEstelarProtos extends EdificioDeUnidades {
	
	public  EdificioPuertoEstelarProtos(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles) {
		
		super("Puerto estelar protos", 600, 600, 10, new RecursosDelJugador(150,150), new Tamanio(2,2), recursosDisponibles, suministrosDisponibles, new ImageIcon(EdificioPuertoEstelarProtos.class.getResource("/imagenes/razaProtos.jpg")));
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
