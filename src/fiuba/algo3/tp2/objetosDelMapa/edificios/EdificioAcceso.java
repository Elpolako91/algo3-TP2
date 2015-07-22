package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadDragon;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadZealot;


public class EdificioAcceso extends EdificioDeUnidades {
		
	public EdificioAcceso(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles) {
		
		super("Acceso", 500, 500, 8, new RecursosDelJugador(150,0),	new Tamanio(2,2), recursosDisponibles, suministrosDisponibles, new ImageIcon(EdificioAcceso.class.getResource("/imagenes/razaProtos.jpg")));		
	}

	public UnidadZealot construirZealot() throws RecursosInsuficientes {
		
		UnidadZealot zealot = new UnidadZealot();
		this.crearUnidad(zealot);
		return zealot;	
	}
	
	public UnidadDragon construirDragon() throws RecursosInsuficientes {
		
		UnidadDragon dragon = new UnidadDragon();
		this.crearUnidad(dragon);
		return dragon;
	}
}
