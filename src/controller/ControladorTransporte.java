package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VistaMenuTransporte;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

public class ControladorTransporte {
	
	private Usuario user;

	public ControladorTransporte(Usuario user){
		
		this.user = user;
	}
	

	private class EscuchaBotonCargar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			Object objeto = user.objetoSeleccionado();
						
			if ( objeto instanceof UnidadTransporte ){
				
				user.accionCargar(true);
				user.unidadDeTransporte((UnidadTransporte) objeto);
			}
			
		}
	}
	
		public ActionListener getBotonCargar() {
			return new EscuchaBotonCargar();
		}
		
		
	private class EscuchaBotonDescargar implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				Object objeto = user.objetoSeleccionado();
								
				if ( objeto instanceof UnidadTransporte ){
					 
					user.accionDescargar(true);
					user.unidadDeTransporte((UnidadTransporte) objeto);
				}
			}
		}
		
			public ActionListener getBotonDescargar() {
				return new EscuchaBotonDescargar();
			}
			
			
	private class EscuchaBotonVistaMenuTransporte implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			VistaMenuTransporte vista = new VistaMenuTransporte(user);
			vista.setVisible(true);
		}
	}
			public ActionListener getVistaMenuTransporte() {
				
				return new EscuchaBotonVistaMenuTransporte();
			}
			
			
	private class EscuchaBotonMover implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
					
					Object objeto = user.objetoSeleccionado();
									
					if ( objeto instanceof Unidad ){
						 
						user.accionMover(true);
					}
				}
			}
			
		public ActionListener getBotonMover() {
			return new EscuchaBotonMover();
		}
}
