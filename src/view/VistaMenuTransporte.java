package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorTransporte;
import fiuba.algo3.tp2.juego.Usuario;

public class VistaMenuTransporte extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorTransporte controlador;
	private Usuario user;

	
	public VistaMenuTransporte(Usuario user){
		
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(200, 0, 500, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	this.user = user;
	controlador = new ControladorTransporte(this.user);
	
	final JButton btnDescargar = new JButton("Descargar");
	btnDescargar.setFont(new Font("Dialog", Font.PLAIN, 18));
	btnDescargar.setBounds(150, 180, 120, 80);
	contentPane.add(btnDescargar);
	btnDescargar.addActionListener(controlador.getBotonDescargar());
	
	final JButton btnCargar = new JButton("Cargar");
	btnCargar.setFont(new Font("Dialog", Font.PLAIN, 20));
	btnCargar.setBounds(150, 318, 120, 80);
	contentPane.add(btnCargar);
	btnCargar.addActionListener(controlador.getBotonCargar());
	
	JButton btnMover = new JButton("Mover");
	btnMover.setFont(new Font("ComicSans", Font.PLAIN,20));
	btnMover.setBounds(150, 58, 120, 80);
	btnMover.addActionListener(controlador.getBotonMover());
	contentPane.add(btnMover);
		
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
	lblNewLabel.setBounds(0, 0, 500, 500);
	contentPane.add(lblNewLabel);
	
	}
}