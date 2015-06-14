package fiuba.algo3.tp2;

public class AccionColocar{

	private Mapa mapa;
	
	public AccionColocar(Mapa unMapa) {
		mapa = unMapa;
	}
	
	public void colocarTerrenoEn(Posicion posicion) {
		
		if(mapa.esPosicionValida(posicion))
			mapa.colocarObjeto(posicion, new Terreno());
		
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
		
		if(mapa.esPosicionValida(posicion))
				mapa.colocarObjeto(posicion, recurso);
	}

	public boolean colocarUnidad(Posicion posicion, UnidadTerran unidad) {
		
		if(mapa.hayTerreno(posicion)){
			mapa.colocarObjeto(posicion, unidad);
			unidad.posicion(posicion);
			return true;
		}
		else
			return false;
			
	}

	public boolean colocarEdificio(Posicion posicion, EdificioTerran edificio) {
		
		if(mapa.hayTerreno(posicion, edificio.tamanio())){
			mapa.colocarObjeto(posicion, edificio, edificio.tamanio());
			edificio.posicion(posicion);
			return true;
		}
		else
			return false;
		
	}

	public void colocarRecolectorDeMineral(Posicion posicion, EdificioTerran recolectorMineral) {
		if(mapa.hayMineral(posicion)){
			mapa.colocarObjeto(posicion, recolectorMineral);
			recolectorMineral.posicion(posicion);
		}
		
	}

	public void colocarRecolectorDeGasVespeno(Posicion posicion, EdificioTerran recolectorGasVespeno) {
		if(mapa.hayGasVespeno(posicion)){
			mapa.colocarObjeto(posicion, recolectorGasVespeno);
			recolectorGasVespeno.posicion(posicion);
		}
		
	}

}
