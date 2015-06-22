package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.ControladorMouseVistaMapa;

public class Boton {
	
	private JButton boton;
	private Posicion posicion;

	public Boton(int i, int j) {
		 posicion = new Posicion (i/10+1,j/10+1);
		 boton = new JButton();
		 boton.setBounds(i, j, 10, 10);
		 boton.setBorder(null);
		 boton.setIcon(new ImageIcon("imagenes/pasto.png"));
		 if ((posicion.x() == 4) & (posicion.y() == 4)){
			boton.setIcon(new ImageIcon("imagenes/edificio.jpg")); 
		 }
		 boton.addMouseListener(new ControladorMouseVistaMapa(posicion));
	}

	public JButton boton() {
		
		return boton;
	}

}
