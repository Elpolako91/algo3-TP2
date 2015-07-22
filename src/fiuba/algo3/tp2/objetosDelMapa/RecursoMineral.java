package fiuba.algo3.tp2.objetosDelMapa;

import javax.swing.ImageIcon;

public class RecursoMineral extends Recurso {

	public RecursoMineral(int cantidadInicial, ImageIcon unaImagen) {
		
		super(cantidadInicial, unaImagen);
		unaImagen = new ImageIcon(RecursoMineral.class.getResource("/imagenes/mineral.jpg"));
	}	
}
