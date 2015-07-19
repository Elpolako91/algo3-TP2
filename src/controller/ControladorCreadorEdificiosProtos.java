package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAcceso;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioAsimilador;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioNexoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPilon;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarProtos;

public class ControladorCreadorEdificiosProtos {
	
	private Usuario user;

	public ControladorCreadorEdificiosProtos(Usuario user){	
			
			this.user = user;
		
	}
	
	private class EscuchaBotonAcceso implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = user.jugadorActual();
			EdificioAcceso acceso;
			try {
				acceso = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirAcceso();
				user.edificioAConstruir(acceso);
				user.colocarEdificio(true);
			} catch (RecursosInsuficientes e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
		public ActionListener getBotonAcceso() {
			return new EscuchaBotonAcceso();
		}
		
	
	private class EscuchaBotonNexoMineral implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = user.jugadorActual();
			EdificioNexoMineral nexoMineral;
			try {
				nexoMineral = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirRecolectorMineral();
				user.edificioAConstruir(nexoMineral);
				user.colocarEdificio(true);
			} catch (RecursosInsuficientes e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
		public ActionListener getBotonNexoMineral() {
			return new EscuchaBotonNexoMineral();
		}
		
		private class EscuchaBotonPilon implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioPilon pilon;
				try {
					pilon = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirAsentamiento();
					user.edificioAConstruir(pilon);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonPilon() {
			
			return new EscuchaBotonPilon();
		}
		
		private class EscuchaBotonAsimilador implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioAsimilador asimilador;
				try {
					asimilador = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirRecolectorGasVespeno();
					user.edificioAConstruir(asimilador);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonAsimilador() {
			
			return new EscuchaBotonAsimilador();
		}
		
		private class EscuchaBotonPuertoEstelar implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				try {
					EdificioPuertoEstelarProtos puertoEstelar = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirPuertoEstelarProtos();
					user.edificioAConstruir(puertoEstelar);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes | RequerimientosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonPuertoEstelar() {
			
			return new EscuchaBotonPuertoEstelar();
		}
		
		private class EscuchaBotonArchivosTemplarios implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				try {
					EdificioArchivosTemplarios archivosTemplarios = ((EdificioCentralProtos) jugadorActual.edificioCentral()).crearArchivosTemplarios();
					user.edificioAConstruir(archivosTemplarios);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes | RequerimientosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		public ActionListener getBotonArchivosTemplarios() {
			
			return new EscuchaBotonArchivosTemplarios();
		}
}
