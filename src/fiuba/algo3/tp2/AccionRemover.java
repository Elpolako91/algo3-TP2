package fiuba.algo3.tp2;

public class AccionRemover extends Accion{

	public AccionRemover(Mapa unMapa) {
		super(unMapa);
	}

	public void edificio(Posicion pos) {
		
		PosicionMapa posTierra = new PosicionMapa(pos.x(), pos.y(), 1);
		mapa.removerObjeto(posTierra);	
	}

	public void edificio(Posicion pos, Tamanio tamanio) {
		
		for (int i = 0; i < tamanio.enX(); i++ )
			for (int j = 0; j < tamanio.enY(); j++){
				
				Posicion posEdificio = new Posicion(pos.x()+i, pos.y()+j);
				this.edificio(posEdificio);
		}
	}

}
