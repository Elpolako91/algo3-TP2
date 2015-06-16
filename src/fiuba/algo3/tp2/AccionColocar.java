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

	public boolean colocarUnidadTerrestre(Posicion posicion, UnidadTerran unidad) {
		
		if(preguntar.hayTerreno(posicion)){
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, unidad);
			unidad.posicion(posicion);
			return true;
		}
		else
			return false;
	}

	public boolean colocarEdificio(Posicion posicion, EdificioTerran edificio) {
		
		if(preguntar.hayTerreno(posicion, edificio.tamanio())){
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, edificio, edificio.tamanio());
			edificio.posicion(posicion);
			return true;
		}
		else
			return false;
		
	}

	public void colocarRecolectorDeMineral(Posicion posicion, EdificioTerran recolectorMineral) {
		if(preguntar.hayMineral(posicion)){
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, recolectorMineral);
			recolectorMineral.posicion(posicion);
		}
		
	}

	public void colocarRecolectorDeGasVespeno(Posicion posicion, EdificioTerran recolectorGasVespeno) {
		if(preguntar.hayGasVespeno(posicion)){
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, recolectorGasVespeno);
			recolectorGasVespeno.posicion(posicion);
		}
		
	}

}
