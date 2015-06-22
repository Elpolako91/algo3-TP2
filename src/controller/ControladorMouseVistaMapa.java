package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.Posicion;

public class ControladorMouseVistaMapa extends MouseAdapter {

	private Posicion posicion;
	
	 public ControladorMouseVistaMapa(Posicion unaPosicion) {
		posicion = unaPosicion;
	}

	public void mouseClicked (MouseEvent e){
	    	
	    	//vista.notify();
	    	System.out.println(posicion.x() + "," + posicion.y());
	    }

}
