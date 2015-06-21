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

public class VistaMenuPrimerJugador extends JFrame {

	private JPanel contentPane;
	private ButtonGroup botonesRaza = new ButtonGroup();
	private ButtonGroup botonesColores = new ButtonGroup();
	final VistaMapa vistaMapa = new VistaMapa();
	final VistaMenuSegundoJugador vista3 = new VistaMenuSegundoJugador(vistaMapa, this);
	public String color;
	public String raza;
	public String nombre;
	private JTextField textNombre;

	public VistaMenuPrimerJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(21, 488, 152, 53);
		contentPane.add(btnSalir);
		
		final JRadioButton rdoBtnAzul = new JRadioButton("Azul");
		rdoBtnAzul.setSelected(true);
		rdoBtnAzul.setForeground(new Color(0, 0, 255));
		rdoBtnAzul.setBounds(84, 268, 97, 23);
		rdoBtnAzul.setActionCommand("Azul");
		contentPane.add(rdoBtnAzul);
		
		final JRadioButton rdoBtnRojo = new JRadioButton("Rojo");
		rdoBtnRojo.setForeground(new Color(255, 0, 0));
		rdoBtnRojo.setBounds(84, 294, 97, 23);
		rdoBtnRojo.setActionCommand("Rojo");
		contentPane.add(rdoBtnRojo);
		
		final JRadioButton rdoBtnVerde = new JRadioButton("Verde");
		rdoBtnVerde.setForeground(new Color(34, 139, 34));
		rdoBtnVerde.setBounds(84, 320, 97, 23);
		rdoBtnVerde.setActionCommand("Verde");
		contentPane.add(rdoBtnVerde);
		
		final JRadioButton rdoBtnRosa = new JRadioButton("Rosa");
		rdoBtnRosa.setForeground(new Color(255, 0, 255));
		rdoBtnRosa.setBounds(84, 346, 97, 23);
		rdoBtnRosa.setActionCommand("Rosa");
		contentPane.add(rdoBtnRosa);

		botonesColores.add(rdoBtnAzul);
		botonesColores.add(rdoBtnRojo);
		botonesColores.add(rdoBtnVerde);
		botonesColores.add(rdoBtnRosa);
		
		//el color que elija se deber� guardar en la raza del jugador
		
		final JRadioButton rdoBtnProtos = new JRadioButton("Protos");
		rdoBtnProtos.setBounds(72, 159, 109, 23);
		contentPane.add(rdoBtnProtos);
		
		final JRadioButton rdoBtnTerran = new JRadioButton("Terran");
		rdoBtnTerran.setSelected(true);
		botonesRaza.add(rdoBtnTerran);
		rdoBtnTerran.setBounds(72, 133, 109, 23);
		contentPane.add(rdoBtnTerran);
		
		botonesRaza.add(rdoBtnProtos);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		textNombre.setBounds(316, 165, 217, 41);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresa Tu Nombre");
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(291, 98, 242, 58);
		contentPane.add(lblNewLabel_3);
		
		//la raza que elija se deber� guardar en la raza del jugador
		
		JLabel lblNewLabel_2 = new JLabel("Elige tu Color");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(102, 204, 51));
		lblNewLabel_2.setBounds(30, 220, 171, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Elige tu Raza");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(29, 78, 172, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMenuDelJugador = new JLabel("Menu Del Primer Jugador");
		lblMenuDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelJugador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMenuDelJugador.setForeground(Color.WHITE);
		lblMenuDelJugador.setBounds(102, 11, 431, 41);
		contentPane.add(lblMenuDelJugador);
		
		JButton btnComenzar = new JButton("Siguiente");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deberia cargar la partida
				raza = botonesRaza.getSelection().getActionCommand();
				color = botonesColores.getSelection().getActionCommand();
				nombre = textNombre.getText();
				vistaMapa.nombre(nombre);
				vistaMapa.raza(raza);
				vistaMapa.color(color);
				vista3.setVisible(true);
				dispose();
			}
		});
		btnComenzar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnComenzar.setBounds(473, 487, 152, 53);
		contentPane.add(btnComenzar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("imagenes\\starcraft_2_widescreen_wallpaper_18.jpg"));
		label.setBounds(0, 0, 635, 568);
		contentPane.add(label);
	}
}
