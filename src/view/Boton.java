package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.ControladorCreadorUnidades;
import controller.ControladorEdificioCentral;
import controller.ControladorMenuUnidad;
import controller.ControladorMouseVistaMapa;
import controller.ControladorTransporte;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.juego.JuegoCraft;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeUnidades;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

public class Boton {
	
	private Posicion posicion;
	private JButton boton;
	private Usuario user;
	private ControladorMouseVistaMapa ml;
	private ControladorTransporte controladorTransporte;
	private VistaConstruccionTerran vistaConstruccionTerran;
	private VistaCreacionUnidadTerran vistaUnidadesTerran;
	private VistaConstruccionProtos vistaConstruccionProtos;
	private VistaCreacionUnidadProtos vistaUnidadProtos;
	private VistaMenuUnidad vista2;
	private int cteTamanioBoton = 20;
	private JuegoCraft modelo;
	
	public Boton(int x, int y, Usuario user, JuegoCraft modelo) throws PosicionInvalida{
		
		posicion = new Posicion(x/cteTamanioBoton+1,y/cteTamanioBoton+1);
		
		this.modelo = modelo;
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
		
		ml = new ControladorMouseVistaMapa(posicion, user, this.modelo);
		boton.addMouseListener(ml);
		
	}

	public JButton boton() {
		
		return boton;
	}
	
	public Posicion posicion(){
		
		return posicion;
	}

	public void pintarBoton(int x, int y) throws PosicionInvalida {
		if(! (user.jugadorActual().hayVision(posicion))){
			boton.setIcon(new ImageIcon(Boton.class.getResource("/imagenes/sinVisibilidad.jpg")));
		}
		else{
	
			Object objeto = modelo.mapa().contenidoCapaSuperior(posicion);
			boton.setIcon(((ObjetoDelMapa) objeto).imagen()); 		
 			
 			if(objeto instanceof EdificioCentral){
 				boton.addMouseListener(new ControladorEdificioCentral(vistaConstruccionTerran, vistaConstruccionProtos, user));
 			}else{
 				if (objeto instanceof EdificioDeUnidades){
 					boton.addMouseListener(new ControladorCreadorUnidades(user, vistaUnidadesTerran, vistaUnidadProtos));
 				}else{
 					if (objeto instanceof UnidadTransporte){
 						boton.addActionListener(controladorTransporte.getVistaMenuTransporte() );
 					}else{					
 						if (objeto instanceof Unidad){
 							boton.addActionListener(new ControladorMenuUnidad(vista2));
 						}
 					}
 				}
 			} 			 			
 		}
		
		boton.repaint();
	}
}
