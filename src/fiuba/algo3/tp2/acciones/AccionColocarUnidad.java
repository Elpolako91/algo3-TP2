package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadAerea;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTerrestre;

public class AccionColocarUnidad extends AccionDelJugador {

	public AccionColocarUnidad(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicion, ObjetoDelMapa unidad) throws PosicionInvalida {
		
		if (unidad instanceof UnidadTerrestre)
			this.colocarUnidadTerrestre(posicion, (UnidadTerrestre) unidad);
		else
			if (unidad instanceof UnidadAerea)	
			this.colocarUnidadAerea(posicion, (UnidadAerea) unidad);
	}

	private void colocarUnidadAerea(Posicion posicion, UnidadAerea unidad) throws PosicionInvalida {
		
		mapa.colocarObjeto(posicion, mapa.aire, unidad);
		unidad.posicion(posicion);		
	}

	private void colocarUnidadTerrestre(Posicion posicion, UnidadTerrestre unidad) throws PosicionInvalida {
		
		if(preguntar.hayTerreno(posicion)){
			mapa.colocarObjeto(posicion, mapa.tierra, unidad);
			unidad.posicion(posicion);
		}
		else
			throw new PosicionInvalida();
	}
}