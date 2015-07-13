package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.JuegoCraft;

import view.VistaConstruccionProtos;
import view.VistaConstruccionTerran;
import view.VistaCreacionUnidadProtos;
import view.VistaCreacionUnidadTerran;
import view.VistaMenuUnidad;

public class ControladorEdificioCentral extends MouseAdapter {

		private VistaConstruccionTerran vista;
		private VistaCreacionUnidadTerran vista1;
		private VistaMenuUnidad vista2;
		private VistaConstruccionProtos vista3;
		private JuegoCraft modelo;
		private VistaCreacionUnidadProtos vista4;

		public ControladorEdificioCentral(VistaConstruccionTerran vista, VistaCreacionUnidadTerran vista1, VistaMenuUnidad vista2, VistaConstruccionProtos vista3, VistaCreacionUnidadProtos vista4,JuegoCraft modelo){
			
			this.vista = vista;
			this.vista1 = vista1;
			this.vista2 = vista2;
			this.vista3 = vista3;
			this.vista4 = vista4;
			this.modelo = modelo;
			
		}
		
		public void mousePressed(MouseEvent e){
			
			if(modelo.turno().raza() == "terran"){
				
				vista.setVisible(true);
				vista1.setVisible(true);
				
			}else{
				
				vista3.setVisible(true);
				vista4.setVisible(true);
			}
			
				vista2.setVisible(true);
		}
}
