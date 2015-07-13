package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import fiuba.algo3.tp2.EdificioBarraca;
import fiuba.algo3.tp2.EdificioCentralTerran;
import fiuba.algo3.tp2.EdificioCentroMineral;
import fiuba.algo3.tp2.EdificioDeposito;
import fiuba.algo3.tp2.EdificioFabrica;
import fiuba.algo3.tp2.EdificioPuertoEstelarTerran;
import fiuba.algo3.tp2.EdificioRefineria;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Jugador;

public class ControladorCreadorEdificiosTerran extends MouseAdapter {
	
	private JuegoCraft modelo;
	
	public ControladorCreadorEdificiosTerran(JuegoCraft unModelo) {
		
		modelo = unModelo;
		
	}
	
	private class EscuchaBotonBarraca implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = modelo.turno();
			EdificioBarraca barraca = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirBarraca();
			jugadorActual.edificioAConstruir(barraca);
			jugadorActual.colocarEdificio(true);
		}
	}
	
		public ActionListener getBotonBarraca() {
			return new EscuchaBotonBarraca();
		}
		
	
	private class EscuchaBotonCentroMineral implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = modelo.turno();
			EdificioCentroMineral centroMineral = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirRecolectorMineral();
			jugadorActual.edificioAConstruir(centroMineral);
			jugadorActual.colocarEdificio(true);
		}
	}
	
		public ActionListener getBotonCentroMineral() {
			return new EscuchaBotonCentroMineral();
		}
		
		private class EscuchaBotonDeposito implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioDeposito deposito = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirAsentamiento();
				jugadorActual.edificioAConstruir(deposito);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonDeposito() {
			
			return new EscuchaBotonDeposito();
		}
		
		private class EscuchaBotonFabrica implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioFabrica fabrica = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirFabrica();
				jugadorActual.edificioAConstruir(fabrica);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonFabrica() {
			
			return new EscuchaBotonFabrica();
		}
		
		private class EscuchaBotonPuertoEstelar implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioPuertoEstelarTerran puertoEstelar = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirPuertoEstelarTerran();
				jugadorActual.edificioAConstruir(puertoEstelar);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonPuertoEstelar() {
			
			return new EscuchaBotonPuertoEstelar();
		}
		
		private class EscuchaBotonRefineria implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = modelo.turno();
				EdificioRefineria refineria = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirRecolectorGasVespeno();
				jugadorActual.edificioAConstruir(refineria);
				jugadorActual.colocarEdificio(true);
			}
		}

		public ActionListener getBotonRefineria() {
			
			return new EscuchaBotonRefineria();
		}
}