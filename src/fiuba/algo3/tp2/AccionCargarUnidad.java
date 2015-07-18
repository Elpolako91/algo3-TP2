package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;

public class AccionCargarUnidad extends AccionDelJugador{
	
	public AccionCargarUnidad(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicion, ObjetoDelMapa objeto) throws PosicionInvalida {
		
		UnidadTransporte transporte = (UnidadTransporte) objeto;
		
		if(preguntar.hayUnidadTerrestre(posicion)) {
			
			UnidadTerrestre unidadACargar = (UnidadTerrestre) mapa.contenido(posicion, mapa.tierra);
					
			if(transporte.tieneLugar(unidadACargar.ocupacionTransporte()) && (transporte.posicion().equals(unidadACargar.posicion()))){
				transporte.cargar(unidadACargar);
				mapa.removerObjeto(unidadACargar.posicion(), mapa.tierra);	//realizar accionRemover
			}
		}
		else
			throw new PosicionInvalida();		
	}	
}
