package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Unidad;

public class ControladorAtaque {
	
	private JuegoCraft modelo;

	public ControladorAtaque(JuegoCraft modelo){
		
		this.modelo = modelo;
	}

	private class EscuchaBotonAtaqueAire implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			Object objeto = modelo.turno().objetoSeleccionado();
						
			if ( objeto instanceof Unidad ){
				
				modelo.turno().accionAtacarAire(true);
			}
			
		}
	}
	
		public ActionListener getBotonAtaqueAire() {
			return new EscuchaBotonAtaqueAire();
		}
		
	private class EscuchaBotonAtaqueTierra implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				Object objeto = modelo.turno().objetoSeleccionado();
								
				if ( objeto instanceof Unidad ){
					 
					modelo.turno().accionAtacarTierra(true);
				}
			}
		}
		
			public ActionListener getBotonAtaqueTierra() {
				return new EscuchaBotonAtaqueTierra();
			}
			
	private class EscuchaBotonMoverTerrestre implements ActionListener{
				
				public void actionPerformed(ActionEvent e) {
					
					Object objeto = modelo.turno().objetoSeleccionado();
									
					if ( objeto instanceof Unidad ){
						 
						modelo.turno().accionMoverTerrestre(true);
					}
				}
			}
			
		public ActionListener getBotonMoverTerrestre() {
			return new EscuchaBotonMoverTerrestre();
		}
		
	private class EscuchaBotonMoverAire implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				
				Object objeto = modelo.turno().objetoSeleccionado();
								
				if ( objeto instanceof Unidad ){
					 
					modelo.turno().accionMoverAire(true);
				}
			}
		}
		
		public ActionListener getBotonMoverAire() {
			return new EscuchaBotonMoverAire();
	}
	
}
