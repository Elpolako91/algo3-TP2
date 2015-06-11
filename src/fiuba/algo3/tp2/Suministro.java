package fiuba.algo3.tp2;

public class Suministro {
	
	private int suministroActual;
	private int suministroMaximo;
	
	public Suministro(){
		suministroActual = 0;
		suministroMaximo = 10;
	}

	public boolean cantidadSuficiente(int costoSuministro) {
		if((suministroMaximo-suministroActual) >= costoSuministro)return true;
		else return false;
	}

	public void descontar(int costoSuministro) {
		suministroActual = suministroActual + costoSuministro;
	} 

}
