package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;


public class EdificioArchivosTemplarios extends EdificioDeUnidades {
	
	public EdificioArchivosTemplarios(RecursosDelJugador recursosJugador, Suministro suministroJugador) {

		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "archivos templarios";
		tiempoConstruccion = 9;
		vidaActual = 500;
		vidaMaxima = 500;
		escudoActual = 500;
		escudoMaximo = 500;
		costoRecurso = new RecursosDelJugador(150,200);
	}

	public UnidadAltoTemplario construirAltoTemplario() throws RecursosInsuficientes {
		
		UnidadAltoTemplario altoTemplario = new UnidadAltoTemplario();
		this.crearUnidad(altoTemplario);
		return altoTemplario;
	}
}
