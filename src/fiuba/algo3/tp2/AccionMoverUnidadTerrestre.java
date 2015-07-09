package fiuba.algo3.tp2;

public class AccionMoverUnidadTerrestre extends AccionDelJugador{
	
	public AccionMoverUnidadTerrestre(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicionDestino, Raza objeto) {
		
		UnidadTerrestre unidad = (UnidadTerrestre) objeto;
		
		Posicion posicionDireccion;
		int distancia = unidad.posicion().distancia(posicionDestino);
		boolean movimientoPosible = unidad.movimientoPosible();
		
		while ((distancia != 0) && movimientoPosible){
			
			posicionDireccion = unidad.posicion().direccion(posicionDestino);			
			
			if ((preguntar.hayTerreno(posicionDireccion)) && (!preguntar.hayUnidadTerrestre(posicionDireccion))){
				
				PosicionMapa posMapaUnidad = new PosicionMapa(unidad.posicion().x(), unidad.posicion().y(),1);
				PosicionMapa posMapaDireccion = new PosicionMapa(posicionDireccion.x(), posicionDireccion.y(),1);
				
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