package fiuba.algo3.tp2;

public class EdificioCentral extends EdificioTerran {
	
	public EdificioCentral() {	
		
		vidaMaxima = 2000;
		vidaActual = 2000;
		
	}

	public Barraca construirBarraca() {
		
		Barraca edificio = new Barraca();
		return (edificio);
	}

	public RecolectorGasVespeno construirRecolectorGasVespeno() {
		
		RecolectorGasVespeno edificio = new RecolectorGasVespeno();
		return (edificio);
	}

	public RecolectorMineral construirRecolectorMineral() {
		
		RecolectorMineral edificio = new RecolectorMineral();
		return (edificio);
	}
		
}

