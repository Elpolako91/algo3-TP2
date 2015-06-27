package fiuba.algo3.tp2;


public class AccionAtacar {

	private Mapa mapa;
	private AccionPreguntar preguntar;
	
	public AccionAtacar(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(mapa);
	}

	public void atacarTierra(Posicion pos, Unidad unidadAtacante) {
				
		if ((unidadAtacante.posicion().distancia(pos) <= unidadAtacante.rango()) && ((preguntar.hayUnidadTerrestre(pos)) || (preguntar.hayEdificio(pos)) )){
			
			PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 1);
			Raza objetoTerrestre = (Raza) mapa.contenido(posMapa);
			objetoTerrestre.disminuirVida(unidadAtacante.danioTierra());
			
			if (objetoTerrestre.estaDestruido()){
				mapa.removerObjeto(posMapa);
				objetoTerrestre.posicion(null);				
			}
		}
	}

	public void atacarAire(Posicion pos, Unidad unidadAtacante) {
		
		if ((unidadAtacante.posicion().distancia(pos) <= unidadAtacante.rango()) && (preguntar.estaOcupadoAire(pos))){
			
			PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 2);
			UnidadAerea objetoAereo = (UnidadAerea) mapa.contenido(posMapa);
			objetoAereo.disminuirVida(unidadAtacante.danioAire());
			
			if (objetoAereo.estaDestruido()){
				mapa.removerObjeto(posMapa);
				objetoAereo.posicion(null);				
			}
		}
		
	}
}
