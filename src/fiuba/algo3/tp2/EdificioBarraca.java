package fiuba.algo3.tp2;

public class EdificioBarraca extends EdificioTerran{
	
	public EdificioBarraca(){
		
		tamanio = new Tamanio(2,2);
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
