package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.VistaConstruccion;
import view.VistaCreacionUnidad;
import view.VistaMenuUnidad;

public class ControladorEdificioCentral extends MouseAdapter {

		private VistaConstruccion vista;
		private VistaCreacionUnidad vista1;
		private VistaMenuUnidad vista2;

		public ControladorEdificioCentral(VistaConstruccion vista, VistaCreacionUnidad vista1, VistaMenuUnidad vista2){
			
			this.vista = vista;
			this.vista1 = vista1;
			this.vista2 = vista2;
			
		}
		
		public void mousePressed(MouseEvent e){
			
			vista.setVisible(true);
			vista1.setVisible(true);
			vista2.setVisible(true);
		}
}
