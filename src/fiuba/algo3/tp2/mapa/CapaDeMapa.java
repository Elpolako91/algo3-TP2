package fiuba.algo3.tp2.mapa;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;

public class CapaDeMapa {

	private Map<Posicion, Celda> mapa = new HashMap<>();
	private Tamanio tamanio;
	
	public CapaDeMapa(Tamanio unTamanio){
		
		tamanio = unTamanio;
		for (int i = 1; i <= tamanio.enX(); i++)
			for (int j = 1; j <= tamanio.enY(); j++)
				this.inicializarPosicion(new Posicion(i,j));
	}
	
	public Tamanio tamanio(){
		return tamanio;
	}
	
	public void colocarObjeto(Posicion posicionDestino, ObjetoDelMapa unObjeto) throws PosicionInvalida {
		
		if (this.esPosicionValida(posicionDestino) && this.hayVacio(posicionDestino)){
			Celda c = new Celda(unObjeto);
			mapa.put(posicionDestino, c);
		}			
		else
			throw new PosicionInvalida();
	}
		
	public void colocarObjeto(Posicion posicion, ObjetoDelMapa unObjetoConTamanio, Tamanio tamanio) throws PosicionInvalida{
		
		if(this.sonPosicionesValidas(posicion, tamanio) && this.hayVacio(posicion, tamanio))
			for ( int i = 0; i < tamanio.enX(); i++ ) 	
				for ( int j = 0; j < tamanio.enY(); j++)
					this.colocarObjeto(posicion.obtenerNuevaMovidaEn(i, j), unObjetoConTamanio);
		else
			throw new PosicionInvalida();
	}
	
	public ObjetoDelMapa contenido(Posicion posicion) throws PosicionInvalida {
		
		if (this.esPosicionValida(posicion)){
			Celda celda = mapa.get(posicion);
			return celda.contenido();
		}			
		else
			throw new PosicionInvalida();
	}

	public void removerObjeto(Posicion posicion) throws PosicionInvalida {
		
		if(this.esPosicionValida(posicion))
			this.inicializarPosicion(posicion);
		else
			throw new PosicionInvalida();
	}
	
	public void removerObjeto(Posicion posicion, Tamanio tamanio) throws PosicionInvalida{
		
		if(this.sonPosicionesValidas(posicion, tamanio)){
			
			for (int i = 0; i < tamanio.enX(); i++)
				for (int j = 0; j < tamanio.enY(); j++)
					this.removerObjeto(posicion.obtenerNuevaMovidaEn(i, j));
		}
		else
			throw new PosicionInvalida();
	}
	
	public void intercambiarObjetos(Posicion posicion1, Posicion posicion2) throws PosicionInvalida {
		
		if((this.esPosicionValida(posicion1)) && (this.esPosicionValida(posicion2))){
			
			ObjetoDelMapa objeto1 = this.contenido(posicion1);
			ObjetoDelMapa objeto2 = this.contenido(posicion2);
			
			this.removerObjeto(posicion1);
			this.removerObjeto(posicion2);
			
			this.colocarObjeto(posicion1, objeto2);
			this.colocarObjeto(posicion2, objeto1);
		}
		else
			throw new PosicionInvalida();
	}
	
	/********************* PRIVADOS ************************************************/
	
	private void inicializarPosicion(Posicion posicion) {
		Celda celda= new Celda(new Vacio());
		mapa.put(posicion, celda);
	}
	
	private boolean hayVacio(Posicion posicion){
		
		Celda c = mapa.get(posicion);
		if(c.contenido() instanceof Vacio)
			return true;
		else
			return false;
	}
	
	private boolean hayVacio(Posicion posicion, Tamanio unTamanio) {
		
		boolean hayVacio = true;		
		
		for ( int i = 0; i < unTamanio.enX(); i++ ) {			
			for ( int j = 0; j < unTamanio.enY(); j++){			
				
				Posicion posicionActual = posicion.obtenerNuevaMovidaEn(i, j);
				if (!(this.hayVacio(posicionActual))) hayVacio= false;									
			}
		}
		return hayVacio;
	}
	
	private boolean esPosicionValida(Posicion posicion){
		
		if (posicion.estaDentro(tamanio)) 
			return true;
		else 
			return false;
	}
	
	private boolean sonPosicionesValidas(Posicion posicion, Tamanio unTamanio){
		
		boolean posicionesValidas = true;		
		
		for ( int i = 0; i < unTamanio.enX(); i++ ) {			
			for ( int j = 0; j < unTamanio.enY(); j++){			
				
				Posicion posicionActual = posicion.obtenerNuevaMovidaEn(i, j);
				if (!(this.esPosicionValida(posicionActual))) posicionesValidas= false;									
			}
		}
		return posicionesValidas;
	}
}
