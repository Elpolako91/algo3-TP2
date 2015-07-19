package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.mapa.Vacio;
import fiuba.algo3.tp2.objetosDelMapa.Aereo;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;
import fiuba.algo3.tp2.objetosDelMapa.Terreno;
import fiuba.algo3.tp2.objetosDelMapa.Terrestre;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadAerea;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTerrestre;


public class AccionPreguntar {
	
	private Mapa mapa;
	
	public AccionPreguntar(Mapa unMapa) {
		mapa = unMapa;
	}
	
	public boolean hayEnTierra(Posicion pos, Terrestre unObjetoTerrestre) throws PosicionInvalida {

		if(mapa.contenido(pos, mapa.tierra).equals(unObjetoTerrestre))
			return true;
		else
			return false;
	}
	
	public boolean hayEnAire(Posicion pos, Aereo unObjetoAereo) throws PosicionInvalida {
		
		if(mapa.contenido(pos, mapa.aire).equals(unObjetoAereo))
			return true;
		else
			return false;
	}
	
	public boolean hayTerreno(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.suelo) instanceof Terreno)
			return true;
		else 
			return false;
	}
	
	public boolean hayTerreno(Posicion posicion,Tamanio tamanio) throws PosicionInvalida {
		
		boolean hayTerreno = true;
		
		for ( int i = 0; i < tamanio.enX(); i++ ) {			
			for ( int j = 0; j < tamanio.enY(); j++){
				
				if (!(this.hayTerreno(posicion.obtenerNuevaMovidaEn(i, j))))
					hayTerreno = false;
			}
		}
		return hayTerreno;
	}
		
	public boolean hayGasVespeno(Posicion pos) throws PosicionInvalida {
		
		if (mapa.contenido(pos, mapa.suelo) instanceof RecursoGasVespeno)
			return true;
		else
			return false;
	}

	public boolean hayMineral(Posicion pos) throws PosicionInvalida {
		
		if (mapa.contenido(pos, mapa.suelo) instanceof RecursoMineral) 
			return true;
		else 
			return false;
	}
				
	public boolean estaOcupadoTierra(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.tierra) instanceof Vacio)
			return false;
		else 
			return true;
	}
	
	public boolean estaOcupadoAire(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.aire) instanceof Vacio)
			return false;
		else 
			return true;
	}
	
	public boolean hayUnidadTerrestre(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.tierra) instanceof UnidadTerrestre)
			return true;
		else 
			return false;
	}

	/**************************** En Otra Clase no testeados *******************/
	
	public Posicion encontrarPosicionParaUnidadTerrestre(Posicion posicion) {
		
		Posicion posicionUnidad = posicion;
		
		try {
			while(this.estaOcupadoTierra(posicionUnidad)){
				posicionUnidad = posicion.posicionEnEspiral(posicionUnidad);
			}
		} catch (PosicionInvalida e) {
			posicionUnidad = this.encontrarPosicionDentroDelMapa(posicion, posicionUnidad);
			posicionUnidad = this.encontrarPosicionParaUnidadTerrestre(posicionUnidad);
		}
		return posicionUnidad;
	}	

	public Posicion encontrarPosicionParaUnidadAerea(Posicion posicion) {
		
		Posicion posicionUnidad = posicion;
		try {
			while(this.estaOcupadoAire(posicionUnidad)){
				posicionUnidad = posicion.posicionEnEspiral(posicionUnidad);
			}
		} catch (PosicionInvalida e) {
			this.encontrarPosicionDentroDelMapa(posicion, posicionUnidad);
		}
		return posicionUnidad;
	}
	
	private Posicion encontrarPosicionDentroDelMapa(Posicion posicionInicial, Posicion posicionActual) {
		
		while(! posicionActual.estaDentro(mapa.tamanio())) 			
			posicionActual = posicionInicial.posicionEnEspiral(posicionActual);	
		
		return posicionActual;
	}

	public boolean hayEdificio(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.tierra) instanceof Edificio)
			return true;
		else 
			return false;
	}

	public boolean hayUnidadAire(Posicion posicion) throws PosicionInvalida {
		
		if (mapa.contenido(posicion, mapa.tierra) instanceof UnidadAerea)
			return true;
		else 
			return false;
	}
}
