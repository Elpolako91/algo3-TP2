package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import fiuba.algo3.tp2.JuegoCraft;

public class ControladorMouseTurno extends MouseAdapter {
	
	private JuegoCraft modelo;


	public ControladorMouseTurno( JuegoCraft unModelo ){
		
		modelo = unModelo;

		
	}
	
	public void mouseClicked(MouseEvent e){
			
		modelo.turno().pasarTurno();
		
	}
}
