package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;

public class Suministro {
	
	private int suministroActual;
	private int suministroMaximo;
	
	public Suministro(){
		suministroActual = 0;
		suministroMaximo = 0;
	}
	
	public int suministroGastados(){
		return suministroActual;
	}
	
	public int suministroTotal(){
		return suministroMaximo;
	}

	private boolean hayCantidadSuficiente(int costoSuministro) {
		
		if((suministroMaximo-suministroActual) >= costoSuministro)
			return true;
		else 
			return false;
	}

	public void gastar(int costoSuministro) throws RecursosInsuficientes{
		
		if (this.hayCantidadSuficiente(costoSuministro))
			suministroActual = suministroActual + costoSuministro;
		else
			throw new RecursosInsuficientes();
	}

	public void reponer(int costoSuministro) {
		suministroActual = suministroActual - costoSuministro;
	}

	public void agregar(int i) {
		suministroMaximo = suministroMaximo + i ;		
	}

	public void quitar(int i) {
		suministroMaximo = suministroMaximo - i;
	}
}
