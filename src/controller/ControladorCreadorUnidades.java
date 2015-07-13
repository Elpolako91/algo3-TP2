package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import view.VistaCreacionUnidadTerran;

import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Posicion;
import fiuba.algo3.tp2.PosicionMapa;

public class ControladorCreadorUnidades extends MouseAdapter implements ActionListener{
	
	private JuegoCraft modelo;
	private Posicion posicion;
	private Object edificio;

	public ControladorCreadorUnidades(JuegoCraft modelo, Posicion posicion, VistaCreacionUnidadTerran vista){
		
		this.modelo = modelo;
		this.posicion = posicion;
		PosicionMapa posicionMapa = new PosicionMapa(posicion.x(), posicion.y(), 0);
		this.edificio = modelo.mapa().contenido(posicionMapa);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("supp nigga");
	}
	
}
