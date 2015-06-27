package fiuba.algo3.tp2;


public class EdificioFabrica extends EdificioDeUnidades {
	
	public EdificioFabrica(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		recursos = recursosJugador;
		suministros = suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "fabrica";
		tiempoConstruccion = 12;
		vidaActual = 1250;
		vidaMaxima = 1250;
		costoRecurso = new RecursosDelJugador(200,100);
	}
	
	public UnidadGolliat crearGolliat(){
		
		UnidadGolliat golliat = new UnidadGolliat();
		if((recursos.hayCantidadSuficiente(golliat.costoRecursos())) && (suministros.hayCantidadSuficiente(golliat.costoSuministro()))){
			
			unidadesEnConstruccion.add(golliat);
			recursos.descontar(golliat.costoRecursos());
			suministros.gastar(golliat.costoSuministro());
			return golliat;
		}
		
		return null;
	}
}
