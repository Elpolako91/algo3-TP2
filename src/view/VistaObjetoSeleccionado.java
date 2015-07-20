package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;


public class VistaObjetoSeleccionado extends JPanel {

	private static final long serialVersionUID = 1L;
	private int danioTierra = 0;
	private int danioAire = 0;
	private String nombre = "Terreno";
	private int vidaActual = 0;
	private Object contenido;
	private Usuario user;
	private int escudoActual;
	private int vidaMaxima;
	private int escudoMaximo;
	private int suministroGastados;
	private int suministrosTotales;

	
	public VistaObjetoSeleccionado(Usuario user) {
		
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(null);

		this.user = user;
		contenido = user.objetoSeleccionado();
		
		if (contenido instanceof Unidad){
			
			danioTierra = ((Unidad) contenido).danioTierra();
			danioAire = ((Unidad) contenido).danioAire();
			nombre = ((Unidad) contenido).nombre();
			vidaActual = ((Unidad) contenido).vidaActual();
			escudoActual = ((Unidad) contenido).escudoActual();
			vidaMaxima = ((Unidad) contenido).vidaMaxima();
			escudoMaximo = ((Unidad) contenido).escudoMaximo();
			
		}else{
				if(contenido instanceof Edificio){
					nombre = ((Edificio)contenido).nombre();
					vidaActual = ((Edificio)contenido).vidaActual();
					escudoActual = ((Edificio) contenido).escudoActual();
					vidaMaxima = ((Edificio) contenido).vidaMaxima();
					escudoMaximo = ((Edificio) contenido).escudoMaximo();
					suministroGastados = user.jugadorActual().suministros().suministroGastados();
					suministrosTotales = user.jugadorActual().suministros().suministroTotal();
			}
		}
		
		JTextField textnombre = new JTextField();
		textnombre.setHorizontalAlignment(SwingConstants.CENTER);
		textnombre.setBounds(10, 10, 135, 20);
		textnombre.setEditable(false);
		textnombre.setText(nombre);
		this.add(textnombre);
		
		JTextField text1 = new JTextField();
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setBounds(10, 35, 68, 20);
		text1.setEditable(false);
		text1.setText("Vida Total:");
		this.add(text1);

		JTextField textVida = new JTextField();
		textVida.setHorizontalAlignment(SwingConstants.CENTER);
		textVida.setBounds(80, 35, 65, 20);
		textVida.setEditable(false);
		textVida.setText(String.valueOf(vidaActual + "/" + vidaMaxima));
		this.add(textVida);
		
		JTextField text2 = new JTextField();
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setBounds(10, 135, 75, 20);
		text2.setEditable(false);
		text2.setText("Danio Tierra:");
		this.add(text2);
		
		JTextField textDanioTierra = new JTextField();
		textDanioTierra.setHorizontalAlignment(SwingConstants.CENTER);
		textDanioTierra.setBounds(89, 135, 20, 20);
		textDanioTierra.setEditable(false);
		textDanioTierra.setText(String.valueOf(danioTierra));
		this.add(textDanioTierra);
		
		JTextField text3 = new JTextField();
		text3.setHorizontalAlignment(SwingConstants.CENTER);
		text3.setBounds(10, 110, 65, 20);
		text3.setEditable(false);
		text3.setText("Danio Aire:");
		this.add(text3);
		
		JTextField textDanioAire = new JTextField();
		textDanioAire.setHorizontalAlignment(SwingConstants.CENTER);
		textDanioAire.setBounds(79, 109, 20, 20);
		textDanioAire.setEditable(false);
		textDanioAire.setText(String.valueOf(danioAire));
		this.add(textDanioAire);
		
		JTextField txtEscudoActual = new JTextField();
		txtEscudoActual.setHorizontalAlignment(SwingConstants.CENTER);
		txtEscudoActual.setText("Escudo Total:");
		txtEscudoActual.setEditable(false);
		txtEscudoActual.setBounds(10, 60, 83, 20);
		add(txtEscudoActual);
		
		JTextField textEscudo = new JTextField();
		textEscudo.setText("0");
		textEscudo.setHorizontalAlignment(SwingConstants.CENTER);
		textEscudo.setEditable(false);
		textEscudo.setBounds(95, 60, 47, 20);
		textEscudo.setText(String.valueOf(escudoActual+"/"+escudoMaximo));
		add(textEscudo);
		
		JTextField textSuministros = new JTextField();
		textSuministros.setText("Suministros:");
		textSuministros.setHorizontalAlignment(SwingConstants.CENTER);
		textSuministros.setEditable(false);
		textSuministros.setBounds(10, 85, 75, 20);
		add(textSuministros);
		
		JTextField textSuministrosTotales = new JTextField();
		textSuministrosTotales.setText("0");
		textSuministrosTotales.setHorizontalAlignment(SwingConstants.CENTER);
		textSuministrosTotales.setEditable(false);
		textSuministrosTotales.setBounds(95, 85, 47, 20);
		textSuministrosTotales.setText(String.valueOf(suministroGastados+"/"+suministrosTotales));
		add(textSuministrosTotales);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(VistaConstruccionTerran.class.getResource("/imagenes/posiblefondo.jpg")));
		lblNewLabel.setBounds(0, 0, 500, 500);
		this.add(lblNewLabel);

	}
}
