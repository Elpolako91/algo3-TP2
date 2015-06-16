package fiuba.algo3.tp2;

public class AccionMover{
	
	private Mapa mapa;
	private AccionPreguntar preguntar;

	public AccionMover(Mapa unMapa) {
		mapa = unMapa;
		preguntar = new AccionPreguntar(unMapa);
	}

	public void moverUnidadTerrestre(Posicion posicionDestino, UnidadTerran unidad) {
		
		Posicion posicionDireccion;
		int distancia;
		boolean movimientoPosible = true;
		
		do{
			posicionDireccion = unidad.posicion().direccion(posicionDestino);
			distancia = unidad.posicion().distancia(posicionDestino);
			
			if ((preguntar.hayTerreno(posicionDireccion)) && (!preguntar.hayUnidadTerrestre(posicionDireccion))){
				
				PosicionMapa posMapaUnidad = new PosicionMapa(unidad.posicion().x(), unidad.posicion().y(),1);
				PosicionMapa posMapaDireccion = new PosicionMapa(posicionDireccion.x(), posicionDireccion.y(),1);
				
				mapa.intercambiarObjetos(posMapaUnidad, posMapaDireccion);
				unidad.posicion(posicionDireccion);
			}
			else
				movimientoPosible = false;
			
		}while( (distancia != 0) && movimientoPosible);
	}
	
	public void moverUnidadAerea(Posicion posicionDestino, UnidadTerran unidad) {
		
		Posicion posicionDireccion;
		int distancia;
		boolean movimientoPosible = true;
		
		do{
			posicionDireccion = unidad.posicion().direccion(posicionDestino);
			distancia = unidad.posicion().distancia(posicionDestino);
			
			if (!preguntar.estaOcupadoAire(posicionDireccion)){
				
				PosicionMapa posMapaUnidad = new PosicionMapa(unidad.posicion().x(), unidad.posicion().y(), 2);
				PosicionMapa posMapaDireccion = new PosicionMapa(posicionDireccion.x(), posicionDireccion.y(), 2);
				
				mapa.intercambiarObjetos(posMapaUnidad, posMapaDireccion);
				unidad.posicion(posicionDireccion);
			}
			else
				movimientoPosible = false;
			
		}while( (distancia != 0) && movimientoPosible);
	}
}