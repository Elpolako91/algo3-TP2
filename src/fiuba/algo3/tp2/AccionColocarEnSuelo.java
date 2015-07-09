package fiuba.algo3.tp2;

public class AccionColocarEnSuelo extends Accion{
	
	public AccionColocarEnSuelo(Mapa unMapa) {
		super(unMapa);
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

}
