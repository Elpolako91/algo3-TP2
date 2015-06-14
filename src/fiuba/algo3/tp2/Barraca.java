package fiuba.algo3.tp2;

public class Barraca extends EdificioTerran{
	
	public Barraca(){
		
		nombre = "barraca";
		tiempoConstruccion = 12;
		vidaActual = 1000;
		vidaMaxima = 1000;
		costoRecurso = new RecursosDelJugador(150,0);
	}

	public UnidadMarine construirUnidad() {
		UnidadMarine unidad = new UnidadMarine();
		return unidad;
	}

}
