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
	
	private Map<Posicion, Celda> mapa;
	private Tamanio tamanio;
	
	public Mapa(Tamanio unTamanio){
	
		tamanio = unTamanio;
		mapa = new HashMap<>();
		for (int i = 1; i <= tamanio.enX(); i++){
			for (int j = 1; j <= tamanio.enY(); j++){
				
				this.inicializarPosicion(new Posicion(i,j));
			}
		}		
	}	
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	public Object contenido(Posicion posicion) {	
		Celda celda = mapa.get(posicion);
		if (celda != null)
			return celda.contenido();
		else
			return new PosicionFueraDelMapa();
	}
	
	/************************	Validacion De Posiciones	********************************************/
	
	private void inicializarPosicion(Posicion posicion) {
		Celda celda= new Celda(new Vacio());
		mapa.put(posicion, celda);		
	}
	
	public boolean esPosicionValida(Posicion posicion){
		if (!(this.contenido(posicion) instanceof PosicionFueraDelMapa))	return true;
		else return false;
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
	
	public void colocarObjeto(Posicion posicionDestino, Object unObjeto) {
		
		Celda c = new Celda(unObjeto);
		if (this.esPosicionValida(posicionDestino))mapa.put(posicionDestino, c);		
	}
		
	public void colocarObjeto(Posicion posicion,Object unObjetoConTamanio, Tamanio tamanio){
		if(this.sonPosicionesValidas(posicion,tamanio)){
			for ( int i = 0; i < tamanio.enX(); i++ ) {			
				for ( int j = 0; j < tamanio.enY(); j++){		
					this.colocarObjeto(posicion.obtenerNuevaMovidaEn(i, j), unObjetoConTamanio);
				}			
			}
		
		}
	}
	
	public void intercambiarObjetos(Posicion posicion1, Posicion posicion2) {
		
		if((this.esPosicionValida(posicion1)) && (this.esPosicionValida(posicion2))){
			
			Object objeto1 = this.contenido(posicion1);
			Object objeto2 = this.contenido(posicion2);
			
			this.colocarObjeto(posicion1, objeto2);
			this.colocarObjeto(posicion2, objeto1);
		}
	}
	
	public void removerObjeto(Posicion posicion) {
		
		if(this.esPosicionValida(posicion))
			this.inicializarPosicion(posicion);		
	}	
	
	/**************** METODOS PREGUNTAR TIPO DE CONTENIDO *****************************/
	
	public boolean hayTerreno(Posicion posicion) {
		if (this.contenido(posicion) instanceof Terreno)
			return true;
		else 
			return false;
	}
	
	public boolean hayTerreno(Posicion posicion,Tamanio tamanio) {
		
		boolean hayTerreno = true;
		for ( int i = 0; i < tamanio.enX(); i++ ) {			
			for ( int j = 0; j < tamanio.enY(); j++){
				
				Posicion posicionActual = new Posicion(posicion.x()+i, posicion.y()+j);
				if (!this.hayTerreno(posicionActual))
					hayTerreno = false;
			}
		}
		return hayTerreno;
	}
	
	public boolean hayUnidad(Posicion posicion){
		
		if (this.contenido(posicion) instanceof UnidadTerran)
			return true;
		else 
			return false;
	}
	
	public boolean hayGasVespeno(Posicion posicion) {
		if (this.contenido(posicion) instanceof RecursoGasVespeno) return true;
		else return false;
	}

	public boolean hayMineral(Posicion posicion) {
		if (this.contenido(posicion) instanceof RecursoMineral) 
			return true;
		else 
			return false;
	}
	
	public boolean hayEdificio(Posicion posicion) {
		if (this.contenido(posicion) instanceof EdificioTerran)
			return true;
		else
			return false;
	}	
	
	public boolean estaFueraDelMapa(Posicion posicion){
		
		if (this.contenido(posicion) instanceof PosicionFueraDelMapa)
			return true;
		else
			return false;			
	}
	
	public boolean hayVacio(Posicion posicion){
		
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