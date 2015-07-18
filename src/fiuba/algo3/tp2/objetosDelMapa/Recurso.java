package fiuba.algo3.tp2.objetosDelMapa;


public abstract class Recurso extends ObjetoDelMapa implements Suelo{
	
	private int cantidad;
	
	protected Recurso(int cantidadInicial) {
		
		cantidad = cantidadInicial;
	}

	public int cantidad(){
		return cantidad;
	}

	public void extraer(int cantidadExtraida) {		
		cantidad = cantidad - cantidadExtraida;		
	}
}
