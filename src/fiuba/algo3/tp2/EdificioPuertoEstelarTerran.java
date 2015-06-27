package fiuba.algo3.tp2;


public class EdificioPuertoEstelarTerran extends EdificioDeUnidades{
	
	public EdificioPuertoEstelarTerran(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		recursos = recursosJugador;
		suministros =suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "Puerto Estelar Terran";
		tiempoConstruccion = 10;
		vidaActual = 1300;
		vidaMaxima = 1300;
		costoRecurso = new RecursosDelJugador(150,100);
	}
	
	public UnidadEspectro construirEspectro() {
		
		UnidadEspectro espectro = new UnidadEspectro();
		
		if((recursos.hayCantidadSuficiente(espectro.costoRecursos())) && (suministros.hayCantidadSuficiente(espectro.costoSuministro()))){
			
			unidadesEnConstruccion.add(espectro);
			recursos.descontar(espectro.costoRecursos());
			suministros.gastar(espectro.costoSuministro());
			return espectro;
		}
		
		return null;
	}
	
	public UnidadNaveCiencia construirNaveCiencia() {
		
		UnidadNaveCiencia naveCiencia = new UnidadNaveCiencia();
		
		if((recursos.hayCantidadSuficiente(naveCiencia.costoRecursos())) && (suministros.hayCantidadSuficiente(naveCiencia.costoSuministro()))){
			
			unidadesEnConstruccion.add(naveCiencia);
			recursos.descontar(naveCiencia.costoRecursos());
			suministros.gastar(naveCiencia.costoSuministro());
			return naveCiencia;
		}
		
		return null;
	}
	
	public UnidadNaveTransporteTerran construirNaveTransporte() {
		
		UnidadNaveTransporteTerran transporte = new UnidadNaveTransporteTerran();
		
		if((recursos.hayCantidadSuficiente(transporte.costoRecursos())) && (suministros.hayCantidadSuficiente(transporte.costoSuministro()))){
			
			unidadesEnConstruccion.add(transporte);
			recursos.descontar(transporte.costoRecursos());
			suministros.gastar(transporte.costoSuministro());
			return transporte;
		}
		
		return null;
	}

}
