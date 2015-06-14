package fiuba.algo3.tp2;

public class AccionMover{
	
	private Mapa mapa;

	public AccionMover(Mapa unMapa) {
		mapa = unMapa;
	}

	public void moverUnidad(Posicion posicionDestino, UnidadTerran unidad) {
		
		Posicion posicionDireccion;
		int distancia;
		boolean movimientoPosible = true;
		
		do{
			posicionDireccion = unidad.posicion().direccion(posicionDestino);
			distancia = unidad.posicion().distancia(posicionDestino);
			
			if (mapa.hayTerreno(posicionDireccion)){
				
				mapa.intercambiarObjetos(unidad.posicion(), posicionDireccion);
				unidad.posicion(posicionDireccion);
			}
			else
				movimientoPosible = false;
			
		}while( (distancia != 0) && movimientoPosible);
	}
}