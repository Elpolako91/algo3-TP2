package fiuba.algo3.tp2.objetosDelMapa;

import javax.swing.ImageIcon;

public class RecursoGasVespeno extends Recurso {
	
	public RecursoGasVespeno(int cantidadInicial, ImageIcon unaImagen) {
		
		super(cantidadInicial, unaImagen);
		unaImagen = new ImageIcon(RecursoGasVespeno.class.getResource("/imagenes/Gas_vespeno.png"));
	}
}
