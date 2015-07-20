package fiuba.algo3.tp2.objetosDelMapa;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.mapa.Posicion;

public abstract class ObjetoDelJugador extends ObjetoDelMapa {
	
	private String nombre;
	
	private int vidaActual;
	private int  vidaMaxima;
	private int escudoActual = 0;
	private int escudoMaximo = 0;
	
	private int tiempoConstruccion;	
	private int vision;
	
	private RecursosDelJugador costoRecurso;
	
	private Posicion posicion;	
	
	protected ObjetoDelJugador(String unNombre, int vida, int escudo, int unTiempoConstruccion, int unaVision, RecursosDelJugador costo){
		
		nombre = unNombre;
		vidaActual = vidaMaxima = vida;
		escudoActual = escudoMaximo = escudo;
		tiempoConstruccion = unTiempoConstruccion;
		vision = unaVision;
		costoRecurso = costo;
	}
	
	/********************** accesors *********************************/
		
	public void posicion(Posicion unaPosicion){		
		posicion = unaPosicion;
	}
	
	public Posicion posicion() {		
		return posicion;
	}
	
	public String nombre(){		
		return nombre;
	}
	
	public int vidaActual(){		
		return vidaActual;
	}
	
	public int vidaMaxima(){		
		return vidaMaxima;
	}
	
	public RecursosDelJugador costoRecursos(){
		return costoRecurso;
	}
	
	public int tiempoConstruccion(){
		return tiempoConstruccion;
	}
	
	public int escudoActual(){
		return escudoActual;
	}
	
	public int escudoMaximo(){
		return escudoMaximo;
	}
	
	public int vision(){
		return vision;
	}
	
	/*********************************************************************************************************/
	
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
		else{
			
			if (danioRestante <= vidaActual)
				vidaActual = vidaActual - danioRestante;
			else
				vidaActual = 0;
			
		}	
	}
	
	
	public boolean estaDestruido(){
		if (vidaActual == 0)return true; else return false;
	}
	

	
	public void progresa(){
		tiempoConstruccion = tiempoConstruccion -1;
	}
	
	
}
