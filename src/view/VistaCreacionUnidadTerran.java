package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorUnidadTerran;
import fiuba.algo3.tp2.juego.Usuario;

public class VistaCreacionUnidadTerran extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario user;
	private ControladorUnidadTerran controladorUnidad;

	
	public VistaCreacionUnidadTerran(Usuario user){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 0, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		this.user = user;
		controladorUnidad = new ControladorUnidadTerran(user);
		
		JButton btnMarine = new JButton("Marine");
		btnMarine.setBounds(0, 0, 100, 100);
		contentPane.add(btnMarine);
		btnMarine.addActionListener(controladorUnidad.getBotonBarraca());
		
		JButton btnGolliat = new JButton("Golliat");
		btnGolliat.setBounds(200, 0, 100, 100);
		contentPane.add(btnGolliat);
		btnGolliat.addActionListener(controladorUnidad.getBotonFabrica());
		
		JButton btnEspectro = new JButton("Espectro");
		btnEspectro.setBounds(0, 200, 100, 100);
		contentPane.add(btnEspectro);
		btnEspectro.addActionListener(controladorUnidad.getBotonPuertoEstelarEspectro());
		
		JButton btnNaveTransporte = new JButton("Nave Transporte");
		btnNaveTransporte.setBounds(200, 200, 100, 100);
		contentPane.add(btnNaveTransporte);
		btnNaveTransporte.addActionListener(controladorUnidad.getBotonPuertoEstelarNaveTransporte());
		
		JButton btnNaveCiencia = new JButton("Nave Ciencia");
		btnNaveCiencia.setBounds(0, 400, 100, 100);
		contentPane.add(btnNaveCiencia);
		btnNaveCiencia.addActionListener(controladorUnidad.getBotonPuertoEstelarNaveCiencia());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 500, 500);
		contentPane.add(lblNewLabel);
	}
}
