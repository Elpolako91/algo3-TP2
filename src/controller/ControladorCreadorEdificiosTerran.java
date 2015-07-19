package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentroMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioFabrica;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioPuertoEstelarTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRefineria;

public class ControladorCreadorEdificiosTerran extends MouseAdapter {
	
	private Usuario user;
	
	public ControladorCreadorEdificiosTerran(Usuario user) {
		
		this.user = user;
		
	}
	
	private class EscuchaBotonBarraca implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = user.jugadorActual();
			EdificioBarraca barraca;
			try {
				barraca = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirBarraca();
				user.edificioAConstruir(barraca);
				user.colocarEdificio(true);
			} catch (RecursosInsuficientes e1) {
				e1.printStackTrace();
			}
		}
	}
	
		public ActionListener getBotonBarraca() {
			return new EscuchaBotonBarraca();
		}
		
	
	private class EscuchaBotonCentroMineral implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			Jugador jugadorActual = user.jugadorActual();
			EdificioCentroMineral centroMineral;
			try {
				centroMineral = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirRecolectorMineral();
				user.edificioAConstruir(centroMineral);
				user.colocarEdificio(true);
			} catch (RecursosInsuficientes e1) {
				e1.printStackTrace();
			}
		}
	}
	
		public ActionListener getBotonCentroMineral() {
			return new EscuchaBotonCentroMineral();
		}
		
		private class EscuchaBotonDeposito implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioDeposito deposito;
				try {
					deposito = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirAsentamiento();
					user.edificioAConstruir(deposito);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonDeposito() {
			
			return new EscuchaBotonDeposito();
		}
		
		private class EscuchaBotonFabrica implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioFabrica fabrica;
				try {
					fabrica = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirFabrica();
					user.edificioAConstruir(fabrica);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes | RequerimientosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonFabrica() {
			
			return new EscuchaBotonFabrica();
		}
		
		private class EscuchaBotonPuertoEstelar implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioPuertoEstelarTerran puertoEstelar;
				try {
					puertoEstelar = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirPuertoEstelarTerran();
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
		
		private class EscuchaBotonRefineria implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
			
				Jugador jugadorActual = user.jugadorActual();
				EdificioRefineria refineria;
				try {
					refineria = ((EdificioCentralTerran) jugadorActual.edificioCentral()).construirRecolectorGasVespeno();
					user.edificioAConstruir(refineria);
					user.colocarEdificio(true);
				} catch (RecursosInsuficientes e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		public ActionListener getBotonRefineria() {
			
			return new EscuchaBotonRefineria();
		}
}