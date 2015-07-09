package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class UnidadTransporte extends UnidadAerea{
	
	protected int capacidad;
	private List<UnidadTerrestre> unidades = new ArrayList<UnidadTerrestre> ();

	public boolean tieneLugar(int ocupacionTransporte) {
		
		if(capacidad >= ocupacionTransporte)
			return true;
		else
			return false;
	}

	public void cargar(UnidadTerrestre unidadACargar) {

		unidades.add(unidadACargar);
		capacidad = capacidad - unidadACargar.ocupacionTransporte();
	}

	public UnidadTerrestre descargarUnidad() {
		
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
