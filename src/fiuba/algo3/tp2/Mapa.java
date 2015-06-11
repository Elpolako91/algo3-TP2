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
	
	public void recolectarMineralDeLaPosicion(Posicion posicion, RecolectorMineral recMineral) {
		recMineral.obtenerMineralPorTruno();
		Celda celda = new Celda();
		celda = mapa.get(posicion);
		RecolectorMineral recolectorAux = (RecolectorMineral) celda.contenido();
		recolectorAux.reducirLaCantidadDeRecursoDisponible();
	}

	public void colocarUnidad(UnidadTerran unidad, Posicion edificioPosicion){
		
		Posicion posicionAux = edificioPosicion;
		Celda c = new Celda();
		c.contenido(unidad);
		while(!this.hayTerreno(posicionAux)){
			posicionAux = posicionAux.obtenerPosicionAlrededor();
		}
		unidad.posicion(posicionAux);
		mapa.put(posicionAux, c);
		
	}
	
	private boolean hayTerreno(Posicion posicion){
		if (mapa.get(posicion) instanceof CeldaTerreno)
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
		
		for ( int i = 0; i < 2; i++ ) {			
			for ( int j = 0; j < 2; j++){				
				Posicion posicionAux = new Posicion(posicion.x()+i, posicion.y()+j);
				if (!(mapa.get(posicionAux) instanceof CeldaTerreno)) condicion= false;									
			}
		}
		return condicion;
	}
	
	private void colocarObjetoConTamanio(Object unObjetoConTamanio, Posicion posicion){		
		for ( int i = 0; i < 2; i++ ) {			
			for ( int j = 0; j < 2; j++){		
				Celda c = new Celda();
				c.contenido(unObjetoConTamanio);
				Posicion posicionAux = new Posicion(posicion.x()+i, posicion.y()+j );
				mapa.put(posicionAux, c);
			}
		}
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

	public boolean hayUnidad(Posicion posicion){
		
		if (mapa.get(posicion).contenido() instanceof UnidadTerran)
			return true;
		else 
			return false;
	}
	
	public void atacar(UnidadTerran unidad, Posicion posicionDestino){
		
		if ( this.hayUnidad(posicionDestino) ){			
			UnidadTerran unidadAux = (UnidadTerran)mapa.get(posicionDestino).contenido();
			unidadAux.disminuirVida(unidad.danioTierra());
		}
	}

	public void colocarTerreno(Posicion posicion) {
		Celda celda= new CeldaTerreno();
		mapa.put(posicion, celda);		
	}

	public void colocarObjeto(Object unObjeto, Posicion posicionDestino) {
		if (this.hayTerreno(posicionDestino)){
			Celda celda = new Celda();
			celda.contenido(unObjeto);
			mapa.put(posicionDestino, celda);
		}
	}

	public void colocarEdificioMineral(RecolectorMineral recMineral, Posicion posicionDestino) {
		if (this.hayMineral(posicionDestino)){
			Celda celda = new Celda();
			celda.contenido(recMineral);
			mapa.put(posicionDestino,celda);
		}
		
	}

	private boolean hayMineral(Posicion posicionDestino) {
		if (mapa.get(posicionDestino).contenido() instanceof Mineral) return true;
		else return false;
	}

	public void colocarEdificioVespeno(RecolectorGasVespeno recGas, Posicion posicionDestino) {
		if (this.hayVaporVespeno(posicionDestino)){
			Celda celda = new Celda();
			celda.contenido(recGas);
			mapa.put(posicionDestino,celda);
		}			
	}

	private boolean hayVaporVespeno(Posicion posicionDestino) {
		if (mapa.get(posicionDestino).contenido() instanceof VaporVespeno) return true;
		else return false;
	}
}
