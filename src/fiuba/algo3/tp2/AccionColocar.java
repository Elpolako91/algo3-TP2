package fiuba.algo3.tp2;


public class AccionColocar{

	private Mapa mapa;
	private AccionPreguntar preguntar;
	
	public AccionColocar(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(unMapa);
	}
		
	public void colocarTerrenoEn(Posicion posicion) {
		
		if(mapa.esPosicionValida(posicion)){
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			mapa.colocarObjeto(posSuelo, new Terreno());
		}
	}

	public void colocarTerrenoEnTodoElMapa() {
		
		Posicion posicionAux;
		
		for (int i = 1; i<= mapa.tamanio().enX(); i++)
			for (int j = 1; j<=mapa.tamanio().enY(); j++){

				posicionAux = new Posicion(i,j);
				this.colocarTerrenoEn(posicionAux);
		}			
	}

	public void colocarRecurso(Posicion posicion, Recurso recurso) {
		
		
		if(mapa.esPosicionValida(posicion)){
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			mapa.colocarObjeto(posSuelo, recurso);
		}				
	}

	public boolean colocarUnidadTerrestre(Posicion posicion, UnidadTerrestre unidad) {
		
		if((preguntar.hayTerreno(posicion)) && ( (!preguntar.hayUnidadTerrestre(posicion)) && (!preguntar.hayEdificio(posicion)))){
			
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, unidad);
			unidad.posicion(posicion);
			return true;
		}
		else
			return false;
	}

	public boolean colocarEdificio(Posicion posicion, Edificio edificio) {
		
		if((preguntar.hayTerreno(posicion, edificio.tamanio())) && (!preguntar.hayUnidadTerrestre(posicion, edificio.tamanio())) && (!preguntar.hayEdificio(posicion, edificio.tamanio()))){
			
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, edificio, edificio.tamanio());
			edificio.posicion(posicion);
			return true;
		}
		else
			return false;
		
	}

	public boolean colocarRecolectorDeMineral(Posicion posicion, EdificioRecolectorDeMineral recolectorMineral) {
		if(preguntar.hayMineral(posicion)){
			
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			
			recolectorMineral.extraeDe((RecursoMineral) mapa.contenido(posSuelo));
			
			mapa.colocarObjeto(posTerrestre, recolectorMineral);
			recolectorMineral.posicion(posicion);
			return true;
		}
		else
			return false;
	}

	public boolean colocarRecolectorDeGasVespeno(Posicion posicion, EdificioRecolectorDeVespeno recolectorGasVespeno) {
		
		if(preguntar.hayGasVespeno(posicion)){
			
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			
			recolectorGasVespeno.extraeDe((RecursoGasVespeno) mapa.contenido(posSuelo));
			
			mapa.colocarObjeto(posTerrestre, recolectorGasVespeno);
			recolectorGasVespeno.posicion(posicion);
			
			return true;
		}
		else
			return false;
		
	}

	public boolean colocarUnidadAerea(Posicion posicion, UnidadAerea unidad) {
		
		if(!preguntar.estaOcupadoAire(posicion)){
			
			PosicionMapa posAerea = new PosicionMapa(posicion.x(),posicion.y(), 2);
			mapa.colocarObjeto(posAerea, unidad);
			unidad.posicion(posicion);
			return true;			
		}
		else
			return false;
	}

	public void colocarEdificioEdificioCentral(EdificioCentral edificioCentral) {

		if(this.colocarEdificio(new Posicion(1,1), edificioCentral)) return;
		
		if(this.colocarEdificio(new Posicion(mapa.tamanio().enX() - edificioCentral.tamanio().enX() + 1 , mapa.tamanio().enY() - edificioCentral.tamanio().enY()+1), edificioCentral)) return ;
		
	}

}
