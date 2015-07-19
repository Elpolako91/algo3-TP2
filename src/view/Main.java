package view;

import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Usuario;


public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JuegoCraft modelo = new JuegoCraft();
		Usuario user = new Usuario(modelo);
		VistaMenuPrincipal vista1 = new VistaMenuPrincipal(modelo, user);
		vista1.setBounds(300, 100, 651, 606);
		vista1.setVisible(true);
		
	}
}