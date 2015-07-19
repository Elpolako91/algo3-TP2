package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.juego.Usuario;
import view.VistaCreacionUnidadProtos;
import view.VistaCreacionUnidadTerran;

public class ControladorCreadorUnidades extends MouseAdapter {

		private VistaCreacionUnidadTerran vistaCreacionUnidadTerran;
		private Usuario user;
		private VistaCreacionUnidadProtos vistaCreacionUnidadProtos;

		public ControladorCreadorUnidades(Usuario user, VistaCreacionUnidadTerran vistaCreacionUnidadTerran, VistaCreacionUnidadProtos vistaCreacionUnidadProtos){
			
			this.user = user;
			this.vistaCreacionUnidadTerran = vistaCreacionUnidadTerran;
			this.vistaCreacionUnidadProtos = vistaCreacionUnidadProtos;
		}
		
		public void mousePressed(MouseEvent e){
			
			if(user.jugadorActual().raza() == "terran"){
				
				vistaCreacionUnidadTerran.setVisible(true);
				
			}else{
				
				vistaCreacionUnidadProtos.setVisible(true);
			}
			
		}
}
