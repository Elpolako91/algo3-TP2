package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.ControladorCreadorUnidades;
import controller.ControladorEdificioCentral;
import controller.ControladorMenuUnidad;
import controller.ControladorMouseVistaMapa;
import controller.ControladorTransporte;
import fiuba.algo3.tp2.acciones.AccionPreguntar;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeUnidades;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadAerea;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

public class Boton {
	
	private Posicion posicion;
	private JButton boton;
	private Usuario user;
	private ImageIcon pasto = new ImageIcon(Boton.class.getResource("/imagenes/pasto.png"));
	private ImageIcon edificio = new ImageIcon(Boton.class.getResource("/imagenes/edificio.jpg"));
	private ImageIcon mineral = new ImageIcon(Boton.class.getResource("/imagenes/mineral.jpg"));
	private ImageIcon gas = new ImageIcon(Boton.class.getResource("/imagenes/Gas_vespeno.png"));
	private ControladorMouseVistaMapa ml;
	private ControladorTransporte controladorTransporte;
	private VistaConstruccionTerran vistaConstruccionTerran;
	private VistaCreacionUnidadTerran vistaUnidadesTerran;
	private VistaConstruccionProtos vistaConstruccionProtos;
	private VistaCreacionUnidadProtos vistaUnidadProtos;
	private VistaMenuUnidad vista2;
	private int cteTamanioBoton = 20;
	
	public Boton(int x, int y, Usuario user) throws PosicionInvalida{
		
		posicion = new Posicion(x/cteTamanioBoton+1,y/cteTamanioBoton+1);
		
		this.user = user;
		this.vistaConstruccionTerran = new VistaConstruccionTerran(user);
		this.vistaUnidadesTerran = new VistaCreacionUnidadTerran(user);
		this.vistaConstruccionProtos = new VistaConstruccionProtos(user);
		this.vistaUnidadProtos = new VistaCreacionUnidadProtos(user);
		this.vista2 = new VistaMenuUnidad(user);
		
		this.controladorTransporte = new ControladorTransporte(user);
		
		boton = new JButton();
		boton.setBounds(x, y, cteTamanioBoton, cteTamanioBoton);
		this.pintarBoton(x, y);
		
		ml = new ControladorMouseVistaMapa(posicion, user, boton);
		boton.addMouseListener(ml);
		
	}

	public JButton boton() {
		
		return boton;
	}
	
	public Posicion posicion(){
		
		return posicion;
	}

	public void pintarBoton(int x, int y) throws PosicionInvalida {
		
		AccionPreguntar preguntar = new AccionPreguntar(user.juego.mapa());
		
		if(preguntar.hayTerreno(posicion)){
			boton.setIcon(pasto);
		}
		if(preguntar.hayEdificio(posicion)){
			Edificio objeto = (Edificio) user.juego.mapa().contenido(posicion, user.juego.mapa().tierra); 
			boton.setIcon(edificio);
			if(objeto instanceof EdificioCentral){
			boton.addMouseListener(new ControladorEdificioCentral(vistaConstruccionTerran, vistaConstruccionProtos, user));		
			}else{
				if(objeto instanceof EdificioDeUnidades){
				boton.addMouseListener(new ControladorCreadorUnidades(user, vistaUnidadesTerran, vistaUnidadProtos));
				}
			}
		}
		if (preguntar.hayUnidadTerrestre(posicion)){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/posiblefondo.jpg")));
			boton.addActionListener(new ControladorMenuUnidad(vista2));
		}
		if (preguntar.hayUnidadAire(posicion)){
			UnidadAerea objeto = (UnidadAerea) user.juego.mapa().contenido(posicion, user.juego.mapa().aire);
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/posiblefondo.jpg")));
			if ( objeto instanceof UnidadTransporte){
				boton.addActionListener(controladorTransporte.getVistaMenuTransporte() );
			}else{
				boton.addActionListener(new ControladorMenuUnidad(vista2));
			}
		}
		if(preguntar.hayMineral(posicion)){
			boton.setIcon(mineral);
		}
		if(preguntar.hayGasVespeno(posicion)){
			boton.setIcon(gas);
		}
		boton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		boton.repaint();
	}	
}
