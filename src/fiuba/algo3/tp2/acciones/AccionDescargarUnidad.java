package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTerrestre;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

public class AccionDescargarUnidad extends AccionDelJugador{

	private AccionColocarUnidad colocarUnidad;
	
	public AccionDescargarUnidad(Mapa unMapa) {
		super(unMapa);
		colocarUnidad = new AccionColocarUnidad(mapa);
	}

	@Override
	public void realizar(Posicion unaPosicion, ObjetoDelMapa objeto) throws PosicionInvalida {
		
		UnidadTransporte transporte = (UnidadTransporte) objeto;
		UnidadTerrestre unidad = transporte.descargarUnidad();
				
		colocarUnidad.realizar(transporte.posicion(), unidad);						
		transporte.cargar(unidad);		
	}
}