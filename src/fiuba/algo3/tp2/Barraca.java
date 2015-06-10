package fiuba.algo3.tp2;

public class Barraca extends EdificioTerran{
	
	public Barraca(){
		
		this.nombre = "barraca";
		this.tiempoConstruccion = 12;
		this.vidaActual = 1000;
		this.vidaMaxima = 1000;
	}

	public UnidadMarine construirUnidad() {
		UnidadMarine unidad = new UnidadMarine();
		return unidad;
	}

}
