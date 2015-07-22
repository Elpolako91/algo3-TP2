package fiuba.algo3.tp2.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.acciones.AccionesPosibles;
import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.NoHayEdificiosTerminados;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadEnemigaSeleccionada;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.*;
import fiuba.algo3.tp2.objetosDelMapa.edificios.*;
import fiuba.algo3.tp2.objetosDelMapa.unidades.*;

public class JuegoCraft extends Observable{
	
	final int MINERAL_INICIAL = 1000;
	final int VESPENO_INICIAL = 1000;
	
	private Mapa mapa;
	private Turno turno;
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private AccionesPosibles acciones;
	
	public List<Jugador> jugadores() {
		return jugadores;
	}
	
	public void cargarJugador(String unNombre, String unColor, String unaRaza) throws CargaJugadorInvalida {
		
		if(this.sePuedeCargarJugador(unNombre, unColor)){
			
			Jugador jugador = new Jugador(unNombre, unColor, unaRaza);			
			jugadores.add(jugador);
		}
		else{
			jugadores = new ArrayList<Jugador> ();
			throw new CargaJugadorInvalida();
		}		
	}
	
	private boolean sePuedeCargarJugador(String unNombre, String unColor) {
		
		if (unNombre.length() < 4)
			return false;			
		
		for(int i = 0; i< jugadores.size(); i++)			
			if ((jugadores.get(i).nombre() == unNombre) || (jugadores.get(i).color() == unColor))
				return false;	
				
		return true;
	}
	
	public void cargarMapa(Mapa unMapa) {
		mapa = unMapa;		
		acciones = new AccionesPosibles(unMapa);
		
		// esto de a continuacion no iria
		acciones.colocarEnSuelo().colocarTerrenoEnTodoElMapa();				
		acciones.colocarEnSuelo().colocarRecurso(new Posicion(1, mapa.tamanio().enY()), new RecursoMineral(1000, new ImageIcon("/imagenes/mineral.jpg")));
		acciones.colocarEnSuelo().colocarRecurso(new Posicion(mapa.tamanio().enX(), 1), new RecursoGasVespeno(1000, new ImageIcon("/imagenes/Gas_vespeno.png")));				
	}
	
	public void iniciarPartida() {

		RecursosDelJugador recursosIniciales = new RecursosDelJugador(MINERAL_INICIAL, VESPENO_INICIAL);
		
		turno = new Turno(jugadores);		
			
		try {
			acciones.colocarEdificio().realizar(new Posicion(1,1), jugadores.get(0).edificioCentral());
			acciones.colocarEdificio().realizar(new Posicion(mapa.tamanio().enX()-2, mapa.tamanio().enY()-2), jugadores.get(1).edificioCentral());
			
		} catch (PosicionInvalida e) {}	
		
		for(int i = 0; i< jugadores.size(); i++)
				jugadores.get(i).recursos().agregar(recursosIniciales);	
	}

	public Jugador jugadorActual() {
		return turno.jugadorActual();
	}

	public void pasarTurno() {
		
		this.jugadorActual().progresoPorTurno();
					
		try {
			while(true){
				
				EnConstruccion edificio = (EnConstruccion) this.jugadorActual().obtenerEdificioTerminado();
				acciones.colocarEdificio().realizar(edificio.posicion(), edificio.edificioTerminado());
				this.jugadorActual().agregarEdificio(edificio.edificioTerminado());				
			}			
		} catch (NoHayEdificiosTerminados | PosicionInvalida e) {}
		
		try {
			while (true){				
						
				Unidad unidad = (Unidad) this.jugadorActual().obtenerUnidadTerminada();
				
				Posicion posicionParaUnidad; 
			
				if(unidad instanceof UnidadTerrestre)			
					posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadTerrestre(unidad.posicion());				
				else
					posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadAerea(unidad.posicion());
			
				acciones.colocarUnidad().realizar(posicionParaUnidad, unidad);
				this.jugadorActual().agregarUnidad(unidad);
		
			}
		} catch (NoHayEdificiosTerminados | PosicionInvalida e) {}
		
		turno.pasarTurno();
		
		this.actualizarObservadores();
	}

	public void colocarEdificio(Edificio edificio, Posicion posicion) throws PosicionInvalida {
		
		EnConstruccion edificioEnConstruccion = edificio.enConstruccion();
		
		acciones.colocarEdificio().realizar(posicion, edificioEnConstruccion);
		this.jugadorActual().agregarEdificioEnConstruccion(edificioEnConstruccion);		
	}

	public void moverUnidad(Unidad unidad, Posicion posicion) throws UnidadEnemigaSeleccionada, PosicionInvalida, UnidadMovimientoTerminado {
		
		if(turno.jugadorActual().contieneUnidad(unidad))
			acciones.mover().realizar(posicion, unidad);
		else
			throw new UnidadEnemigaSeleccionada();
		
	}

	public void atacarTierra(Unidad unidadAtacante, Posicion posicion) throws PosicionInvalida, UnidadMovimientoTerminado, UnidadEnemigaSeleccionada {
		
		if(turno.jugadorActual().contieneUnidad(unidadAtacante))
			acciones.atacarTierra().realizar(posicion, unidadAtacante);
		else
			throw new UnidadEnemigaSeleccionada();
		
	}

	public void atacarAire(Unidad unidadAtacante, Posicion posicion) throws PosicionInvalida, UnidadMovimientoTerminado, UnidadEnemigaSeleccionada {
		
		if(turno.jugadorActual().contieneUnidad(unidadAtacante))
			acciones.atacarAire().realizar(posicion, unidadAtacante);
		else
			throw new UnidadEnemigaSeleccionada();
		
	}

	public void cargarUnidad(UnidadTransporte transporte, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada {
		
		if(turno.jugadorActual().contieneUnidad(transporte)){
			acciones.cargar().realizar(posicion, transporte);
		}
		else
			throw new UnidadEnemigaSeleccionada();
		
	}

	public void descargarUnidad(UnidadTransporte transporte, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada {
		
		if(turno.jugadorActual().contieneUnidad(transporte)){
			acciones.descargar().realizar(posicion, transporte);			
		}
		else
			throw new UnidadEnemigaSeleccionada();
		
	}
	
	public void actualizarObservadores() {
		setChanged();
		notifyObservers();		
	}

	/************ a eliminar!!!!! *//////
	public Mapa mapa() {
		return mapa;
	}
}
