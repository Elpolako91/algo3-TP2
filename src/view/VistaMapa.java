package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.tp2.JuegoCraft;

public class VistaMapa extends JFrame {

	private JPanel contentPane;
	private JuegoCraft juego;
	private String color;
	private String raza;
	private String nombre;

	public VistaMapa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		juego.cargarJugador(nombre, color, raza);
		
	}

	public void color(String unColor) {
		color = unColor;
		
	}
	
	public void raza(String unaRaza) {
		raza = unaRaza;
		
	}
	
	public void nombre(String unNombre) {
		nombre = unNombre;
	}
}
