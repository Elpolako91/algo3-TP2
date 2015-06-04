package fiuba.algo3.tp2;

public abstract class Edificio {
		
	protected int vidaMaxima;
	protected int vidaActual;
	
	protected int escudoMaximo;
	protected int escudoActual;
	
	protected int cantRecursoDisponible;
	protected int almacenamiento;
	
	public Object getVidaActual() {
		
		return this.vidaActual;
	}

	public Object getEscudoActual() {
		
		return this.escudoActual;
	}

	
}
