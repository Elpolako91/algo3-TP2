package fiuba.algo3.tp2;


public class AccionAtacarTierra extends AccionDelJugador{


	public AccionAtacarTierra(Mapa unMapa) {
		super(unMapa);
	}

	public void realizar(Posicion pos, Raza objeto ) {
				
		Unidad unidadAtacante = (Unidad) objeto;
		
		if ((unidadAtacante.ataquePosible()) && (unidadAtacante.posicion().distancia(pos) <= unidadAtacante.rango()) && ((preguntar.hayUnidadTerrestre(pos)) || (preguntar.hayEdificio(pos)) )){
			
			PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 1);
			Raza objetoTerrestre = (Raza) mapa.contenido(posMapa);
			objetoTerrestre.disminuirVida(unidadAtacante.danioTierra());
			
			if (objetoTerrestre.estaDestruido()){
				mapa.removerObjeto(posMapa);
				objetoTerrestre.posicion(null);				
			}
			
			unidadAtacante.turnoTerminado();
		}
	}
}