package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadEnemigaSeleccionada;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.juego.Usuario;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Vacio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public class ControladorMouseVistaMapa extends MouseAdapter {
	
	private Posicion posicion;
	private Object contenido;
	private JButton boton;
	private Usuario user;
	
	public ControladorMouseVistaMapa(Posicion unaPosicion, Usuario user, JButton boton) {
		
		this.posicion = unaPosicion;
		this.user = user;
		this.boton = boton;
	}
	
	public void mousePressed (MouseEvent e){
				
		boton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		if( user.getColocarEdificio() ){
			
			try {
				user.colocarEdificio((Edificio) user.edificioAConstruir(), posicion);
				user.edificioAConstruir(null);
				user.colocarEdificio(false);
			} catch (PosicionInvalida e1) {			}
		}else{
			if ( user.getAccionAtacarAire()){
		
				try {
					user.atacarAire((Unidad)user.objetoSeleccionado(), posicion);		
				} catch (PosicionInvalida | UnidadEnemigaSeleccionada | UnidadMovimientoTerminado e1) {
					e1.printStackTrace();
				}
				user.accionAtacarAire(false);	
			}else{
				if( user.getAccionAtacarTierra()){
		
					try {
						user.atacarTierra((Unidad) user.objetoSeleccionado(), posicion);
					} catch (PosicionInvalida | UnidadEnemigaSeleccionada | UnidadMovimientoTerminado e1) {}
					user.accionAtacarTierra(false);
					
				}else{
					if( user.getAccionMover()){
						
						try {
							user.moverUnidad((Unidad) user.objetoSeleccionado(), posicion);
						} catch (PosicionInvalida | UnidadEnemigaSeleccionada | UnidadMovimientoTerminado e1) {	}
						user.accionMover(false);
						
					}else{
						if (user.getAccionMover()){
						
							try {
								user.moverUnidad((Unidad) user.objetoSeleccionado(), posicion);
							} catch (PosicionInvalida | UnidadEnemigaSeleccionada | UnidadMovimientoTerminado e1) {	}
							user.accionMover(false);
							
						}else{
							if (user.getAccionDescargar()){
								
								try {
									user.descargarUnidades(user.getUnidadTransporte(), posicion);
								} catch (PosicionInvalida | UnidadEnemigaSeleccionada e1) {	}
							}else{
								if (user.getAccionCargar()){
									
									try {
										user.cargarUnidad(user.getUnidadTransporte(), posicion);
									} catch (PosicionInvalida | UnidadEnemigaSeleccionada e1) {	}
								}
								Posicion posicion2 = new Posicion(posicion.x(), posicion.y());
									try {
										contenido = user.juego.mapa().contenido(posicion2,user.juego.mapa().aire);
									} catch (PosicionInvalida e1) {}
							
									if( contenido instanceof Vacio){
								
										posicion2 = new Posicion(posicion.x(), posicion.y());
										try {
											contenido = user.juego.mapa().contenido(posicion2, user.juego.mapa().tierra);
										} catch (PosicionInvalida e1) {}
										user.objetoSeleccionado(contenido);
								
									}else{
								
										user.objetoSeleccionado(contenido);

								}
							}
						}
					}
				}
			}
		}
	}
}
