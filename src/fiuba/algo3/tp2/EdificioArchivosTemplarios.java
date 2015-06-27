package fiuba.algo3.tp2;


public class EdificioArchivosTemplarios extends EdificioDeUnidades {
	
	public EdificioArchivosTemplarios(RecursosDelJugador recursosJugador, Suministro suministroJugador) {
		
		recursos = recursosJugador;
		suministros =suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "archivos templarios";
		tiempoConstruccion = 9;
		vidaActual = 500;
		vidaMaxima = 500;
		escudoActual = 500;
		escudoMaximo = 500;
		costoRecurso = new RecursosDelJugador(150,200);
	}

	public UnidadAltoTemplario construirAltoTemplario() {
		
		UnidadAltoTemplario altoTemplario = new UnidadAltoTemplario();
		
		if((recursos.hayCantidadSuficiente(altoTemplario.costoRecursos())) && (suministros.hayCantidadSuficiente(altoTemplario.costoSuministro()))){
			
			unidadesEnConstruccion.add(altoTemplario);
			recursos.descontar(altoTemplario.costoRecursos());
			suministros.gastar(altoTemplario.costoSuministro());
			return altoTemplario;
		}
		
		return null;	
	}


}
