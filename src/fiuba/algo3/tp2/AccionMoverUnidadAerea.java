package fiuba.algo3.tp2;

public class AccionMoverUnidadAerea extends AccionDelJugador{
	
	public AccionMoverUnidadAerea(Mapa unMapa) {
		super(unMapa);
	}
	
	@Override
	public void realizar(Posicion posicionDestino, Raza objeto ) {
				
		UnidadAerea unidad = (UnidadAerea) objeto;
		
		Posicion posicionDireccion;
		int distancia = unidad.posicion().distancia(posicionDestino);
		boolean movimientoPosible = unidad.movimientoPosible();
		
		while ((distancia != 0) && movimientoPosible){
			
			posicionDireccion = unidad.posicion().direccion(posicionDestino);
			
			if (!preguntar.estaOcupadoAire(posicionDireccion)){
				
				PosicionMapa posMapaUnidad = new PosicionMapa(unidad.posicion().x(), unidad.posicion().y(), 2);
				PosicionMapa posMapaDireccion = new PosicionMapa(posicionDireccion.x(), posicionDireccion.y(), 2);
				
				mapa.intercambiarObjetos(posMapaUnidad, posMapaDireccion);
				unidad.posicion(posicionDireccion);
				
				unidad.pasoDado();
				movimientoPosible = unidad.movimientoPosible();
			}
			else
				movimientoPosible = false;

			distancia = unidad.posicion().distancia(posicionDestino);
			
		}
	}
}
