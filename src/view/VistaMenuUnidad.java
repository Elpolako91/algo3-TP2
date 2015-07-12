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

import controller.ControladorAtaque;
import fiuba.algo3.tp2.JuegoCraft;

public class VistaMenuUnidad extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private ControladorAtaque controlador;

	
	public VistaMenuUnidad(JuegoCraft modelo){
		
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(700, 600, 500, 500);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	this.modelo = modelo;
	controlador = new ControladorAtaque(modelo);
	
	final JButton btnAire = new JButton("Aire");
	btnAire.setFont(new Font("ComicSans",Font.PLAIN,15));
	btnAire.setBounds(0, 70, 100, 50);
	contentPane.add(btnAire);
	btnAire.setVisible(false);
	btnAire.addActionListener(controlador.getBotonAtaqueAire());
	
	final JButton btnTierra = new JButton("Tierra");
	btnTierra.setFont(new Font("ComicSans",Font.PLAIN,15));
	btnTierra.setBounds(300, 70, 100, 50);
	contentPane.add(btnTierra);
	btnTierra.setVisible(false);
	btnTierra.addActionListener(controlador.getBotonAtaqueTierra());
	
	JButton btnAtacar = new JButton("Atacar");
	btnAtacar.setFont(new Font("ComicSans",Font.PLAIN,20));
	btnAtacar.setBounds(150, 0, 120, 80);
	contentPane.add(btnAtacar);
	btnAtacar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnAire.setVisible(true);
			btnTierra.setVisible(true);
		}
	});
	
	final JButton btnMoverTierra = new JButton("Tierra");
	btnMoverTierra.setFont(new Font("ComicSans", Font.PLAIN,15));
	btnMoverTierra.setBounds(0, 320, 100, 50);
	btnMoverTierra.addActionListener(controlador.getBotonMoverTerrestre());
	btnMoverTierra.setVisible(false);
	contentPane.add(btnMoverTierra);
	
	final JButton btnMoverAire = new JButton("Aire");
	btnMoverAire.setFont(new Font("ComicSans", Font.PLAIN,15));
	btnMoverAire.setBounds(300, 320, 100, 50);
	btnMoverAire.addActionListener(controlador.getBotonMoverAire());
	btnMoverAire.setVisible(false);
	contentPane.add(btnMoverAire);
	
	
	JButton btnMover = new JButton("Mover");
	btnMover.setFont(new Font("ComicSans", Font.PLAIN,20));
	btnMover.setBounds(150, 220, 120, 80);
	btnMover.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			btnMoverAire.setVisible(true);
			btnMoverTierra.setVisible(true);
		}
	});
	contentPane.add(btnMover);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaConstruccion.class.getResource("/imagenes/posiblefondo.jpg")));
	lblNewLabel.setBounds(0, 0, 500, 500);
	contentPane.add(lblNewLabel);
	
	}
}