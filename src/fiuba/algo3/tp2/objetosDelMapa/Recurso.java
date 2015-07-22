package fiuba.algo3.tp2.objetosDelMapa;

import javax.swing.ImageIcon;


public abstract class Recurso extends ObjetoDelMapa implements Suelo{
	
	private int cantidad;
	
	protected Recurso(int cantidadInicial, ImageIcon unaImagen) {
		
		super (unaImagen);
		cantidad = cantidadInicial;
	}

	public int cantidad(){
		return cantidad;
	}

	public void extraer(int cantidadExtraida) {		
		cantidad = cantidad - cantidadExtraida;		
	}
}
