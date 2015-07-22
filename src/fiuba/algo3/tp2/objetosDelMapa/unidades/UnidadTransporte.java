package fiuba.algo3.tp2.objetosDelMapa.unidades;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadTransporte extends UnidadAerea{
	
	private int capacidad = 8;
	private List<UnidadTerrestre> unidades = new ArrayList<UnidadTerrestre> ();
	
	protected UnidadTransporte(String unNombre, int vida, int escudo, int unTiempoConstruccion, int unaVision,
			RecursosDelJugador costoRecurso, int unCostoSuministro,	int unDanioTierra,
			int unDanioAire, int unRangoTierra,	int unRangoAire, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, unaVision, costoRecurso, unCostoSuministro,
				unDanioTierra, unDanioAire, unRangoTierra, unRangoAire, unaImagen);
	}

	public boolean tieneLugar(int ocupacionTransporte) {
		
		if(capacidad >= ocupacionTransporte)
			return true;
		else
			return false;
	}

	public void cargar(UnidadTerrestre unidadACargar) {

		// agregar excepcion
		
		unidades.add(unidadACargar);
		capacidad = capacidad - unidadACargar.ocupacionTransporte();
	}

	public UnidadTerrestre descargarUnidad() {
		
		// agregar excepcion
		
		if(unidades.size() == 0)
			return null;
		else
		{
			UnidadTerrestre unidad = unidades.remove(0);
			capacidad = capacidad + unidad.ocupacionTransporte();
			return unidad;
		}
	}
}
