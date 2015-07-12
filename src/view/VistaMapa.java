package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.ControladorMouseTurno;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Mapa;
import fiuba.algo3.tp2.Tamanio;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import javax.swing.ImageIcon;


public class VistaMapa extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private int limiteMapaY = 630;
	private int limiteMapaX = 1200;
	private int cteTamanioBoton = 30;
	private Boton[][] botones;
	private JLabel lblNombreJugador;
	private JLabel lblNombreJugador2;
	private JLabel lblRazaJugador;
	private JLabel lblRazaJugador2;
	private JLabel lblColorJugador;
	private JLabel lblColorJugador2;
	private JTextArea mineralDelJugador;
	private JTextArea mineralDelJugador2;
	private JTextArea gasDelJugador;
	private JTextArea gasDelJugador2;
	private JPanel menuJugador;

	public VistaMapa(final JuegoCraft modelo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1284, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuJugador = new JPanel();
		menuJugador.setBorder(new EmptyBorder(5,5,5,5));
		menuJugador.setBounds(0, 631, 1284, 400);
		menuJugador.setLayout(null);
		contentPane.add(menuJugador);
		
		this.modelo = modelo;		
		this.modelo.cargarMapa(new Mapa(new Tamanio(limiteMapaX/cteTamanioBoton,limiteMapaY/cteTamanioBoton)));
		this.modelo.iniciarPartida();
		botones = new Boton[limiteMapaX][limiteMapaY];
		
		int mineral1 = modelo.jugadores().get(0).recursos().mineral();
		int gas1 = modelo.jugadores().get(0).recursos().vespeno();
		int mineral2 = modelo.jugadores().get(1).recursos().mineral();
		int gas2 = modelo.jugadores().get(1).recursos().vespeno();
		
		JButton turno = new JButton("Pasar Turno");
		turno.setBounds(500, 0, 230, 70);
		turno.setFont(new Font("Tahoma", Font.BOLD, 30));
		menuJugador.add(turno);
		
		lblNombreJugador = new JLabel(modelo.jugadores().get(0).nombre());
		lblNombreJugador.setBounds(0, 0, 200, 50);
		lblNombreJugador.setForeground(Color.ORANGE);
		lblNombreJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuJugador.add(lblNombreJugador);
		
		lblRazaJugador = new JLabel(modelo.jugadores().get(0).raza());
		lblRazaJugador.setBounds(200, 0, 200, 50);
		lblRazaJugador.setForeground(Color.ORANGE);
		lblRazaJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuJugador.add(lblRazaJugador);
		
		lblColorJugador = new JLabel(modelo.jugadores().get(0).color());
		lblColorJugador.setBounds(400, 0, 200, 50);
		lblColorJugador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblColorJugador.setForeground(Color.ORANGE);
		menuJugador.add(lblColorJugador);
		
		lblNombreJugador2 = new JLabel(modelo.jugadores().get(1).nombre());
		lblNombreJugador2.setBounds(0, 0, 200, 50);
		lblNombreJugador2.setForeground(Color.ORANGE);
		lblNombreJugador2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreJugador2.setVisible(false);
		menuJugador.add(lblNombreJugador2);
		
		lblRazaJugador2 = new JLabel(modelo.jugadores().get(1).raza());
		lblRazaJugador2.setBounds(200, 0, 200, 50);
		lblRazaJugador2.setForeground(Color.ORANGE);
		lblRazaJugador2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRazaJugador2.setVisible(false);
		menuJugador.add(lblRazaJugador2);
		
		lblColorJugador2 = new JLabel(modelo.jugadores().get(1).color());
		lblColorJugador2.setBounds(400, 0, 200, 50);
		lblColorJugador2.setForeground(Color.ORANGE);
		lblColorJugador2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblColorJugador2.setVisible(false);
		menuJugador.add(lblColorJugador2);
		
		JLabel lblMineral = new JLabel("Mineral");
		lblMineral.setBounds(780, 0, 200, 50);
		lblMineral.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMineral.setForeground(Color.BLUE);
		menuJugador.add(lblMineral);
		
		JLabel lblGasVespeno = new JLabel("Gas Vespeno");
		lblGasVespeno.setBounds(980, 0, 200, 50);
		lblGasVespeno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGasVespeno.setForeground(Color.BLUE);
		menuJugador.add(lblGasVespeno);
		
		mineralDelJugador = new JTextArea();
		mineralDelJugador.setText(String.valueOf(mineral1));
		mineralDelJugador.setEditable(false);
		mineralDelJugador.setBounds(780, 50, 50, 30);
		mineralDelJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuJugador.add(mineralDelJugador);
		
		gasDelJugador = new JTextArea();
		gasDelJugador.setText(String.valueOf(gas1));
		gasDelJugador.setEditable(false);
		gasDelJugador.setBounds(980, 50, 50, 30);
		gasDelJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuJugador.add(gasDelJugador);
		
		mineralDelJugador2 = new JTextArea();
		mineralDelJugador2.setText(String.valueOf(mineral2));
		mineralDelJugador2.setEditable(false);
		mineralDelJugador2.setVisible(false);
		mineralDelJugador2.setBounds(780, 50, 50, 30);
		mineralDelJugador2.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuJugador.add(mineralDelJugador2);
		
		gasDelJugador2 = new JTextArea();
		gasDelJugador2.setText(String.valueOf(gas2));
		gasDelJugador2.setEditable(false);
		gasDelJugador2.setVisible(false);
		gasDelJugador2.setBounds(980, 50, 50, 30);
		gasDelJugador2.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuJugador.add(gasDelJugador2);
					
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(VistaMapa.class.getResource("/imagenes/posiblefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 1268, 189);
		menuJugador.add(lblNewLabel);
		
		turno.addMouseListener(new ControladorMouseTurno(modelo));
		
		this.cargarVistaMapa(modelo, this);
		this.modelo.addObserver(this);
		
		
	}
	
	
	
	public void update(Observable arg0, Object arg1) {
		
		for (int i = 1; i<limiteMapaX; i = i + cteTamanioBoton){
			for (int j = 1; j<limiteMapaY; j = j + cteTamanioBoton){
				botones[i][j].repintarBoton();
			}
		}
		if(lblNombreJugador.isVisible()){
			
			this.cambiarVisibilidadJugadorUno(false);
			this.cambiarVisibilidadJugadorDos(true);
			
		}else{
			
			this.cambiarVisibilidadJugadorUno(true);
			this.cambiarVisibilidadJugadorDos(false);
		}
		menuJugador.repaint();
	}
	
	
	private void cambiarVisibilidadJugadorDos(boolean b) {
		
		lblNombreJugador2.setVisible(b);
		lblColorJugador2.setVisible(b);
		lblRazaJugador2.setVisible(b);
		mineralDelJugador2.setText(String.valueOf(modelo.turno().recursos().mineral()));
		gasDelJugador2.setText(String.valueOf(modelo.turno().recursos().vespeno()));
	}

	private void cambiarVisibilidadJugadorUno(boolean b) {
			
		lblNombreJugador.setVisible(b);
		lblColorJugador.setVisible(b);
		lblRazaJugador.setVisible(b);
		mineralDelJugador.setText(String.valueOf(modelo.turno().recursos().mineral()));
		gasDelJugador.setText(String.valueOf(modelo.turno().recursos().vespeno()));
	}

	private void cargarVistaMapa(JuegoCraft modelo, VistaMapa vista) {
		
			for(int k = 1 ; k < 3; k ++){
				for (int i = 1; i<limiteMapaX; i = i + cteTamanioBoton){
					for (int j = 1; j<limiteMapaY; j = j + cteTamanioBoton){
						Boton temp = new Boton(i,j,k,modelo, vista);
						botones[i][j] = temp;
						contentPane.add(temp.boton());
				}
			}
		}
	}
}

