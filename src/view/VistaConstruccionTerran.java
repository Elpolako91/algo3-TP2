package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controller.ControladorCreadorEdificiosTerran;
import fiuba.algo3.tp2.JuegoCraft;

public class VistaConstruccionTerran extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private ControladorCreadorEdificiosTerran controlador;

	
	public VistaConstruccionTerran(JuegoCraft modelo){
		
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(700, 0, 500, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	this.modelo = modelo;
	controlador = new ControladorCreadorEdificiosTerran(modelo);
	
	final JButton botonBarraca = new JButton("Barraca");
	botonBarraca.setBounds(120, 120, 138, 32);
	contentPane.add(botonBarraca);
	botonBarraca.setFont(new Font("Tahoma", Font.PLAIN, 15));
	botonBarraca.setVisible(false);
	botonBarraca.addActionListener(controlador.getBotonBarraca());
	
	final JButton btnCentroMineral = new JButton("Centro Mineral");
	btnCentroMineral.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnCentroMineral.setBounds(120, 220, 138, 32);
	contentPane.add(btnCentroMineral);
	btnCentroMineral.setVisible(false);
	btnCentroMineral.addActionListener(controlador.getBotonCentroMineral());
	
	final JButton btnDeposito = new JButton("Deposito");
	btnDeposito.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnDeposito.setBounds(270, 120, 138, 32);
	contentPane.add(btnDeposito);
	btnDeposito.setVisible(false);
	btnDeposito.addActionListener(controlador.getBotonDeposito());
	
	final JButton btnFabrica = new JButton("Fabrica");
	btnFabrica.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnFabrica.setBounds(270, 220, 138, 32);
	contentPane.add(btnFabrica);
	btnFabrica.setVisible(false);
	btnFabrica.addActionListener(controlador.getBotonFabrica());
	
	final JButton btnPuertoEstelar = new JButton("Puerto Estelar");
	btnPuertoEstelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnPuertoEstelar.setBounds(120, 320, 138, 32);
	contentPane.add(btnPuertoEstelar);
	btnPuertoEstelar.setVisible(false);
	btnPuertoEstelar.addActionListener(controlador.getBotonPuertoEstelar());
	
	final JButton btnRefineria = new JButton("Refineria");
	btnRefineria.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnRefineria.setBounds(270, 320, 138, 32);
	contentPane.add(btnRefineria);
	btnRefineria.setVisible(false);
	btnRefineria.addActionListener(controlador.getBotonRefineria());
		
	
	final JButton btnNewButton = new JButton("Construir");
	btnNewButton.setBounds(20, 20, 122, 70);
	contentPane.add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			botonBarraca.setVisible(true);
			btnCentroMineral.setVisible(true);
			btnDeposito.setVisible(true);
			btnFabrica.setVisible(true);
			btnPuertoEstelar.setVisible(true);
			btnRefineria.setVisible(true);
			
		}
	});
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
	lblNewLabel.setBounds(0, 0, 500, 500);
	contentPane.add(lblNewLabel);
	
	}
}
