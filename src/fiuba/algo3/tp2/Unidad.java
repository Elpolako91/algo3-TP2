package fiuba.algo3.tp2;

public class Unidad extends Raza{

	final int MOVIMIENTO_MAXIMO_POR_TURNO = 10;
	
	protected int danioTierra;
	protected int danioAire;	
	protected int rangoTierra;
	protected int rangoAire;
	protected int costoSuministro;
	protected int movimientoPosible = MOVIMIENTO_MAXIMO_POR_TURNO;
	protected boolean ataquePosible = true;
	
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
	
	public boolean movimientoPosible(){
		
		if(movimientoPosible > 0)
			return true;
		
		return false;
	}
	
	public boolean ataquePosible(){
		return ataquePosible;
	}

	public void turnoTerminado() {
		
		ataquePosible = false;
		movimientoPosible = 0;
	}
	
	public void pasoDado() {
		
		movimientoPosible --;
	}
	
	public void empezarTurno(){
		movimientoPosible = MOVIMIENTO_MAXIMO_POR_TURNO;
		ataquePosible = true;
	}
	
	
}
