package controller;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.tp2.juego.Usuario;


public class ControladorMouseTurno extends MouseAdapter {
	
	private Usuario user;


	public ControladorMouseTurno( Usuario user ){
		
		this.user = user;
		
	}
	
	public void mouseClicked(MouseEvent e){
			
		user.pasarTurno();
/*		Window[] win = Window.getWindows();
		for(int i = 2; i <= win.length; i++){
			try{
				win[i].dispose();
				
			}catch(ArrayIndexOutOfBoundsException exception){}
		}*/
		
	}
}
