package fiuba.algo3.tp2;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
	
	private Map<Posicion, Celda> mapa;
	
	public Mapa(int tamanio){
		
		this.mapa = new HashMap<>();
		for (int i = 1; i <= tamanio; i++){
			for (int j = 1; j <= tamanio; j++){
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
		
		return celdaActual.contenido(); 
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


	private boolean posicionValidada(Celda celdaActual, CeldaVacia c) {
		
		if ( celdaActual.equals(c) ){
			
			return true;					/*celdaActual es CeldaVacia devuelve true*/
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
		 * También validar que no sea una posicion fuera del mapa*/
		Celda celda = new Celda();
		celda.colocarEdificioEnCelda(edificioRecolector);
		this.colocarEdificioEnMapa(edificioRecolector, posicion, celda);
			
	}


	public void recolectarMineralDeLaPosicion(Posicion posicion, RecolectorMineral recMineral) {
		
		recMineral.obtenerMineralPorTruno();
		Celda celda = new Celda();
		celda = mapa.get(posicion);
		RecolectorMineral recolectorAux = (RecolectorMineral) celda.contenido();
		recolectorAux.reducirLaCantidadDeRecursoDisponible();
		
	}


	public void colocarUnidadMovil(UnidadTerran marine, Posicion posicion) {
		
		Celda celdaActual = new Celda();
		CeldaVacia c = new CeldaVacia();
		celdaActual = this.mapa.get(posicion);		
		
		while (! this.posicionValidada(celdaActual, c)){
			posicion= posicion.obtenerPosicionAlrededor();			
			celdaActual = this.mapa.get(posicion);
		}			
		marine.posicion(posicion);
		celdaActual.colocarUnidadMovil(marine);
		mapa.put(posicion, celdaActual);
	}
		
	public void colocarUnidad(UnidadTerran unidad, Posicion edificioPosicion){
		
		Posicion posicionAux = edificioPosicion;
		Celda c = new Celda();
		c.contenido(unidad);
		while(!this.hayTerrenoVacio(posicionAux)){
			posicionAux = posicionAux.obtenerPosicionAlrededor();
		}
		unidad.posicion(posicionAux);
		mapa.put(posicionAux, c);
		
	}
	
	private boolean hayTerrenoVacio(Posicion posicion){
		if (mapa.get(posicion) instanceof CeldaVacia)
			return true;
		else 
			return false;
	}
	
	public boolean colocarEdificio(EdificioTerran unEdificio, Posicion posicion) {
		boolean condicion;
		if (!this.validarPosicionParaObjetoConTamanio(posicion)) condicion= false;
		else{
			this.colocarObjetoConTamanio(unEdificio, posicion);
			condicion = true;	
		}
		return condicion;
	}
	private boolean validarPosicionParaObjetoConTamanio(Posicion posicion){
		
		boolean condicion = true;		
		
		for ( int i = 0; i <= 1; i++ ) {			
			for ( int j = 0; j <=1; j++){				
				Posicion posicionAux = new Posicion(posicion.x()+i, posicion.y()+j);
				if (!(mapa.get(posicionAux) instanceof CeldaVacia)) condicion= false;									
			}
		}
		return condicion;
	}
	
	private void colocarObjetoConTamanio(Object unObjetoConTamanio, Posicion posicion){		
		for ( int i = 0; i <= 1; i++ ) {			
			for ( int j = 0; j <=1; j++){		
				Celda c = new Celda();
				c.contenido(unObjetoConTamanio);
				Posicion posicionAux = new Posicion(posicion.x()+i, posicion.y()+j );
				mapa.put(posicionAux, c);
			}
		}
	}

	public boolean moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		Posicion direccionDestino = unidad.posicion().direccion(posicionDestino);
		
		if (this.hayTerrenoVacio(direccionDestino)){
			mapa.put(unidad.posicion(), new CeldaVacia());
			Celda c= new Celda();
			c.contenido(unidad);
			mapa.put(direccionDestino, c);
			unidad.posicion(direccionDestino);
			return true;			
		}
		return false;
	}


	public boolean hayUnidad(Posicion posicion){
		
		if (mapa.get(posicion).contenido() instanceof UnidadTerran)
			return true;
		else 
			return false;
	}
	
	public void atacar(Posicion posicion, UnidadTerran unidad){
		
		if ( this.hayUnidad(posicion) ){
			
			UnidadTerran unidadAux = (UnidadTerran)mapa.get(posicion).contenido();
			unidadAux.disminuirVida(unidad.danioTierra());			
		}
	}
				
	

}
