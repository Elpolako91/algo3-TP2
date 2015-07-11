package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import fiuba.algo3.tp2.Edificio;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Posicion;
import fiuba.algo3.tp2.PosicionMapa;
import fiuba.algo3.tp2.Unidad;

public class ControladorMouseVistaMapa extends MouseAdapter {
	
	private JuegoCraft modelo;
	private Posicion posicion;
	private Object contenido;
	private JButton boton;

	public ControladorMouseVistaMapa(Posicion unaPosicion, JuegoCraft unModelo, JButton boton) {
		
		this.posicion = unaPosicion;
		this.modelo = unModelo;
		this.boton = boton;
	}
	
	public void mousePressed (MouseEvent e){
		
		Jugador jugadorActual = modelo.turno();
		boton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		if( jugadorActual.getColocarEdificio() ){
			
			jugadorActual.construirEdificio( posicion,(Edificio) jugadorActual.edificioAConstruir() );
			jugadorActual.edificioAConstruir(null);
			jugadorActual.colocarEdificio(false);
			
		}else{
			if ( jugadorActual.getAccionAtacarAire()){
		
				jugadorActual.atacarAire((Unidad)jugadorActual.objetoSeleccionado(), posicion);
				jugadorActual.accionAtacarAire(false);
			
			}else{
				if( jugadorActual.getAccionAtacarTierra()){
		
					jugadorActual.atacarTierra((Unidad)jugadorActual.objetoSeleccionado(), posicion);
					jugadorActual.accionAtacarTierra(false);
					
				}else{
					if( jugadorActual.getAccionMoverTerrestre()){
						
						jugadorActual.moverUnidad((Unidad) jugadorActual.objetoSeleccionado(), posicion);
						jugadorActual.accionMoverTerrestre(false);
						
					}else{
						if (jugadorActual.getAccionMoverAire()){
						
							jugadorActual.moverUnidad((Unidad) jugadorActual.objetoSeleccionado(), posicion);
							jugadorActual.accionMoverAire(false);
							
						}else{
			
							PosicionMapa posicionMapa = new PosicionMapa(posicion.x(), posicion.y(), 1);
							contenido = modelo.mapa().contenido(posicionMapa);
							modelo.turno().objetoSeleccionado(contenido);
						}
					}
				}
			}
		}
	}
}
