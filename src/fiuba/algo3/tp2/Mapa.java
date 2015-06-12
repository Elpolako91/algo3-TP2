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
				mapa.put(p, new CeldaTerreno() );
			}
		}
	}	

	public boolean estaVacio() {		
		return mapa.isEmpty();
	}
	
	public Object contenido(Posicion posicion) {		
		Celda celda = this.mapa.get(posicion);
		return celda.contenido(); 
	}

	/*********** METODOS PREGUNTAR TIPO DE CONTENIDO *****************************/
	
	public boolean hayTerreno(Posicion posicion){
		if (mapa.get(posicion) instanceof CeldaTerreno)	return true;
		else return false;
	}
	
	public boolean hayUnidad(Posicion posicion){
		
		if (mapa.get(posicion).contenido() instanceof UnidadTerran)return true;
		else return false;
	}
	
	public boolean hayVaporVespeno(Posicion posicionDestino) {
		if (mapa.get(posicionDestino).contenido() instanceof VaporVespeno) return true;
		else return false;
	}

	public boolean hayMineral(Posicion posicionDestino) {
		if (mapa.get(posicionDestino).contenido() instanceof Mineral) return true;
		else return false;
	}
	
	public boolean hayTerrenoConTamanio(Posicion posicion){
		
		boolean hayTerreno = true;		
		
		for ( int i = 0; i < 2; i++ ) {			
			for ( int j = 0; j < 2; j++){				
				Posicion posicionActual = new Posicion(posicion.x()+i, posicion.y()+j);
				if (!(this.hayTerreno(posicionActual))) hayTerreno= false;									
			}
		}
		return hayTerreno;
	}
	
	/************************	COLOCACION DE OBJETOS	********************************************/
	
	public void colocarObjeto(Object unObjeto, Posicion posicionDestino) {
		
		Celda c = new Celda();
		c.contenido(unObjeto);
		mapa.put(posicionDestino, c);
		
	}
		
	public void colocarObjetoConTamanio(Object unObjetoConTamanio, Posicion posicion){		
		for ( int i = 0; i < 2; i++ ) {			
			for ( int j = 0; j < 2; j++){		
				this.colocarObjeto(unObjetoConTamanio, new Posicion(posicion.x()+i, posicion.y()+j));
			}
		}
	}

	/********************************************************************/
	
	public void recolectarMineralDeLaPosicion(Posicion posicion, RecolectorMineral recMineral) {
		recMineral.obtenerMineralPorTruno();
		Celda celda = new Celda();
		celda = mapa.get(posicion);
		RecolectorMineral recolectorAux = (RecolectorMineral) celda.contenido();
		recolectorAux.reducirLaCantidadDeRecursoDisponible();
	}
	
	public Posicion encontrarPosicionParaUnidad(Posicion unaPosicion){
		Posicion posicionUnidad = unaPosicion;
		while(!this.hayTerreno(posicionUnidad)){
			posicionUnidad = posicionUnidad.obtenerPosicionAlrededor();
		}
		return posicionUnidad;
		
	}
	
	public boolean moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		Posicion direccionDestino = unidad.posicion().direccion(posicionDestino);
		
		if (this.hayTerreno(direccionDestino)){
			mapa.put(unidad.posicion(), new CeldaTerreno());
			Celda c= new Celda();
			c.contenido(unidad);
			mapa.put(direccionDestino, c);
			unidad.posicion(direccionDestino);
			return true;			
		}
		return false;
	}

	public void colocarTerreno(Posicion posicion) {
		Celda celda= new CeldaTerreno();
		mapa.put(posicion, celda);		
	}

	

	public void colocarEdificioMineral(RecolectorMineral recMineral, Posicion posicionDestino) {
		if (this.hayMineral(posicionDestino)){
			Celda celda = new Celda();
			celda.contenido(recMineral);
			mapa.put(posicionDestino,celda);
		}
		
	}

	public void colocarEdificioVespeno(RecolectorGasVespeno recGas, Posicion posicionDestino) {
		
			Celda celda = new Celda();
			celda.contenido(recGas);
			mapa.put(posicionDestino,celda);			
	}

}
