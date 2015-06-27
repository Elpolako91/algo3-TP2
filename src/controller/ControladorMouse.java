package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import fiuba.algo3.tp2.JuegoCraft;
import view.VistaMapa;

public class ControladorMouse extends MouseAdapter {

    JuegoCraft modelo;
    
    VistaMapa vista;

    public ControladorMouse(JuegoCraft modelo, VistaMapa vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    
    public void mouseClicked (MouseEvent e){
    	
    	int x = e.getX();
    	int y = e.getY();
    	//vista.notify();
    	System.out.println(x+","+y);
    }
}
