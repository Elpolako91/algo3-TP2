package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.ControladorMouseTurno;

import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Tamanio;


public class VistaMapa extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JuegoCraft modelo;
	private int limiteMapaY = 1360;
	private int limiteMapaX = 1360;
	private int cteTamanioBoton = 20;
	private Boton[][] botones;
	private JPanel menuJugador;
	private JPanel mapa;
	private JPanel panelObjetoSeleccionado;
	private JPanel panelAtributosJugador;
	private JScrollPane panel;
	private Usuario user;

	public VistaMapa(final JuegoCraft modelo, Usuario user) 
			
			throws Exception 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1224, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Tamanio tamanio = new Tamanio(limiteMapaX/cteTamanioBoton,limiteMapaY/cteTamanioBoton);
		Mapa map = new Mapa(tamanio);
		this.modelo = modelo;		
		this.modelo.cargarMapa(map);
		this.modelo.iniciarPartida();
		this.user = user;
		
		Sonido musicaFondo = new Sonido("sonido_principal.au");
		musicaFondo.reproducirIndefinidamente();
		
		menuJugador = new JPanel();
		menuJugador.setBorder(new EmptyBorder(5,5,5,5));
		menuJugador.setBounds(0, 504, 1208, 458);
		menuJugador.setLayout(null);
		contentPane.add(menuJugador);

		mapa = new JPanel();
		mapa.setBorder(new EmptyBorder(5,5,5,5));
		mapa.setBounds(0, 0, limiteMapaX, limiteMapaY);
		mapa.setLayout(null);
		
		this.cargarMapa();
		
		JButton turno = new JButton("Pasar Turno");
		turno.setBounds(521, 22, 236, 70);
		turno.setFont(new Font("Tahoma", Font.BOLD, 25));
		menuJugador.add(turno);
		
		panelObjetoSeleccionado = new VistaObjetoSeleccionado(user);
		panelObjetoSeleccionado.setBounds(0, 40, 320, 183);
		menuJugador.add(panelObjetoSeleccionado);
		
		panelAtributosJugador = new VistaAtributosJugador(user);
		panelAtributosJugador.setBounds(0, 0, 2000, 60);
		menuJugador.add(panelAtributosJugador);
					
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VistaMapa.class.getResource("/imagenes/marmol.jpg")));
		lblNewLabel.setBounds(0, 0, 1360, 253);
		menuJugador.add(lblNewLabel);
		
		turno.addMouseListener(new ControladorMouseTurno(user));
		
		panel = new JScrollPane();
		panel.setBounds(0, 0, 1224, 500);
		panel.setViewportView(mapa);
		panel.getViewport().setView(mapa);
		mapa.setPreferredSize(new Dimension(limiteMapaX, limiteMapaY));
		
		contentPane.add(panel);
		
		this.modelo.addObserver(this);
		
	}
	
	
	
	private void cargarMapa() throws PosicionInvalida {
		
		botones = new Boton[limiteMapaX][limiteMapaY];
		for (int i = 1; i<=limiteMapaX; i = i + cteTamanioBoton){
			for (int j = 1; j<=limiteMapaY; j = j + cteTamanioBoton){
				Boton temp = new Boton(i, j, user);
				botones[i][j] = temp;
				mapa.add(botones[i][j].boton());
			}		
		}
		
	}



	public void update(Observable arg0, Object arg1) {
	
		for (int i = 1; i<=limiteMapaX; i = i + cteTamanioBoton){
			for (int j = 1; j<=limiteMapaY; j = j + cteTamanioBoton){
				try {
					botones[i][j].pintarBoton(i, j);
				} catch (PosicionInvalida e) {
					e.printStackTrace();
				}
			}
		}
		
		menuJugador.remove(panelAtributosJugador);
		panelAtributosJugador = new VistaAtributosJugador(user);
		panelAtributosJugador.setBounds(0, 0, 2000, 60);
		menuJugador.add(panelAtributosJugador);

		menuJugador.remove(panelObjetoSeleccionado);
		panelObjetoSeleccionado = new VistaObjetoSeleccionado(user);
		panelObjetoSeleccionado.setBounds(0, 50, 161, 139);
		menuJugador.add(panelObjetoSeleccionado);
		menuJugador.repaint();
	}	
}

