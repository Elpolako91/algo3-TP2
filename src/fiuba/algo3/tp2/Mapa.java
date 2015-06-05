package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
	
	private Map<Posicion, Celda> mapa;
	
	public Mapa(int tamaño){
		
		this.mapa = new HashMap<>();
		for (int i = 1; i <= tamaño; i++){
			for (int j = 1; j <= tamaño; j++){
				Posicion p = new Posicion(i,j);
				mapa.put(p, new CeldaVacia() );
			}
		}
	}
	

	public boolean estaVacio() {
		
		return mapa.isEmpty();
	}


	public void colocarRecursosEnMapa(Recurso recurso, Posicion posicionActual) {
		
		Celda celda = new Celda();
		celda.colocarRecursoEnCelda(recurso);
		
		mapa.put(posicionActual, celda);
		
	}


	public Object getContenido(Posicion posicion) {
		
		Celda celdaActual = this.mapa.get(posicion);
		
		return celdaActual.getContenidoDeCelda(); 
	}


	public void colocarEdificiosDelJugador(EdificioTerran edificio, Posicion posicion) {
		
		if ( this.validarPosicion(edificio, posicion) == false ){
			
			return;	/* Retornar una Excepcion de no poder poner unidad */
		}

		Celda celda = new Celda();
		celda.colocarEdificioEnCelda(edificio);
		this.colocarEdificioEnMapa(edificio, posicion, celda);
		
	}
	
	public boolean validarPosicion(EdificioTerran edificio, Posicion posicion) {
		
		CeldaVacia c = new CeldaVacia();
		for ( int i = 0; i <= 1; i++ ) {
			
			for ( int j = 0; j <=1; j++){
				
				Posicion posicionAux = new Posicion(posicion.obtenerPosicionCercanaEnX(i), posicion.obtenerPosicionCercanaEnY(j) );
				if ( this.posicionValidada(mapa.get(posicionAux), c ) == false ) {
					
					return false;		
					
				}
			}
		}
		
		return true;
		
	}


	private boolean posicionValidada(Celda celdaActual, Celda c) {
		
		if ( celdaActual.equals(c) ){
			
			return true;
		}
		
		return false;
	}
	
	private void colocarEdificioEnMapa(EdificioTerran edificio, Posicion posicion, Celda celda){
	
	for ( int i = 0; i <= 1; i++ ) {
		
		for ( int j = 0; j <=1; j++){
			
			Posicion posicionAux = new Posicion(posicion.obtenerPosicionCercanaEnX(i), posicion.obtenerPosicionCercanaEnY(j) );
			mapa.put(posicionAux, celda);
		}
	}
}


	public void colocarEdificioDeRecoleccion(EdificioTerran edificioRecolector, Posicion posicion) {
		
		if ( this.validarPosicion(edificioRecolector, posicion) ){
			return; /*Excepcion que no hay recursos ahi*/
		}
		/*Esta mal, tengo que verificar que sea mineral o gas vespeno
		 * TambiÃ©n validar que no sea una posicion fuera del mapa*/
		Celda celda = new Celda();
		celda.colocarEdificioEnCelda(edificioRecolector);
		this.colocarEdificioEnMapa(edificioRecolector, posicion, celda);
			
	}


	public void recolectarMineralDeLaPosicion(Posicion posicion, RecolectorMineral recMineral) {
		
		recMineral.obtenerMineralPorTruno();
		Celda celda = new Celda();
		celda = mapa.get(posicion);
		RecolectorMineral recolectorAux = (RecolectorMineral) celda.getContenidoDeCelda();
		recolectorAux.reducirLaCantidadDeRecursoDisponible();
		
	}

}
