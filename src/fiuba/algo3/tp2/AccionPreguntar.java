package fiuba.algo3.tp2;

public class AccionPreguntar {
	
	private Mapa mapa;

	public AccionPreguntar(Mapa unMapa) {
		mapa = unMapa;
	}

	public boolean hayEnSuelo(Posicion pos, Suelo unSuelo){
		
		PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 0);
		if(mapa.contenido(posMapa).equals(unSuelo))
			return true;
		else
			return false;
	}
	
	public boolean hayEnTierra(Posicion pos, Terrestre unObjetoTerrestre) {

		PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 1);
		if(mapa.contenido(posMapa).equals(unObjetoTerrestre))
			return true;
		else
			return false;
	}
	
	public boolean hayEnAire(Posicion pos, Aereo unObjetoAereo) {
		
		PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 2);
		if(mapa.contenido(posMapa).equals(unObjetoAereo))
			return true;
		else
			return false;
	}
	
	public boolean hayTerreno(Posicion posicion) {
		
		PosicionMapa posMapa = new PosicionMapa(posicion.x(),posicion.y(),0);
		if (mapa.contenido(posMapa) instanceof Terreno)
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

	public boolean hayUnidadTerrestre(Posicion pos) {
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),1);
		if (mapa.contenido(posMapa) instanceof UnidadTerran)
			return true;
		else 
			return false;
	}
	
	public boolean hayGasVespeno(Posicion pos) {
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),0);
		if (mapa.contenido(posMapa) instanceof RecursoGasVespeno)
			return true;
		else
			return false;
	}

	public boolean hayMineral(Posicion pos) {
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),0);
		if (mapa.contenido(posMapa) instanceof RecursoMineral) 
			return true;
		else 
			return false;
	}
	
	public boolean hayEdificio(Posicion pos) {
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),1);
		if (mapa.contenido(posMapa) instanceof Edificio)
			return true;
		else
			return false;
	}
	
	public boolean estaFueraDelMapa(Posicion posicion){
		
		if (!mapa.esPosicionValida(posicion))
			return true;
		else
			return false;			
	}

	public boolean hayEdificio(Posicion posicion, Tamanio tamanio) {
		
		boolean hayEdificio = false;
		for ( int i = 0; i < tamanio.enX(); i++ ) {			
			for ( int j = 0; j < tamanio.enY(); j++){
				
				Posicion posicionActual = new Posicion(posicion.x()+i, posicion.y()+j);
				if (this.hayEdificio(posicionActual))
					hayEdificio = true;
			}
		}
		return hayEdificio;
	}

	public boolean hayUnidadTerrestre(Posicion posicion, Tamanio tamanio) {
		
		boolean hayUnidad = false;
		for ( int i = 0; i < tamanio.enX(); i++ ) {			
			for ( int j = 0; j < tamanio.enY(); j++){
				
				Posicion posicionActual = new Posicion(posicion.x()+i, posicion.y()+j);
				if (this.hayUnidadTerrestre(posicionActual))
					hayUnidad = true;
			}
		}
		return hayUnidad;
	}

	public boolean estaOcupadoAire(Posicion posicion) {
		
		PosicionMapa posMapa = new PosicionMapa(posicion.x(),posicion.y(),2);
		if (mapa.contenido(posMapa) instanceof Vacio)
			return false;
		else 
			return true;
	}

	


}
