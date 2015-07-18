package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.mapa.Mapa;

public abstract class Accion {
	
	protected Mapa mapa;
	protected AccionPreguntar preguntar;
	
	public Accion(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(mapa);
	}
}
