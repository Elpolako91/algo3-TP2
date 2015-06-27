package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorMouse;

import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Mapa;
import fiuba.algo3.tp2.Tamanio;

public class VistaMapa extends JFrame {

	private JPanel contentPane;
	private JuegoCraft modelo;
	private ArrayList<String> color = new ArrayList<String>();
	private ArrayList<String> raza = new ArrayList<String>();
	private ArrayList<String> nombre = new ArrayList<String>();
	private Posicion posicion;
	private int limiteMapa = 650;

	public VistaMapa() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 650, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new JuegoCraft();
		modelo.cargarMapa(new Mapa(new Tamanio(10,10)));
		
		for(int i = 1; i<=nombre.size();i++){
			modelo.cargarJugador(nombre.get(i), color.get(i), raza.get(i));
		}
		JButton temp = new JButton();
		temp.setBounds(0,0,limiteMapa,limiteMapa);
		temp.setBackground(Color.GREEN);
		contentPane.add(temp);
		temp.addMouseListener(new ControladorMouse(modelo, this));

	}

	public void color(String unColor) {
		color.add(unColor);
		
	}
	
	public void raza(String unaRaza) {
		raza.add(unaRaza);
		
	}
	
	public void nombre(String unNombre) {
		nombre.add(unNombre);
	}
}

