package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;

public class AccionMoverUnidad extends AccionDelJugador{
	
	public AccionMoverUnidad(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicionDestino, ObjetoDelMapa objeto) throws PosicionInvalida, UnidadMovimientoTerminado {
		
		if (objeto instanceof UnidadTerrestre)
			this.moverUnidadTerrestre(posicionDestino, (UnidadTerrestre) objeto);
		else
		if (objeto instanceof UnidadAerea)
			this.moverUnidadAerea(posicionDestino, (UnidadAerea) objeto);		
	}
	
	private void moverUnidadTerrestre(Posicion posicionDestino, UnidadTerrestre unidad) throws PosicionInvalida, UnidadMovimientoTerminado{
		
		Posicion posicionDireccion = unidad.posicion().direccion(posicionDestino);		
		int distancia = unidad.posicion().distancia(posicionDireccion);		
		
		while ((!unidad.posicion().equals(posicionDestino)) && (!preguntar.estaOcupadoTierra(posicionDireccion))){
			
			if(!preguntar.hayTerreno(posicionDireccion))
				throw new PosicionInvalida();
			
			if(!unidad.movimientoPosible(distancia))
				throw new UnidadMovimientoTerminado();
			
			mapa.intercambiarObjetos(unidad.posicion(), posicionDireccion, mapa.tierra);
			unidad.posicion(posicionDireccion);
			unidad.pasoDado(distancia);
				
			posicionDireccion = unidad.posicion().direccion(posicionDestino);		
			distancia = unidad.posicion().distancia(posicionDireccion);
		}		
	}
	
	private void moverUnidadAerea(Posicion posicionDestino, UnidadAerea unidad) throws PosicionInvalida, UnidadMovimientoTerminado {
		
		Posicion posicionDireccion = unidad.posicion().direccion(posicionDestino);		
		int distancia = unidad.posicion().distancia(posicionDireccion);	
				
		while ((!unidad.posicion().equals(posicionDestino)) && (!preguntar.estaOcupadoAire(posicionDireccion))){
			
			if(!unidad.movimientoPosible(distancia)) 
				throw new UnidadMovimientoTerminado();
						
			mapa.intercambiarObjetos(unidad.posicion(), posicionDireccion, mapa.aire);
			unidad.posicion(posicionDireccion);
			unidad.pasoDado(distancia);
				
			posicionDireccion = unidad.posicion().direccion(posicionDestino);		
			distancia = unidad.posicion().distancia(posicionDireccion);
		}		
	}
}