package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioFabrica;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarTerran;

public class ControladorUnidadTerran extends MouseAdapter {

	private Usuario user;

	public ControladorUnidadTerran(Usuario user) {
		
		this.user = user;
	}
	
	private class EscuchaBotonMarine implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			if ( user.objetoSeleccionado() instanceof EdificioBarraca ){
				
				try {
					((EdificioBarraca) user.objetoSeleccionado()).construirMarine();
				} catch (RecursosInsuficientes e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
		public ActionListener getBotonBarraca() {
			return new EscuchaBotonMarine();
		}
		
	private class EscuchaBotonFabrica implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if( user.objetoSeleccionado() instanceof EdificioFabrica ){
				
				try {
					((EdificioFabrica) user.objetoSeleccionado()).crearGolliat();
				} catch (RecursosInsuficientes e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

		public ActionListener getBotonFabrica() {
			return new EscuchaBotonFabrica();
		}
		
	private class EscuchaBotonPuertoEstelarEspectro implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if( user.objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
					
					try {
						((EdificioPuertoEstelarTerran) user.objetoSeleccionado()).construirEspectro();
					} catch (RecursosInsuficientes e1) {
						e1.printStackTrace();
					}
				}
			}
			
		}

			public ActionListener getBotonPuertoEstelarEspectro() {
				return new EscuchaBotonPuertoEstelarEspectro();
			}
			
	private class EscuchaBotonPuertoEstelarNaveTransporte implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					
					if( user.objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
						
						try {
							((EdificioPuertoEstelarTerran) user.objetoSeleccionado()).construirNaveTransporte();
						} catch (RecursosInsuficientes e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}

				public ActionListener getBotonPuertoEstelarNaveTransporte() {
					return new EscuchaBotonPuertoEstelarNaveTransporte();
				}
				
	private class EscuchaBotonPuertoEstelarNaveCiencia implements ActionListener{

					public void actionPerformed(ActionEvent e) {
						
						if( user.objetoSeleccionado() instanceof EdificioPuertoEstelarTerran ){
							
							try {
								((EdificioPuertoEstelarTerran) user.objetoSeleccionado()).construirNaveCiencia();
							} catch (RecursosInsuficientes e1) {
								e1.printStackTrace();
							}
						}
					}
					
				}

					public ActionListener getBotonPuertoEstelarNaveCiencia() {
						return new EscuchaBotonPuertoEstelarNaveCiencia();
					}
}
