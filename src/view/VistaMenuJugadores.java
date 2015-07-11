package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import fiuba.algo3.tp2.JuegoCraft;

public class VistaMenuJugadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup botonesRaza1 = new ButtonGroup();
	private ButtonGroup botonesColores1 = new ButtonGroup();
	private ButtonGroup botonesRaza2 = new ButtonGroup();
	private ButtonGroup botonesColores2 = new ButtonGroup();
	VistaMapa vista3;
	public String color1;
	public String raza1;
	public String nombre1;
	public String color2;
	public String raza2;
	public String nombre2;
	private JTextField textNombre;
	JuegoCraft modelo;
	private JTextField textNombre2;

	public VistaMenuJugadores(JuegoCraft unModelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 650, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.modelo = unModelo;
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(21, 488, 152, 53);
		contentPane.add(btnSalir);
		
		//la raza que elija se deber� guardar en la raza del jugador
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(102, 204, 51));
		lblNewLabel_2.setBounds(231, 63, 139, 25);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdoBtnAzul = new JRadioButton("Azul");
		rdoBtnAzul.setSelected(true);
		rdoBtnAzul.setForeground(new Color(0, 0, 255));
		rdoBtnAzul.setBounds(241, 94, 97, 23);
		rdoBtnAzul.setActionCommand("Azul");
		contentPane.add(rdoBtnAzul);
		
		JRadioButton rdoBtnRojo = new JRadioButton("Rojo");
		rdoBtnRojo.setForeground(new Color(255, 0, 0));
		rdoBtnRojo.setBounds(241, 172, 97, 23);
		rdoBtnRojo.setActionCommand("Rojo");
		contentPane.add(rdoBtnRojo);
		
		JRadioButton rdoBtnVerde = new JRadioButton("Verde");
		rdoBtnVerde.setForeground(new Color(34, 139, 34));
		rdoBtnVerde.setBounds(241, 120, 97, 23);
		rdoBtnVerde.setActionCommand("Verde");
		contentPane.add(rdoBtnVerde);
		
		JRadioButton rdoBtnRosa = new JRadioButton("Rosa");
		rdoBtnRosa.setForeground(new Color(255, 0, 255));
		rdoBtnRosa.setBounds(241, 146, 97, 23);
		rdoBtnRosa.setActionCommand("Rosa");
		contentPane.add(rdoBtnRosa);

		botonesColores1.add(rdoBtnAzul);
		botonesColores1.add(rdoBtnRojo);
		botonesColores1.add(rdoBtnVerde);
		botonesColores1.add(rdoBtnRosa);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		textNombre.setBounds(10, 101, 198, 23);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel label_1 = new JLabel("Ingresa Tu Nombre");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(10, 66, 198, 24);
		contentPane.add(label_1);
		
		textNombre2 = new JTextField();
		textNombre2.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		textNombre2.setBounds(10, 303, 198, 23);
		contentPane.add(textNombre2);
		textNombre2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresa Tu Nombre");
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 271, 198, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_2 = new JLabel("Color");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(102, 204, 51));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(231, 271, 139, 25);
		contentPane.add(label_2);
		
		JRadioButton rdbtnRojo2 = new JRadioButton("Rojo");
		rdbtnRojo2.setForeground(Color.RED);
		rdbtnRojo2.setBounds(241, 381, 109, 23);
		rdbtnRojo2.setActionCommand("Rojo");
		contentPane.add(rdbtnRojo2);
		
		JRadioButton rdbtnAzul2 = new JRadioButton("Azul");
		rdbtnAzul2.setForeground(Color.BLUE);
		rdbtnAzul2.setBounds(241, 303, 109, 23);
		rdbtnAzul2.setActionCommand("Azul");
		contentPane.add(rdbtnAzul2);
		
		JRadioButton rdbtnVerde2 = new JRadioButton("Verde");
		rdbtnVerde2.setForeground(new Color(0, 128, 0));
		rdbtnVerde2.setSelected(true);
		rdbtnVerde2.setBounds(241, 329, 109, 23);
		rdbtnVerde2.setActionCommand("Verde");
		contentPane.add(rdbtnVerde2);
		
		JRadioButton rdbtnRosa2 = new JRadioButton("Rosa");
		rdbtnRosa2.setForeground(Color.MAGENTA);
		rdbtnRosa2.setBounds(241, 355, 109, 23);
		rdbtnRosa2.setActionCommand("Rosa");
		contentPane.add(rdbtnRosa2);
		
		botonesColores2.add(rdbtnRojo2);
		botonesColores2.add(rdbtnAzul2);
		botonesColores2.add(rdbtnVerde2);
		botonesColores2.add(rdbtnRosa2);
		
		JLabel lblNewLabel_1 = new JLabel("Elige tu Raza");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(394, 63, 139, 25);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnTerran1 = new JRadioButton("Terran");
		rdbtnTerran1.setSelected(true);
		rdbtnTerran1.setBounds(424, 105, 109, 23);
		rdbtnTerran1.setActionCommand("terran");
		contentPane.add(rdbtnTerran1);
		
		JRadioButton rdbtnProtos1 = new JRadioButton("Protos");
		rdbtnProtos1.setBounds(424, 131, 109, 23);
		rdbtnProtos1.setActionCommand("protos");
		contentPane.add(rdbtnProtos1);
		
		botonesRaza1.add(rdbtnTerran1);
		botonesRaza1.add(rdbtnProtos1);
		
		JLabel lblMenuDelJugador = new JLabel("Primer Jugador");
		lblMenuDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelJugador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMenuDelJugador.setForeground(Color.WHITE);
		lblMenuDelJugador.setBounds(102, 11, 431, 41);
		contentPane.add(lblMenuDelJugador);
		
		JLabel label_3 = new JLabel("Elige tu Raza");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 0, 255));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(394, 271, 139, 25);
		contentPane.add(label_3);
		
		JRadioButton rdbtnTerran2 = new JRadioButton("Terran");
		rdbtnTerran2.setSelected(true);
		rdbtnTerran2.setBounds(424, 303, 109, 23);
		rdbtnTerran2.setActionCommand("terran");
		contentPane.add(rdbtnTerran2);
		
		JRadioButton rdbtnProtos2 = new JRadioButton("Protos");
		rdbtnProtos2.setBounds(424, 329, 109, 23);
		rdbtnProtos2.setActionCommand("protos");
		contentPane.add(rdbtnProtos2);
		
		botonesRaza2.add(rdbtnTerran2);
		botonesRaza2.add(rdbtnProtos2);
		
		JLabel lblSegundoJugador = new JLabel("Segundo Jugador");
		lblSegundoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoJugador.setForeground(Color.WHITE);
		lblSegundoJugador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSegundoJugador.setBounds(90, 202, 431, 41);
		contentPane.add(lblSegundoJugador);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deberia cargar la partida
				raza1 = botonesRaza1.getSelection().getActionCommand();
				color1 = botonesColores1.getSelection().getActionCommand();
				nombre1 = textNombre.getText();
				modelo.cargarJugador(nombre1, color1, raza1);
				raza2 = botonesRaza2.getSelection().getActionCommand();
				color2 = botonesColores2.getSelection().getActionCommand();
				nombre2 = textNombre2.getText();
				if (( nombre1 != nombre2) && ( color1 != color2 )){
					modelo.cargarJugador(nombre2, color2, raza2);
					vista3 = new VistaMapa(modelo);
					vista3.setVisible(true);
					dispose();
				}
			}
		});
		btnComenzar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnComenzar.setBounds(473, 487, 152, 53);
		contentPane.add(btnComenzar);
		
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(VistaMenuJugadores.class.getResource("/imagenes/starcraftVista2.jpg")));
		label.setBounds(0, 0, 650, 606);
		contentPane.add(label);
	}
}
