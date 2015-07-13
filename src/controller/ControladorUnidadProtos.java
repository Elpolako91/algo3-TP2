package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.EdificioAcceso;
import fiuba.algo3.tp2.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.EdificioPuertoEstelarProtos;
import fiuba.algo3.tp2.JuegoCraft;

public class ControladorUnidadProtos {
	
	private JuegoCraft modelo;

	public ControladorUnidadProtos(JuegoCraft modelo) {
		
		this.modelo = modelo;
	}
	
	private class EscuchaBotonZealot implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			if ( modelo.turno().objetoSeleccionado() instanceof EdificioAcceso ){
				
				((EdificioAcceso) modelo.turno().objetoSeleccionado()).construirZealot();
			}
		}
	}
	
		public ActionListener getBotonAccesoZealot() {
			return new EscuchaBotonZealot();
		}
		
	private class EscuchaBotonDragon implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if( modelo.turno().objetoSeleccionado() instanceof EdificioAcceso ){
				
				((EdificioAcceso) modelo.turno().objetoSeleccionado()).construirDragon();
			}
		}
		
	}

		public ActionListener getBotonAccesoDragon() {
			return new EscuchaBotonDragon();
		}
		
	private class EscuchaBotonPuertoEstelarScout implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if( modelo.turno().objetoSeleccionado() instanceof EdificioPuertoEstelarProtos ){
					
					((EdificioPuertoEstelarProtos) modelo.turno().objetoSeleccionado()).construirScout();
				}
			}
			
		}

			public ActionListener getBotonPuertoEstelarScout() {
				return new EscuchaBotonPuertoEstelarScout();
			}
			
	private class EscuchaBotonPuertoEstelarNaveTransporte implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					
					if( modelo.turno().objetoSeleccionado() instanceof EdificioPuertoEstelarProtos ){
						
						((EdificioPuertoEstelarProtos) modelo.turno().objetoSeleccionado()).construirNaveTransporte();
					}
				}
				
			}

				public ActionListener getBotonPuertoEstelarNaveTransporte() {
					return new EscuchaBotonPuertoEstelarNaveTransporte();
				}
				
	private class EscuchaBotonArchivosTemplarios implements ActionListener{

					public void actionPerformed(ActionEvent e) {
						
						if( modelo.turno().objetoSeleccionado() instanceof EdificioArchivosTemplarios ){
							
							((EdificioArchivosTemplarios) modelo.turno().objetoSeleccionado()).construirAltoTemplario();
						}
					}
					
				}

					public ActionListener getBotonArchivosTemplarios() {
						return new EscuchaBotonArchivosTemplarios();
					}
}
