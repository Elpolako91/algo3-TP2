package fiuba.algo3.tp2;

public abstract class UnidadTerran extends RazaTerran {
	
	protected int danioAire;
	protected int danioTierra;
	protected int rango;
	protected int costoSuministro;
	
	public int costoSuministro(){
		return costoSuministro;
	}
	
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
