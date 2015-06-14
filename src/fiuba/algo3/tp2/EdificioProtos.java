package fiuba.algo3.tp2;

public abstract class EdificioProtos extends RazaProtos implements Edificio {
	
	protected Tamanio tamanio;
	protected int escudoActual;
	protected int escudoMaximo;

	public int escudoActual(){
		return escudoActual;
	}
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	
}
