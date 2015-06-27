package fiuba.algo3.tp2;

public class Unidad extends Raza{

	protected int danioTierra;
	protected int danioAire;	
	protected int rangoTierra;
	protected int rangoAire;
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
		return rangoTierra;
	}
}
