package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public class ControladorAtaque {
	
	private Usuario user;

	public ControladorAtaque(Usuario user){
		
		this.user = user;
	}

	private class EscuchaBotonAtaqueAire implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			Object objeto = user.objetoSeleccionado();
						
			if ( objeto instanceof Unidad ){
				
				user.accionAtacarAire(true);
			}
			
		}
	}
	
		public ActionListener getBotonAtaqueAire() {
			return new EscuchaBotonAtaqueAire();
		}
		
	private class EscuchaBotonAtaqueTierra implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				Object objeto = user.objetoSeleccionado();
								
				if ( objeto instanceof Unidad ){
					 
					user.accionAtacarTierra(true);
				}
			}
		}
		
			public ActionListener getBotonAtaqueTierra() {
				return new EscuchaBotonAtaqueTierra();
			}
			
	private class EscuchaBotonMoverTerrestre implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
					
					Object objeto = user.objetoSeleccionado();
									
					if ( objeto instanceof Unidad ){
						 
						user.accionMover(true);
					}
				}
			}
			
		public ActionListener getBotonMoverTerrestre() {
			return new EscuchaBotonMoverTerrestre();
		}
		
	private class EscuchaBotonMoverAire implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				Object objeto = user.objetoSeleccionado();
								
				if ( objeto instanceof Unidad ){
					 
					user.accionMover(true);
				}
			}
		}
		
		public ActionListener getBotonMoverAire() {
			return new EscuchaBotonMoverAire();
	}
	
}
