package fiuba.algo3.tp2;

public class AccionAtacar {

	private Mapa mapa;
	private AccionPreguntar preguntar;
	
	public AccionAtacar(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(mapa);
	}

	public void atacarTierra(Posicion pos, UnidadMarine unidad) {
				
		if ((unidad.posicion().distancia(pos) <= unidad.rango()) && ((preguntar.hayUnidadTerrestre(pos)) || (preguntar.hayEdificio(pos)) )){
			
			PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 1);
			Raza objetoConstruible = (Raza) mapa.contenido(posMapa);
			objetoConstruible.disminuirVida(unidad.danioTierra());
			
			if (objetoConstruible.estaDestruido()){
				mapa.removerObjeto(posMapa);
				objetoConstruible.posicion(null);				
			}
		}
	}
}
