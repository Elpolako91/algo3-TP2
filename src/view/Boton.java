package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.ControladorCreadorUnidades;
import controller.ControladorEdificioCentral;
import controller.ControladorMenuUnidad;
import controller.ControladorMouseVistaMapa;
import fiuba.algo3.tp2.AccionPreguntar;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Posicion;

public class Boton {
	
	private Posicion posicion;
	private JButton boton;
	JuegoCraft modelo;
	private ImageIcon pasto = new ImageIcon(Boton.class.getResource("/imagenes/pasto.png"));
	private ImageIcon edificio = new ImageIcon(Boton.class.getResource("/imagenes/edificio.jpg"));
	private ImageIcon mineral = new ImageIcon(Boton.class.getResource("/imagenes/mineral.jpg"));
	private ImageIcon gas = new ImageIcon(Boton.class.getResource("/imagenes/Gas_vespeno.png"));
	private VistaConstruccion vistaConstruccion;
	private ControladorMouseVistaMapa ml;
	private VistaCreacionUnidad vista1;
	private VistaMenuUnidad vista2;
	
	public Boton(int x, int y,int k, JuegoCraft modelo, VistaMapa vista){
		
		posicion = new Posicion(x/30+1,y/30+1);
		this.modelo = modelo;
		AccionPreguntar preguntar = new AccionPreguntar(modelo.mapa());
		this.vistaConstruccion = new VistaConstruccion(modelo);
		this.vista1 = new VistaCreacionUnidad(modelo);
		this.vista2 = new VistaMenuUnidad(modelo);
		boton = new JButton();
		boton.setBounds(x, y, 30, 30);
		ml = new ControladorMouseVistaMapa(posicion, modelo, boton);
		if (preguntar.hayTerreno(posicion)){
			boton.setIcon(pasto);
		}
		if (preguntar.hayEdificio(posicion)){
				boton.setIcon(edificio);
				boton.addMouseListener(new ControladorEdificioCentral(vistaConstruccion, vista1, vista2));
		}
		if (preguntar.hayMineral(posicion)){
			boton.setIcon(mineral);
		}
		if(preguntar.hayGasVespeno(posicion)){
			boton.setIcon(gas);
		}
		boton.addMouseListener(ml);
	}

	public JButton boton() {
		
		return boton;
	}
	
	public Posicion posicion(){
		
		return posicion;
	}

	public void repintarBoton() {
		AccionPreguntar preguntar = new AccionPreguntar(modelo.mapa());
		
		if (preguntar.hayTerreno(posicion)){
			boton.setIcon(pasto);
		}
		if(preguntar.hayEdificio(posicion)){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/edificio.jpg")));
			boton.addMouseListener(new ControladorCreadorUnidades(modelo,posicion, vista1));
// Si es una edificio ya construido, debo agregarle el comportamiento para la construccion de sus unidades
// ejemplo, si es una Barraca, debe construir Marines.
		}
		if (preguntar.hayUnidadTerrestre(posicion)){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/posiblefondo.jpg")));
			boton.addActionListener(new ControladorMenuUnidad(modelo));
		}
		boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	}
}
