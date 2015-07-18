package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;

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