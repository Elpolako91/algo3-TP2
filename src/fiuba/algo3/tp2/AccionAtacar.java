package fiuba.algo3.tp2;

public class AccionAtacar {

	private Mapa mapa;
	
	public AccionAtacar(Mapa unMapa) {
		mapa = unMapa;
	}

	public void atacar(Posicion posicion, UnidadMarine unidad) {
				
		if ((unidad.posicion().distancia(posicion) <= unidad.rango()) && ((mapa.hayUnidad(posicion)) || (mapa.hayEdificio(posicion)) )){
			
			Terran objetoConstruible = (Terran) mapa.contenido(posicion);
			objetoConstruible.disminuirVida(unidad.danioTierra());
			
			if (objetoConstruible.estaDestruido()){
				mapa.removerObjeto(posicion);
				objetoConstruible.posicion(null);				
			}
		}
	}
}
