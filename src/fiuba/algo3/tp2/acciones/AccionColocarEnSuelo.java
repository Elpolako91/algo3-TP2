package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.Recurso;
import fiuba.algo3.tp2.objetosDelMapa.Terreno;

public class AccionColocarEnSuelo extends AccionDelMapa{
		
	public AccionColocarEnSuelo(Mapa unMapa) {
		super(unMapa);
	}

	public void colocarTerrenoEn(Posicion posicion) throws PosicionInvalida {
				
		mapa.removerObjeto(posicion, mapa.suelo);
		mapa.colocarObjeto(posicion, mapa.suelo, new Terreno());		
	}

	public void colocarTerrenoEnTodoElMapa() {
		
		for (int i = 1; i <= mapa.tamanio().enX(); i++)
			for (int j = 1; j <= mapa.tamanio().enY(); j++){

				try {
					this.colocarTerrenoEn(new Posicion(i,j));
				} catch (PosicionInvalida e) {}
		}			
	}

	public void colocarRecurso(Posicion posicion, Recurso recurso) throws PosicionInvalida {
		
		mapa.removerObjeto(posicion, mapa.suelo);
		mapa.colocarObjeto(posicion, mapa.suelo, recurso);
	}

}
