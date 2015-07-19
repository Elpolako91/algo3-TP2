package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.juego.Usuario;
import view.VistaConstruccionProtos;
import view.VistaConstruccionTerran;

public class ControladorEdificioCentral extends MouseAdapter {

		private VistaConstruccionTerran vista;
		private VistaConstruccionProtos vista3;
		private Usuario user;


		public ControladorEdificioCentral(VistaConstruccionTerran vista, VistaConstruccionProtos vista3, Usuario user){
			
			this.vista = vista;
			this.vista3 = vista3;
			this.user = user;
			
		}
		
		public void mousePressed(MouseEvent e){
			
			if(user.jugadorActual().raza() == "terran"){
				
				vista.setVisible(true);				
			}else{
				
				vista3.setVisible(true);
			}
			

		}
}
