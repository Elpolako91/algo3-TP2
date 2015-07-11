package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
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

	public VistaMapa(final JuegoCraft modelo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1284, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.modelo = modelo;		
		this.modelo.cargarMapa(new Mapa(new Tamanio(limiteMapaX/cteTamanioBoton,limiteMapaY/cteTamanioBoton)));
		this.modelo.iniciarPartida();
		botones = new Boton[limiteMapaX][limiteMapaY];
		
		JButton turno = new JButton("Pasar Turno");
		turno.setBounds(550, 650, 221, 69);
		contentPane.add(turno);
		turno.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblNombreJugador = new JLabel(modelo.turno().nombre());
		lblNombreJugador.setBounds(0, 600, 300, 100);
		contentPane.add(lblNombreJugador);
		
		lblNombreJugador2 = new JLabel(modelo.jugadores().get(1).nombre());
		lblNombreJugador2.setBounds(0, 600, 300, 100);
		lblNombreJugador2.setVisible(false);
		contentPane.add(lblNombreJugador2);
					
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaMapa.class.getResource("/imagenes/posiblefondo.jpg")));
		lblNewLabel.setBounds(0, 631, 1268, 189);
		contentPane.add(lblNewLabel);
		
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
/*		java.awt.Window win[] = getFrames();
		for (int i = 1; i <win.length; i++){
			win[i].dispose();			
		}*/
		
/*		if (lblNombreJugador.isVisible()) {
			
			lblNombreJugador.setVisible(false);
			lblNombreJugador2.setVisible(true);
			
		}else{
			
			lblNombreJugador.setVisible(true);
			lblNombreJugador2.setVisible(false);

		}*/
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

