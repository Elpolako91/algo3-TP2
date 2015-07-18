package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTerrestre;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

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
