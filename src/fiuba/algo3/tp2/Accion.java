package fiuba.algo3.tp2;

public abstract class Accion {
	
	protected Mapa mapa;
	protected AccionPreguntar preguntar;
	
	public Accion(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(mapa);
	}
}
