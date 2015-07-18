package fiuba.algo3.tp2.juego;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;

public class RecursosDelJugador {
	
	private int mineral;
	private int vespeno;
	
	public RecursosDelJugador(){
		mineral = 0;
		vespeno = 0;
	}
	
	public RecursosDelJugador(int unosMinerales, int unosVespeno){
		mineral = unosMinerales;
		vespeno = unosVespeno;
	}
	
	public int mineral(){
		return mineral;
	}
	
	public int vespeno(){
		return vespeno;
	}

	private boolean hayCantidadSuficiente(RecursosDelJugador recursosNecesarios) {
		
		boolean hayCantidad = true;
		if (mineral< recursosNecesarios.mineral()) hayCantidad = false;
		if (vespeno< recursosNecesarios.vespeno()) hayCantidad = false;
		
		return hayCantidad;
	}

	public void descontar(RecursosDelJugador costo) throws RecursosInsuficientes{
		
		if(this.hayCantidadSuficiente(costo)){
			
			mineral = mineral - costo.mineral();
			vespeno = vespeno - costo.vespeno();		
		}
		else
			throw new RecursosInsuficientes();
	}
	
	public void agregar(RecursosDelJugador recursosAgregados)
	{
		mineral = mineral + recursosAgregados.mineral();
		vespeno = vespeno + recursosAgregados.vespeno();
	}
}