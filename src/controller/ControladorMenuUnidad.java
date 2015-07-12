package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VistaMenuUnidad;

import fiuba.algo3.tp2.JuegoCraft;

public class ControladorMenuUnidad implements ActionListener {

	private JuegoCraft modelo;
	private VistaMenuUnidad vista;

	public ControladorMenuUnidad(JuegoCraft modelo) {

		this.modelo = modelo;
		this.vista = new VistaMenuUnidad(modelo);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.vista.setVisible(true);
	}

}
