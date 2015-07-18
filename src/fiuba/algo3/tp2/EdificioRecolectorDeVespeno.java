package fiuba.algo3.tp2;

public abstract class EdificioRecolectorDeVespeno extends Edificio{
	
	protected RecursosDelJugador recursos;
	private RecursoGasVespeno vespeno;
	
	protected EdificioRecolectorDeVespeno(){
		tamanio = new Tamanio(1,1);
	}
	public void recolectarVespeno() {
		
		if(vespeno.cantidad() >= 10){
			vespeno.extraer(10);
			recursos.agregar(new RecursosDelJugador(0,10));
		}
		else{
			recursos.agregar(new RecursosDelJugador(0,vespeno.cantidad()));
			vespeno.extraer(vespeno.cantidad());
		}
	}

	
	public void extraeDe(RecursoGasVespeno recursoVespeno) {
		
		vespeno = recursoVespeno;
		
	}

}
