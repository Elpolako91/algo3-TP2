package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.tp2.juego.Usuario;


public class VistaAtributosJugador extends JPanel {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String raza;
	private String color;
	private Usuario user;

	public VistaAtributosJugador(Usuario user) {
		
		this.user = user;
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setBounds(0, 0, 2000, 77);
		setLayout(null);
		
		nombre = this.user.jugadorActual().nombre();
		raza = this.user.jugadorActual().raza();
		color = this.user.jugadorActual().color();
		
		JTextField txtNombreJugador = new JTextField();
		txtNombreJugador.setText(nombre);
		txtNombreJugador.setEditable(false);
		txtNombreJugador.setBounds(10, 5, 118, 25);
		txtNombreJugador.setForeground(Color.ORANGE);
		txtNombreJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(txtNombreJugador);
		
		JTextField txtRazaJugador = new JTextField();
		txtRazaJugador.setText(raza);
		txtRazaJugador.setEditable(false);
		txtRazaJugador.setBounds(138, 5, 118, 25);
		txtRazaJugador.setForeground(Color.ORANGE);
		txtRazaJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(txtRazaJugador);
		
		JTextField txtColorJugador = new JTextField();
		txtColorJugador.setText(color);
		txtColorJugador.setEditable(false);
		txtColorJugador.setBounds(266, 5, 118, 25);
		txtColorJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtColorJugador.setForeground(Color.ORANGE);
		this.add(txtColorJugador);
		
		JTextField txtMineral = new JTextField("Mineral");
		txtMineral.setEditable(false);
		txtMineral.setBounds(780, 5, 82, 25);
		txtMineral.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMineral.setForeground(Color.BLUE);
		this.add(txtMineral);
		
		JTextField txtGasVespeno = new JTextField("Gas Vespeno");
		txtGasVespeno.setEditable(false);
		txtGasVespeno.setBounds(980, 5, 135, 25);
		txtGasVespeno.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtGasVespeno.setForeground(Color.BLUE);
		this.add(txtGasVespeno);
		
		int mineral = this.user.jugadorActual().recursos().mineral();
		int gas = this.user.jugadorActual().recursos().vespeno();

		JTextField mineralDelJugador = new JTextField();
		mineralDelJugador.setEditable(false);
		mineralDelJugador.setText(String.valueOf(mineral));
		mineralDelJugador.setBounds(780, 41, 54, 25);
		mineralDelJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(mineralDelJugador);
		
		JTextField gasDelJugador = new JTextField();
		gasDelJugador.setEditable(false);
		gasDelJugador.setText(String.valueOf(gas));
		gasDelJugador.setBounds(980, 41, 54, 25);
		gasDelJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.add(gasDelJugador);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaMapa.class.getResource("/imagenes/marmol.jpg")));
		lblNewLabel.setBounds(0, 0, 1360, 209);
		this.add(lblNewLabel);
		
	}

}
