package fiuba.algo3.tp2;

public class RecursosDelJugador {
	
	private int mineral;
	private int vespeno;
	
	public RecursosDelJugador(int unaCantidadDeMineral, int unaCantidadDeVespeno){
		mineral = unaCantidadDeMineral;
		vespeno = unaCantidadDeVespeno;
	}
	
	public int mineral(){
		return mineral;
	}
	
	public int vespeno(){
		return vespeno;
	}

	public boolean hayCantidadSuficiente(RecursosDelJugador recursosNecesarios) {
		boolean hayCantidad = true;
		if (mineral< recursosNecesarios.mineral()) hayCantidad = false;
		if (vespeno< recursosNecesarios.vespeno()) hayCantidad = false;
		
		return hayCantidad;
	}

	public void descontar(RecursosDelJugador costo) {
		mineral = mineral - costo.mineral();
		vespeno = vespeno - costo.vespeno();
	}

}