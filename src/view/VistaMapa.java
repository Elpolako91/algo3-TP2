package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Mapa;
import fiuba.algo3.tp2.Tamanio;

public class VistaMapa extends JFrame {

	private JPanel contentPane;
	private JuegoCraft modelo;
	private ArrayList<String> color = new ArrayList<String>();
	private ArrayList<String> raza = new ArrayList<String>();
	private ArrayList<String> nombre = new ArrayList<String>();

	
	public VistaMapa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 401, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new JuegoCraft();
		modelo.cargarMapa(new Mapa(new Tamanio(10,10)));
		for(int i = 1; i<=nombre.size();i++){
			modelo.cargarJugador(nombre.get(i), color.get(i), raza.get(i));
		}
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				
				//CARGAR MAPA
				
			}
		}
		
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

