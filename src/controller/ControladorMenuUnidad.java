package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VistaMenuUnidad;

public class ControladorMenuUnidad implements ActionListener {

	private VistaMenuUnidad vista;

	public ControladorMenuUnidad(VistaMenuUnidad vista) {


		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		this.vista.setVisible(true);
	}

}
