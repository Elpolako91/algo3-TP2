package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tp2.EdificioAcceso;
import fiuba.algo3.tp2.EdificioArchivosTemplarios;
import fiuba.algo3.tp2.EdificioAsimilador;
import fiuba.algo3.tp2.EdificioCentralProtos;
import fiuba.algo3.tp2.EdificioNexoMineral;
import fiuba.algo3.tp2.EdificioPilon;
import fiuba.algo3.tp2.EdificioPuertoEstelarProtos;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Jugador;

public class ControladorCreadorEdificiosProtos {
	
	private JuegoCraft modelo;

	public ControladorCreadorEdificiosProtos(JuegoCraft modelo){	
			
			this.modelo = modelo;
		
	}
	
	private class EscuchaBotonAcceso implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = modelo.turno();
			EdificioAcceso acceso = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirAcceso();
			jugadorActual.edificioAConstruir(acceso);
			jugadorActual.colocarEdificio(true);
		}
	}
	
		public ActionListener getBotonAcceso() {
			return new EscuchaBotonAcceso();
		}
		
	
	private class EscuchaBotonNexoMineral implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = modelo.turno();
			EdificioNexoMineral nexoMineral = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirRecolectorMineral();
			jugadorActual.edificioAConstruir(nexoMineral);
			jugadorActual.colocarEdificio(true);
		}
	}
	
		public ActionListener getBotonNexoMineral() {
			return new EscuchaBotonNexoMineral();
		}
		
		private class EscuchaBotonPilon implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioPilon pilon = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirAsentamiento();
				jugadorActual.edificioAConstruir(pilon);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonPilon() {
			
			return new EscuchaBotonPilon();
		}
		
		private class EscuchaBotonAsimilador implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioAsimilador asimilador = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirRecolectorGasVespeno();
				jugadorActual.edificioAConstruir(asimilador);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonAsimilador() {
			
			return new EscuchaBotonAsimilador();
		}
		
		private class EscuchaBotonPuertoEstelar implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioPuertoEstelarProtos puertoEstelar = ((EdificioCentralProtos) jugadorActual.edificioCentral()).construirPuertoEstelarProtos();
				jugadorActual.edificioAConstruir(puertoEstelar);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonPuertoEstelar() {
			
			return new EscuchaBotonPuertoEstelar();
		}
		
		private class EscuchaBotonArchivosTemplarios implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioArchivosTemplarios archivosTemplarios = ((EdificioCentralProtos) jugadorActual.edificioCentral()).crearArchivosTemplarios();
				jugadorActual.edificioAConstruir(archivosTemplarios);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonArchivosTemplarios() {
			
			return new EscuchaBotonArchivosTemplarios();
		}
}
