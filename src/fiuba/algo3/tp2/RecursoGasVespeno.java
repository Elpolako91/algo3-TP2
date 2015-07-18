package fiuba.algo3.tp2;

public class RecursoGasVespeno extends Recurso {
	
	private int cantidad;

	public RecursoGasVespeno(int cantidadInicial) {
		
		cantidad = cantidadInicial;
	}
	
	public int cantidad(){
		return cantidad;
	}

	public void extraer(int cantidadExtraida) {
		
		cantidad = cantidad - cantidadExtraida;
		
	}

}
