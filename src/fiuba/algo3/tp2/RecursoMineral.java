package fiuba.algo3.tp2;

public class RecursoMineral extends Recurso {

	private int cantidad;

	public RecursoMineral(int cantidadInicial) {
		
		cantidad = cantidadInicial;
	}
	
	public int cantidad(){
		return cantidad;
	}

	public void extraer(int cantidadExtraida) {
		
		cantidad = cantidad - cantidadExtraida;
		
	}
	
}
