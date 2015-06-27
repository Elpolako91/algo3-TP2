package fiuba.algo3.tp2;


public class EdificioBarraca extends EdificioDeUnidades{
	
	public EdificioBarraca(RecursosDelJugador recursosJugador, Suministro suministroJugador){		
		
		recursos = recursosJugador;
		suministros =suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "Barraca";
		tiempoConstruccion = 12;
		vidaActual = 1000;
		vidaMaxima = 1000;
		costoRecurso = new RecursosDelJugador(150,0);
	}

	public UnidadMarine construirMarine() {
		
		UnidadMarine marine = new UnidadMarine();
		if((recursos.hayCantidadSuficiente(marine.costoRecursos())) && (suministros.hayCantidadSuficiente(marine.costoSuministro()))){
			
			unidadesEnConstruccion.add(marine);
			recursos.descontar(marine.costoRecursos());
			suministros.gastar(marine.costoSuministro());
			return marine;
		}
		
		return null;		
	}
}
