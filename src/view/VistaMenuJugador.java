package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;

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

public class VistaMenuJugador extends JFrame {

	private JPanel contentPane;
	private ButtonGroup botonesRaza = new ButtonGroup();
	private ButtonGroup botonesColores = new ButtonGroup();
	private VistaMapa vista3 = new VistaMapa();
	public String color;
	public String raza;
	public String nombre;
	private JTextField textNombre;

	public VistaMenuJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//deberia cargar la partida
				vista3.color(color);
				vista3.raza(raza);
				vista3.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(473, 487, 152, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(21, 488, 152, 53);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxAzul = new JCheckBox("Azul");
		chckbxAzul.setForeground(new Color(0, 0, 255));
		chckbxAzul.setBounds(84, 268, 97, 23);
		contentPane.add(chckbxAzul);
		if (chckbxAzul.isSelected()){
			//asignar color azul
			color = "azul";
		}
		
		JCheckBox chckbxRojo = new JCheckBox("Rojo");
		chckbxRojo.setForeground(new Color(255, 0, 0));
		chckbxRojo.setBounds(84, 294, 97, 23);
		contentPane.add(chckbxRojo);
		if (chckbxRojo.isSelected()){
			//asignar color rojo
			color = "rojo";
		}
		
		JCheckBox chckbxAmarillo = new JCheckBox("Verde");
		chckbxAmarillo.setForeground(new Color(34, 139, 34));
		chckbxAmarillo.setBounds(84, 320, 97, 23);
		contentPane.add(chckbxAmarillo);
		if (chckbxAmarillo.isSelected()){
			//asignar color amarillo
			color = "amarillo";
		}
		
		JCheckBox chckbxVioleta = new JCheckBox("Rosa");
		chckbxVioleta.setForeground(new Color(255, 0, 255));
		chckbxVioleta.setBounds(84, 346, 97, 23);
		contentPane.add(chckbxVioleta);
		if (chckbxVioleta.isSelected()){
			//asignar color violeta
			color = "violeta";
		}
		
		botonesColores.add(chckbxAzul);
		botonesColores.add(chckbxRojo);
		botonesColores.add(chckbxAmarillo);
		botonesColores.add(chckbxVioleta);
		
		//el color que elija se deberá guardar en la raza del jugador
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Protos");
		rdbtnNewRadioButton_1.setBounds(72, 159, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		if (rdbtnNewRadioButton_1.isSelected()){
			//asignar raza Protos al jugador
			raza = "Protos";
		}
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Terran");
		botonesRaza.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(72, 133, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		if (rdbtnNewRadioButton.isSelected()){
			//asignar raza Terran al jugador
			raza = "Terran";
		}
		
		botonesRaza.add(rdbtnNewRadioButton_1);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		textNombre.setBounds(316, 165, 217, 41);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		vista3.nombre(textNombre.getText());
		
		JLabel lblNewLabel_3 = new JLabel("Ingresa Tu Nombre");
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(291, 98, 242, 58);
		contentPane.add(lblNewLabel_3);
		
		//la raza que elija se deberá guardar en la raza del jugador
		
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
		
		JLabel lblMenuDelJugador = new JLabel("Menu Del Jugador");
		lblMenuDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelJugador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMenuDelJugador.setForeground(Color.WHITE);
		lblMenuDelJugador.setBounds(102, 11, 431, 41);
		contentPane.add(lblMenuDelJugador);
		
		JLabel lblNewLabel = new JLabel("imagen");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Familia\\Desktop\\starcraft_2_widescreen_wallpaper_18.jpg"));
		lblNewLabel.setBounds(0, 0, 635, 568);
		contentPane.add(lblNewLabel);
	}
}
