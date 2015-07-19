package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAcceso;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarProtos;

public class ControladorUnidadProtos {
	
	private Usuario user;

	public ControladorUnidadProtos(Usuario user) {
		
		this.user = user;
	}
	
	private class EscuchaBotonZealot implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			if ( user.objetoSeleccionado() instanceof EdificioAcceso ){
				
				try {
					((EdificioAcceso) user.objetoSeleccionado()).construirZealot();
				} catch (RecursosInsuficientes e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
		public ActionListener getBotonAccesoZealot() {
			return new EscuchaBotonZealot();
		}
		
	private class EscuchaBotonDragon implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if( user.objetoSeleccionado() instanceof EdificioAcceso ){
				
				try {
					((EdificioAcceso) user.objetoSeleccionado()).construirDragon();
				} catch (RecursosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

		public ActionListener getBotonAccesoDragon() {
			return new EscuchaBotonDragon();
		}
		
	private class EscuchaBotonPuertoEstelarScout implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if( user.objetoSeleccionado() instanceof EdificioPuertoEstelarProtos ){
					
					try {
						((EdificioPuertoEstelarProtos) user.objetoSeleccionado()).construirScout();
					} catch (RecursosInsuficientes e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}

			public ActionListener getBotonPuertoEstelarScout() {
				return new EscuchaBotonPuertoEstelarScout();
			}
			
	private class EscuchaBotonPuertoEstelarNaveTransporte implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					
					if( user.objetoSeleccionado() instanceof EdificioPuertoEstelarProtos ){
						
						try {
							((EdificioPuertoEstelarProtos) user.objetoSeleccionado()).construirNaveTransporte();
						} catch (RecursosInsuficientes e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			}

				public ActionListener getBotonPuertoEstelarNaveTransporte() {
					return new EscuchaBotonPuertoEstelarNaveTransporte();
				}
				
	private class EscuchaBotonArchivosTemplarios implements ActionListener{

					public void actionPerformed(ActionEvent e) {
						
						if( user.objetoSeleccionado() instanceof EdificioArchivosTemplarios ){
							
							try {
								((EdificioArchivosTemplarios) user.objetoSeleccionado()).construirAltoTemplario();
							} catch (RecursosInsuficientes e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					
				}

					public ActionListener getBotonArchivosTemplarios() {
						return new EscuchaBotonArchivosTemplarios();
					}
}
