package fiuba.algo3.tp2.objetosDelMapa;

import javax.swing.ImageIcon;

public abstract class ObjetoDelMapa {
	
	private ImageIcon imagen;
	
	protected ObjetoDelMapa(ImageIcon unaImagen){
		imagen = unaImagen;
	}
		
	public ImageIcon imagen(){
		
		return imagen;
	}
}
