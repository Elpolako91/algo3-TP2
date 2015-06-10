package fiuba.algo3.tp2;

public abstract class Terran {

	protected int vidaActual;
	protected int  vidaMaxima;
	protected int tiempoConstruccion;
	protected Posicion posicion;
	
	protected String nombre;
	
	public void posicion(Posicion unaPosicion){
		this.posicion = unaPosicion;
	}
	
	public Posicion posicion() {
		return posicion;
	}
	
	public String nombre(){
		return this.nombre;
	}
	public int vidaActual(){
		return this.vidaActual;
	}
	
	public int vidaMaxima(){
		return this.vidaMaxima;
	}
	
}
