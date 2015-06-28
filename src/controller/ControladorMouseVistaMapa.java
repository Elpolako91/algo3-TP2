package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.Edificio;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Posicion;


public class ControladorMouseVistaMapa extends MouseAdapter {
	
	private JuegoCraft modelo;
	private Posicion posicion;

	public ControladorMouseVistaMapa(Posicion unaPosicion, JuegoCraft unModelo) {
		
		this.posicion = unaPosicion;
		this.modelo = unModelo;
	}
	
	public void mouseClicked (MouseEvent e){
		
		if( modelo.turno().edificioAConstruir() != null ){
			
			modelo.turno().construirEdificio( posicion, (Edificio) modelo.turno().edificioAConstruir() );
		}
	}

}
