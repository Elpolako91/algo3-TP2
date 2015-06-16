package fiuba.algo3.tp2;

public class EdificioFabrica extends EdificioTerran {
	
	public EdificioFabrica(){
		
		tamanio = new Tamanio(2,2);
		nombre = "fabrica";
		tiempoConstruccion = 12;
		vidaActual = 1250;
		vidaMaxima = 1250;
		costoRecurso = new RecursosDelJugador(200,100);
	}
	
	public UnidadGolliat crearGolliat(){
		
		UnidadGolliat golliat = new UnidadGolliat();
		return golliat;
	}

}
