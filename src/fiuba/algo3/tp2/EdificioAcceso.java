package fiuba.algo3.tp2;


public class EdificioAcceso extends EdificioDeUnidades {
	
	public EdificioAcceso(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		recursos = recursosJugador;
		suministros =suministroJugador;
		
		tamanio = new Tamanio(2,2);
		nombre = "Acceso";
		tiempoConstruccion = 8;
		vidaActual = 500;
		vidaMaxima = 500;
		escudoActual = 500;
		escudoMaximo = 500;
		costoRecurso = new RecursosDelJugador(150,0);
	}
	
	public UnidadZealot construirZealot() {
		
		UnidadZealot zealot = new UnidadZealot();
		if((recursos.hayCantidadSuficiente(zealot.costoRecursos())) && (suministros.hayCantidadSuficiente(zealot.costoSuministro()))){
			
			unidadesEnConstruccion.add(zealot);
			recursos.descontar(zealot.costoRecursos());
			suministros.gastar(zealot.costoSuministro());
			return zealot;
		}
		
		return null;		
	}
	
	public UnidadDragon construirDragon() {
		
		UnidadDragon dragon = new UnidadDragon();
		if((recursos.hayCantidadSuficiente(dragon.costoRecursos())) && (suministros.hayCantidadSuficiente(dragon.costoSuministro()))){
			
			unidadesEnConstruccion.add(dragon);
			recursos.descontar(dragon.costoRecursos());
			suministros.gastar(dragon.costoSuministro());
			return dragon;
		}
		
		return null;
	}
}
