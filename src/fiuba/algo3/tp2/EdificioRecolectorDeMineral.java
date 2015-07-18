package fiuba.algo3.tp2;

public abstract class EdificioRecolectorDeMineral extends Edificio {

	protected RecursosDelJugador recursos;
	private RecursoMineral mineral;
	
	protected EdificioRecolectorDeMineral(){
		tamanio = new Tamanio(1,1);
	}
	
	public void recolectaMineral() {
		
		if(mineral.cantidad() >= 10){
			mineral.extraer(10);
			recursos.agregar(new RecursosDelJugador(10,0));
		}
		else{
			recursos.agregar(new RecursosDelJugador(mineral.cantidad(),0));
			mineral.extraer(mineral.cantidad());
		}
	}

	
	public void extraeDe(RecursoMineral recursoMineral) {
		
		mineral = recursoMineral;		
	}
}
