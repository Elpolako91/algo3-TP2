package fiuba.algo3.tp2;


public class EdificioPuertoEstelarProtos extends EdificioDeUnidades {
	
	public  EdificioPuertoEstelarProtos(RecursosDelJugador recursosJugador, Suministro suministroJugador) {
		
		recursos = recursosJugador;
		suministros =suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "Puerto estelar protos";
		tiempoConstruccion = 10;
		vidaActual = 600;
		vidaMaxima = 600;
		escudoActual = 600;
		escudoMaximo = 600;
		costoRecurso = new RecursosDelJugador(150,150);
	}
	
	public UnidadScout construirScout() {
		
		UnidadScout scout = new UnidadScout();
		
		if((recursos.hayCantidadSuficiente(scout.costoRecursos())) && (suministros.hayCantidadSuficiente(scout.costoSuministro()))){
			
			unidadesEnConstruccion.add(scout);
			recursos.descontar(scout.costoRecursos());
			suministros.gastar(scout.costoSuministro());
			return scout;
		}
		
		return null;
	}
	
	public UnidadNaveTransporteProtos construirNaveTransporte() {
		
		UnidadNaveTransporteProtos naveTransporte = new UnidadNaveTransporteProtos();
		
		if((recursos.hayCantidadSuficiente(naveTransporte.costoRecursos())) && (suministros.hayCantidadSuficiente(naveTransporte.costoSuministro()))){
			
			unidadesEnConstruccion.add(naveTransporte);
			recursos.descontar(naveTransporte.costoRecursos());
			suministros.gastar(naveTransporte.costoSuministro());
			return naveTransporte;
		}
		
		return null;
	}
}
