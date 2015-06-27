package fiuba.algo3.tp2;

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

	public boolean hayCantidadSuficiente(int costoSuministro) {
		if((suministroMaximo-suministroActual) >= costoSuministro)return true;
		else return false;
	}

	public void gastar(int costoSuministro) {
		if (this.hayCantidadSuficiente(costoSuministro))
			suministroActual = suministroActual + costoSuministro;
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
