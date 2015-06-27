package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public abstract class EdificioDeUnidades extends Edificio{

	protected List<Unidad> unidadesEnConstruccion = new ArrayList<Unidad> ();
	protected RecursosDelJugador recursos;
	protected Suministro suministros;
	
	public void unidadesProgresoConstruccion(){
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)			
			unidadesEnConstruccion.get(i).progresa();
	}

	public boolean hayUnidadesTerminadas() {
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)
			if(unidadesEnConstruccion.get(i).tiempoConstruccion() == 0)
				return true;
		
		return false;
	}

	public Unidad unidadTerminada() {
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)
			if(unidadesEnConstruccion.get(i).tiempoConstruccion() == 0)
				return unidadesEnConstruccion.remove(i);
		
		return null;
	}
}
