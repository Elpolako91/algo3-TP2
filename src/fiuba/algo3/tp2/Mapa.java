package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Map;
/*
 * Mapa Inicializa con un tamanio asignandole a cada posicion una celda con un contenido Vacio
 * 
 * El mapa solo colocaca objetos en sus posiciones validas
 * 
 * Si al mapa se le pide devolver un objeto en una posion invalida devuelve un objeto PosicionFueraDelMapa
*/
public class Mapa {
	
	private Map<PosicionMapa, Celda> mapa = new HashMap<>();
	
	private Tamanio tamanio;
	
	public Mapa(Tamanio unTamanio){
	
		tamanio = unTamanio;
		for (int i = 1; i <= tamanio.enX(); i++)
			for (int j = 1; j <= tamanio.enY(); j++)
				for (int k = 0; k <= 2; k++)
				this.inicializarPosicion(new PosicionMapa(i,j,k));
				
			
		
	}	
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	public Object contenido(PosicionMapa posicion) {	
		Celda celda = mapa.get(posicion);
		if (celda != null)
			return celda.contenido();
		else
			return new PosicionFueraDelMapa();
	}
	
	private void inicializarPosicion(PosicionMapa posicion) {
		Celda celda= new Celda(new Vacio());
		mapa.put(posicion, celda);
	}
	
	/************************	Validacion De Posiciones	********************************************/
	
	public boolean esPosicionValida(Posicion posicion){
		if (posicion.estaDentro(tamanio)) 
			return true;
		else 
			return false;
	}
	
	public boolean sonPosicionesValidas(Posicion posicion, Tamanio tamanio){
		
		boolean posicionesValidas = true;		
		
		for ( int i = 0; i < tamanio.enX(); i++ ) {			
			for ( int j = 0; j < tamanio.enY(); j++){			
				
				Posicion posicionActual = posicion.obtenerNuevaMovidaEn(i, j);
				if (!(this.esPosicionValida(posicionActual))) posicionesValidas= false;									
			}
		}
		return posicionesValidas;
	}
	
	/************************	Acciones Del Mapa	********************************************/
	
	public void colocarObjeto(PosicionMapa posicionDestino, Object unObjeto) {
		
		Celda c = new Celda(unObjeto);
		if (posicionDestino.estaDentro(tamanio))mapa.put(posicionDestino, c);		
	}
		
	public void colocarObjeto(PosicionMapa posicion,Object unObjetoConTamanio, Tamanio tamanio){
		Posicion p = new Posicion(posicion.x(),posicion.y());
		if(this.sonPosicionesValidas(p,tamanio)){
			for ( int i = 0; i < tamanio.enX(); i++ ) {			
				for ( int j = 0; j < tamanio.enY(); j++){		
					this.colocarObjeto(posicion.obtenerNuevaMovidaEn(i, j), unObjetoConTamanio);
				}			
			}
		
		}
	}
	
	public void intercambiarObjetos(PosicionMapa posicion1, PosicionMapa posicion2) {
		
		if((this.esPosicionValida(posicion1)) && (this.esPosicionValida(posicion2))){
			
			Object objeto1 = this.contenido(posicion1);
			Object objeto2 = this.contenido(posicion2);
			
			this.colocarObjeto(posicion1, objeto2);
			this.colocarObjeto(posicion2, objeto1);
		}
	}
	
	public void removerObjeto(PosicionMapa posicion) {
		
		if(this.esPosicionValida(posicion))
			this.inicializarPosicion(posicion);		
	}	
	
	/**************** METODOS PREGUNTAR TIPO DE CONTENIDO *****************************/
	
	public boolean hayVacio(PosicionMapa posicion){
		
		if (this.contenido(posicion) instanceof Vacio)
			return true;
		else
			return false;			
	}
	
	/********************************************************************/

	// este metodo no Va aca
	
	public Posicion encontrarPosicionParaUnidad(Posicion unaPosicion){
		Posicion posicionUnidad = unaPosicion;
		while(!this.esPosicionValida(posicionUnidad)){
			posicionUnidad = posicionUnidad.obtenerPosicionAlrededor();
		}
		return posicionUnidad;
	}
	
}