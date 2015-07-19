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

import controller.ControladorCreadorEdificiosProtos;
import fiuba.algo3.tp2.juego.Usuario;

public class VistaConstruccionProtos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorCreadorEdificiosProtos controlador;
	private Usuario user;

	
	public VistaConstruccionProtos(Usuario user){
		
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(700, 0, 500, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	this.user = user;
	controlador = new ControladorCreadorEdificiosProtos(user);
	
	final JButton botonAcceso = new JButton("Acceso");
	botonAcceso.setBounds(120, 120, 138, 32);
	contentPane.add(botonAcceso);
	botonAcceso.setFont(new Font("Tahoma", Font.PLAIN, 15));
	botonAcceso.setVisible(false);
	botonAcceso.addActionListener(controlador.getBotonAcceso());
	
	final JButton btnNexoMineral = new JButton("Nexo Mineral");
	btnNexoMineral.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNexoMineral.setBounds(120, 220, 138, 32);
	contentPane.add(btnNexoMineral);
	btnNexoMineral.setVisible(false);
	btnNexoMineral.addActionListener(controlador.getBotonNexoMineral());
	
	final JButton btnPilon = new JButton("Pilon");
	btnPilon.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnPilon.setBounds(270, 120, 138, 32);
	contentPane.add(btnPilon);
	btnPilon.setVisible(false);
	btnPilon.addActionListener(controlador.getBotonPilon());
	
	final JButton btnArchivosTemplarios = new JButton("Archivos Templarios");
	btnArchivosTemplarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnArchivosTemplarios.setBounds(270, 220, 138, 32);
	contentPane.add(btnArchivosTemplarios);
	btnArchivosTemplarios.setVisible(false);
	btnArchivosTemplarios.addActionListener(controlador.getBotonArchivosTemplarios());
	
	final JButton btnPuertoEstelar = new JButton("Puerto Estelar");
	btnPuertoEstelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnPuertoEstelar.setBounds(120, 320, 138, 32);
	contentPane.add(btnPuertoEstelar);
	btnPuertoEstelar.setVisible(false);
	btnPuertoEstelar.addActionListener(controlador.getBotonPuertoEstelar());
	
	final JButton btnAsimilador = new JButton("Asimilador");
	btnAsimilador.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnAsimilador.setBounds(270, 320, 138, 32);
	contentPane.add(btnAsimilador);
	btnAsimilador.setVisible(false);
	btnAsimilador.addActionListener(controlador.getBotonAsimilador());
		
	
	final JButton btnNewButton = new JButton("Construir");
	btnNewButton.setBounds(20, 20, 122, 70);
	contentPane.add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			botonAcceso.setVisible(true);
			btnNexoMineral.setVisible(true);
			btnPilon.setVisible(true);
			btnArchivosTemplarios.setVisible(true);
			btnPuertoEstelar.setVisible(true);
			btnAsimilador.setVisible(true);
			
		}
	});
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
	lblNewLabel.setBounds(0, 0, 500, 500);
	contentPane.add(lblNewLabel);
	
	}
}
