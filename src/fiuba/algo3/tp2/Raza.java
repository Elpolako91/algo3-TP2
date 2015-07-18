package fiuba.algo3.tp2;


public abstract class Raza extends ObjetoDelMapa {
	
	protected int vidaActual;
	protected int  vidaMaxima;
	protected int tiempoConstruccion;
	protected Posicion posicion;	
	protected String nombre;
	protected RecursosDelJugador costoRecurso;
	protected int vision;
	protected int escudoActual = 0;
	protected int escudoMaximo = 0;
	
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
		
		int danioRestante = danio;
		
		if(escudoActual > 0){
		
			if(danio <= escudoActual)
				escudoActual = escudoActual - danio;
			else{
				danioRestante = danioRestante - escudoActual;
				escudoActual = 0;
			}		
		}
		
		if (danioRestante <= vidaActual)
			vidaActual = vidaActual - danioRestante;
		else
			vidaActual = 0;
	}
	
	public RecursosDelJugador costoRecursos(){
		return costoRecurso;
	}
	public boolean estaDestruido(){
		if (vidaActual == 0)return true; else return false;
	}
	
	public int tiempoConstruccion(){
		return tiempoConstruccion;
	}
	
	public void progresa(){
		tiempoConstruccion = tiempoConstruccion -1;
	}
	
	public int escudoActual(){
		return escudoActual;
	}

}
