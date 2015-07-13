package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorUnidadProtos;
import fiuba.algo3.tp2.JuegoCraft;

public class VistaCreacionUnidadProtos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private ControladorUnidadProtos controladorUnidad;

	
	public VistaCreacionUnidadProtos(JuegoCraft modelo){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 0, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		this.modelo = modelo;
		controladorUnidad = new ControladorUnidadProtos(modelo);
		
		JButton btnZealot = new JButton("Zealot");
		btnZealot.setBounds(200, 0, 100, 100);
		contentPane.add(btnZealot);
		btnZealot.addActionListener(controladorUnidad.getBotonAccesoZealot());
		
		JButton btnDragon = new JButton("Dragon");
		btnDragon.setBounds(0, 0, 100, 100);
		contentPane.add(btnDragon);
		btnDragon.addActionListener(controladorUnidad.getBotonAccesoDragon());
		
		JButton btnScout = new JButton("Scout");
		btnScout.setBounds(0, 200, 100, 100);
		contentPane.add(btnScout);
		btnScout.addActionListener(controladorUnidad.getBotonPuertoEstelarScout());
		
		JButton btnNaveTransporte = new JButton("Nave Transporte");
		btnNaveTransporte.setBounds(200, 200, 100, 100);
		contentPane.add(btnNaveTransporte);
		btnNaveTransporte.addActionListener(controladorUnidad.getBotonPuertoEstelarNaveTransporte());
		
		JButton btnTemplarios = new JButton("Templarios");
		btnTemplarios.setBounds(0, 400, 100, 100);
		contentPane.add(btnTemplarios);
		btnTemplarios.addActionListener(controladorUnidad.getBotonArchivosTemplarios());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 500, 500);
		contentPane.add(lblNewLabel);
	}
}
