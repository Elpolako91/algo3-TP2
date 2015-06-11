package fiuba.algo3.tp2;

public abstract class UnidadTerran extends Terran {
	
	protected int danioAire;
	protected int danioTierra;
	protected int rango;
	
	public int danioTierra() {
		
		return this.danioTierra;
	}
	
	public int danioAire(){	
		
		return this.danioAire;
	}

	public int rango(){		
		return rango;
	}
}
