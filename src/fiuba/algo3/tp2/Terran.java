package fiuba.algo3.tp2;

public abstract class Terran {

	protected int vidaActual;
	protected int  vidaMaxima;
	protected int tiempoConstruccion;
	protected Posicion posicion;	
	protected String nombre;
	protected RecursosDelJugador costoRecurso;
	
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
	
	public void disminuirVida(int danio){
		if(danio>vidaActual)
			vidaActual = 0 ;
		else	
			vidaActual = vidaActual - danio;
	}
	
	public RecursosDelJugador costoRecursos(){
		return costoRecurso;
	}
	public boolean estaDestruido(){
		if (vidaActual == 0)return true; else return false;
	}
	
}
