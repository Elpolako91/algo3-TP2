package fiuba.algo3.tp2;

public class EdificioArchivosTemplarios extends EdificioProtos {
	
	public EdificioArchivosTemplarios() {
		
		tamanio = new Tamanio(2,2);
		nombre = "archivos templarios";
		tiempoConstruccion = 9;
		vidaActual = 500;
		vidaMaxima = 500;
		escudoActual = 500;
		escudoMaximo = 500;
		costoRecurso = new RecursosDelJugador(150,200);
	}

	
	
	public UnidadAltoTemplario construirUnidad() {
		UnidadAltoTemplario unidad = new UnidadAltoTemplario();
		return unidad;
	}


}
