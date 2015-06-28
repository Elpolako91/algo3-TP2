package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorEdificio;
import controller.ControladorMouseTurno;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Mapa;
import fiuba.algo3.tp2.Tamanio;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;


public class VistaMapa extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private int limiteMapaY = 630;
	private int limiteMapaX = 1200;
	private int cteTamanioBoton = 30;
	private Boton[][] botones;
	private ControladorEdificio controlador;

	public VistaMapa(final JuegoCraft modelo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1284, 858);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controlador = new ControladorEdificio(modelo);
		this.modelo = modelo;		
		this.modelo.cargarMapa(new Mapa(new Tamanio(limiteMapaX/cteTamanioBoton,limiteMapaY/cteTamanioBoton)));
		this.modelo.iniciarPartida();
		botones = new Boton[limiteMapaX][limiteMapaY];
		
		JButton turno = new JButton("Pasar Turno");
		turno.setBounds(1011, 707, 221, 69);
		contentPane.add(turno);
		turno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton botonBarraca = new JButton("Barraca");
		botonBarraca.setBounds(216, 665, 138, 32);
		contentPane.add(botonBarraca);
		botonBarraca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonBarraca.setVisible(false);
		botonBarraca.addActionListener(controlador.getBotonBarraca());
		
		JButton btnCentroMineral = new JButton("Centro Mineral");
		btnCentroMineral.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCentroMineral.setBounds(216, 707, 138, 32);
		contentPane.add(btnCentroMineral);
		btnCentroMineral.setVisible(false);
		btnCentroMineral.addActionListener(controlador.getBotonCentroMineral());
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeposito.setBounds(216, 750, 138, 32);
		contentPane.add(btnDeposito);
		btnDeposito.setVisible(false);
		btnDeposito.addActionListener(controlador.getBotonDeposito());
		
		JButton btnFabrica = new JButton("Fabrica");
		btnFabrica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFabrica.setBounds(389, 665, 138, 32);
		contentPane.add(btnFabrica);
		btnFabrica.setVisible(false);
		btnFabrica.addActionListener(controlador.getBotonFabrica());
		
		JButton btnPuertoEstelar = new JButton("Puerto Estelar");
		btnPuertoEstelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPuertoEstelar.setBounds(389, 707, 138, 32);
		contentPane.add(btnPuertoEstelar);
		btnPuertoEstelar.setVisible(false);
		btnPuertoEstelar.addActionListener(controlador.getBotonPuertoEstelar());
		
		JButton btnRefineria = new JButton("Refineria");
		btnRefineria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRefineria.setBounds(389, 750, 138, 32);
		contentPane.add(btnRefineria);
		btnRefineria.setVisible(false);
		btnRefineria.addActionListener(controlador.getBotonFabrica());
		
		JButton btnNewButton = new JButton("Construir");
		btnNewButton.setBounds(45, 698, 122, 70);
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaMapa.class.getResource("/imagenes/espacio.jpg")));
		lblNewLabel.setBounds(0, 631, 1268, 189);
		contentPane.add(lblNewLabel);
		
		turno.addMouseListener(new ControladorMouseTurno(modelo));
		
		this.cargarVistaMapa(modelo, Color.BLUE, this);
		this.modelo.addObserver(this); 
	}
	
	
	
	public void update(Observable arg0, Object arg1) {
		
		for (int i = 1; i<limiteMapaX; i = i + cteTamanioBoton){
			for (int j = 1; j<limiteMapaY; j = j + cteTamanioBoton){
				botones[i][j].repintarBoton();
			}
		}
	}
	
	private void cargarVistaMapa(JuegoCraft modelo, Color color, VistaMapa vista) {
		
			for(int k = 1 ; k < 3; k ++){
				for (int i = 1; i<limiteMapaX; i = i + cteTamanioBoton){
					for (int j = 1; j<limiteMapaY; j = j + cteTamanioBoton){
						Boton temp = new Boton(i,j,k,modelo,color, vista);
						botones[i][j] = temp;
						contentPane.add(temp.boton());
				}
			}
		}
	}
}

