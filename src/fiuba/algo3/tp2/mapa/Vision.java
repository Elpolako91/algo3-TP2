package fiuba.algo3.tp2.mapa;

import java.util.HashMap;
import java.util.Map;

public class Vision {

	private Map<Posicion, Celda> mapa = new HashMap<>();
	private Tamanio tamanio;
	
	public Vision(Tamanio unTamanio){
		
		tamanio = unTamanio;
		for (int i = 1; i <= tamanio.enX(); i++)
			for (int j = 1; j <= tamanio.enY(); j++)
				this.inicializarPosicion(new Posicion(i,j));
	}
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	public void descubrir(Posicion posicion, int rango){
		
		Posicion posicionActual;
		
		for(int i = -rango; i <= rango; i++)
			for(int j = -rango; j <= rango; j++){
				
				posicionActual = posicion.obtenerNuevaMovidaEn(i, j);
				if((posicionActual.estaDentro(tamanio)) && (posicionActual.distancia(posicion) <= rango))
					this.revelar(posicionActual);
		}		
	}
	
	public boolean hayVisibilidad(Posicion posicion){
		
		Celda c = mapa.get(posicion);
		if(c.contenido() instanceof Vacio)
			return true;
		else
			return false;
	}
	
	private void inicializarPosicion(Posicion posicion) {
		Celda celda= new Celda(new SinVisibilidad());
		mapa.put(posicion, celda);
	}
	
	private void revelar(Posicion posicion) {
		Celda celda= new Celda(new Vacio());
		mapa.put(posicion, celda);
	}
}