package view;

import fiuba.algo3.tp2.JuegoCraft;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JuegoCraft modelo = new JuegoCraft();
		VistaMenuPrincipal vista1 = new VistaMenuPrincipal(modelo);
		vista1.setBounds(300, 100, 651, 606);
		vista1.setVisible(true);
		
	}
}