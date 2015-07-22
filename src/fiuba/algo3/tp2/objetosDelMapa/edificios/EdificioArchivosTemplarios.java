package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadAltoTemplario;


public class EdificioArchivosTemplarios extends EdificioDeUnidades {
	
	public EdificioArchivosTemplarios(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles) {

		super("Archivos templarios", 500, 500, 9, new RecursosDelJugador(150,200), new Tamanio(2,2), recursosDisponibles, suministrosDisponibles, new ImageIcon(EdificioArchivosTemplarios.class.getResource("/imagenes/razaProtos.jpg")));
	}

	public UnidadAltoTemplario construirAltoTemplario() throws RecursosInsuficientes {
		
		UnidadAltoTemplario altoTemplario = new UnidadAltoTemplario();
		this.crearUnidad(altoTemplario);
		return altoTemplario;
	}
}
