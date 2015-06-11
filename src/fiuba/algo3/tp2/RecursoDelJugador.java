package fiuba.algo3.tp2;

public class RecursoDelJugador {
	
	private int mineral;
	private int vespeno;
	
	public RecursoDelJugador(int unaCantidadDeMineral, int unaCantidadDeVespeno){
		mineral = unaCantidadDeMineral;
		vespeno = unaCantidadDeVespeno;
	}
	
	public int mineral(){
		return mineral;
	}
	
	public int vespeno(){
		return vespeno;
	}

	public boolean cantidadSuficiente(RecursoDelJugador recursosNecesarios) {
		boolean hayCantidad = true;
		if (mineral< recursosNecesarios.mineral()) hayCantidad = false;
		if (vespeno< recursosNecesarios.vespeno()) hayCantidad = false;
		
		return hayCantidad;
	}

	public void descontar(RecursoDelJugador costo) {
		mineral = mineral - costo.mineral();
		vespeno = vespeno - costo.vespeno();
		
	}

}
