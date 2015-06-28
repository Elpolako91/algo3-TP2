package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.ControladorMouseVistaMapa;
import fiuba.algo3.tp2.AccionPreguntar;
import fiuba.algo3.tp2.JuegoCraft;
import fiuba.algo3.tp2.Posicion;

public class Boton {
	
	private Posicion posicion;
	private JButton boton;
	JuegoCraft modelo;

	public Boton(int x, int y,int k, JuegoCraft modelo, Color color, VistaMapa vista){
		
		posicion = new Posicion(x/30+1,y/30+1);
		this.modelo = modelo;
		AccionPreguntar preguntar = new AccionPreguntar(modelo.mapa());
		boton = new JButton();
		boton.setBounds(x, y, 30, 30);
		if (preguntar.hayTerreno(posicion)){
			boton.setIcon(new ImageIcon(VistaMenuPrincipal.class.getResource("/imagenes/pasto.png")));
		}
		if (preguntar.hayEdificio(posicion)){
			if(modelo.turno().color() == "Azul"){
				boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/edificio.jpg")));
	//			boton.addMouseListener(new ControladorMouseEdificioCentral(modelo));
			}
		}
		if (preguntar.hayMineral(posicion)){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/mineral.jpg")));
		}
		if(preguntar.hayGasVespeno(posicion)){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/Gas_vespeno.png")));
			boton.setHorizontalAlignment(SwingConstants.CENTER);
		}
		boton.addMouseListener(new ControladorMouseVistaMapa(posicion, modelo));
	}

	public JButton boton() {
		
		return boton;
	}
	
	public Posicion posicion(){
		
		return posicion;
	}

	public void repintarBoton() {
		AccionPreguntar preguntar = new AccionPreguntar(modelo.mapa());
		if(preguntar.hayEdificio(posicion)){
			boton.setIcon(new ImageIcon(VistaMenuPrincipal.class.getResource("/imagenes/edificio.jpg")));
		}
		boton.repaint();
	}
}
