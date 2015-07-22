package fiuba.algo3.tp2.objetosDelMapa;

import javax.swing.ImageIcon;

public class Terreno extends ObjetoDelMapa implements Suelo{

	public Terreno() {
		super(new ImageIcon(Terreno.class.getResource("/imagenes/pasto.png")));
	}

}
