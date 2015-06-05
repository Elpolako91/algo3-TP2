package fiuba.algo3.tp2;

public class RecolectorMineral extends EdificioTerran {

	public RecolectorMineral() {
		
		this.vidaMaxima = 500;
		this.vidaActual = 500;
		this.cantRecursoDisponible = 500;
		
	}

	public void obtenerMineralPorTruno() {
		
		this.almacenamiento = this.almacenamiento + 10;
		
	}

	public void reducirLaCantidadDeRecursoDisponible() {
		
		this.cantRecursoDisponible = this.cantRecursoDisponible - 10;
		
	}

	public int getCantRecursoDisponible() {
		
		return this.cantRecursoDisponible;
	}

		

}
