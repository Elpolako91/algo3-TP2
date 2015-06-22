package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class VistaMenuSegundoJugador extends JFrame {

	private JPanel contentPane;
	private String raza;
	private String color;
	private ButtonGroup colores = new ButtonGroup();
	private ButtonGroup razas = new ButtonGroup();
	private JTextField textField_1;

	public VistaMenuSegundoJugador(final VistaMapa vistaMapa, final VistaMenuPrimerJugador vistaMenuPrimerJugador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuDelSegundo = new JLabel("Menu Del Segundo Jugador");
		lblMenuDelSegundo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDelSegundo.setForeground(Color.WHITE);
		lblMenuDelSegundo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMenuDelSegundo.setBounds(135, 31, 431, 41);
		contentPane.add(lblMenuDelSegundo);
		
		JLabel label_1 = new JLabel("Elige tu Raza");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(72, 83, 172, 48);
		contentPane.add(label_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Terran");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(72, 138, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Protos");
		rdbtnNewRadioButton_1.setBounds(72, 164, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		razas.add(rdbtnNewRadioButton);
		razas.add(rdbtnNewRadioButton_1);
		
		JLabel label = new JLabel("Elige tu Color");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(102, 204, 51));
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(72, 213, 171, 41);
		contentPane.add(label);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Azul");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setForeground(Color.BLUE);
		rdbtnNewRadioButton_2.setBounds(72, 265, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Rojo");
		rdbtnNewRadioButton_3.setForeground(Color.RED);
		rdbtnNewRadioButton_3.setBounds(72, 291, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Verde");
		rdbtnNewRadioButton_4.setForeground(Color.GREEN);
		rdbtnNewRadioButton_4.setBounds(72, 317, 109, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Rosa");
		rdbtnNewRadioButton_5.setForeground(Color.MAGENTA);
		rdbtnNewRadioButton_5.setBounds(72, 343, 109, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		colores.add(rdbtnNewRadioButton_2);
		colores.add(rdbtnNewRadioButton_3);
		colores.add(rdbtnNewRadioButton_4);
		colores.add(rdbtnNewRadioButton_5);
		
		JLabel label_2 = new JLabel("Ingresa Tu Nombre");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 25));
		label_2.setBounds(301, 103, 242, 58);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(301, 172, 242, 58);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				raza = razas.getSelection().getActionCommand();
				color = colores.getSelection().getActionCommand();
				vistaMapa.raza(raza);
				vistaMapa.color(color);
				vistaMapa.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(453, 499, 172, 58);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Atrás");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vistaMenuPrimerJugador.setVisible(true);
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(35, 499, 172, 58);
		contentPane.add(btnSalir);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("imagenes\\starcraftVista2.jpg"));
		label_3.setBounds(0, 0, 635, 568);
		contentPane.add(label_3);
		
	}
}
