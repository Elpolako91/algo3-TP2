package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import fiuba.algo3.tp2.EdificioBarraca;
import fiuba.algo3.tp2.EdificioFabrica;
import fiuba.algo3.tp2.EdificioPuertoEstelarTerran;
import fiuba.algo3.tp2.JuegoCraft;

public class ControladorUnidad extends MouseAdapter {

	private JuegoCraft modelo;

	public ControladorUnidad(JuegoCraft modelo) {
		
		this.modelo = modelo;
	}
	
	private class EscuchaBotonMarine implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			if ( modelo.turno().objetoSeleccionado() instanceof EdificioBarraca ){
				
				((EdificioBarraca) modelo.turno().objetoSeleccionado()).construirMarine();
			}
		}
	}
	
		public ActionListener getBotonBarraca() {
			return new EscuchaBotonMarine();
		}
		
	private class EscuchaBotonFabrica implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if( modelo.turno().objetoSeleccionado() instanceof EdificioFabrica ){
				
				((EdificioFabrica) modelo.turno().objetoSeleccionado()).crearGolliat();
			}
		}
		
	}

		public ActionListener getBotonFabrica() {
			return new EscuchaBotonFabrica();
		}
		
	private class EscuchaBotonPuertoEstelarEspectro implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if( modelo.turno().objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
					
					((EdificioPuertoEstelarTerran) modelo.turno().objetoSeleccionado()).construirEspectro();
				}
			}
			
		}

			public ActionListener getBotonPuertoEstelarEspectro() {
				return new EscuchaBotonPuertoEstelarEspectro();
			}
			
	private class EscuchaBotonPuertoEstelarNaveTransporte implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					
					if( modelo.turno().objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
						
						((EdificioPuertoEstelarTerran) modelo.turno().objetoSeleccionado()).construirNaveTransporte();
					}
				}
				
			}

				public ActionListener getBotonPuertoEstelarNaveTransporte() {
					return new EscuchaBotonPuertoEstelarNaveTransporte();
				}
				
	private class EscuchaBotonPuertoEstelarNaveCiencia implements ActionListener{

					public void actionPerformed(ActionEvent e) {
						
						if( modelo.turno().objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
							
							((EdificioPuertoEstelarTerran) modelo.turno().objetoSeleccionado()).construirNaveCiencia();
						}
					}
					
				}

					public ActionListener getBotonPuertoEstelarNaveCiencia() {
						return new EscuchaBotonPuertoEstelarNaveCiencia();
					}
}
