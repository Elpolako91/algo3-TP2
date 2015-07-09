package fiuba.algo3.tp2;

public class AccionColocarEnAire extends AccionDelJugador {
	
	public AccionColocarEnAire(Mapa unMapa) {
		super(unMapa);
	}
	
	@Override
	public void realizar(Posicion unaPosicion, Raza objeto) {
		
		UnidadAerea unidad = (UnidadAerea) objeto;
			
		if(!preguntar.estaOcupadoAire(unaPosicion)){
			
			PosicionMapa posAerea = new PosicionMapa(unaPosicion.x(),unaPosicion.y(), 2);
			mapa.colocarObjeto(posAerea, unidad);
			unidad.posicion(unaPosicion);			
		}
	}
}