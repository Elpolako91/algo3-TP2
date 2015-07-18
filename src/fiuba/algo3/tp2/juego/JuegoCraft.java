package fiuba.algo3.tp2.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fiuba.algo3.tp2.acciones.AccionesPosibles;
import fiuba.algo3.tp2.excepciones.CargaJugadorInvalida;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadEnemigaSeleccionada;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeUnidades;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioEnConstruccion;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTerrestre;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadTransporte;

public class JuegoCraft extends Observable {
	
	final int MINERAL_INICIAL = 1000;
	final int VESPENO_INICIAL = 1000;
	
	private Mapa mapa;
	private Turno turno;
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private AccionesPosibles acciones;
		
	/************************ creacion jugadores ***************************************************/
	
	public List<Jugador> jugadores() {
		return jugadores;
	}
	
	public Jugador cargarJugador(String unNombre, String unColor, String unaRaza) throws CargaJugadorInvalida {
		
		try{
			this.sePuedeCargarJugador(unNombre, unColor);
			Jugador jugador = new Jugador(unNombre, unColor, unaRaza);
			jugador.juego(this);
			jugadores.add(jugador);
			return jugador;
		}
		catch(CargaJugadorInvalida e){
			jugadores = new ArrayList<Jugador> ();
			throw new CargaJugadorInvalida();
		}			
	}
	
	private void sePuedeCargarJugador(String unNombre, String unColor) throws CargaJugadorInvalida{
		
		if (unNombre.length() < 4)
			throw new CargaJugadorInvalida();
		
		for(int i = 0; i< jugadores.size(); i++){
			
			Jugador jugadorActual = jugadores.get(i);
			if ((jugadorActual.nombre() == unNombre) || (jugadorActual.color() == unColor))
				throw new CargaJugadorInvalida();	
		}		
	}
	
	public void cargarMapa(Mapa unMapa) {
		
		mapa = unMapa;
		acciones = new AccionesPosibles(unMapa);
		
		acciones.colocarEnSuelo().colocarTerrenoEnTodoElMapa();
				
		acciones.colocarEnSuelo().colocarTerrenoEnTodoElMapa();
		try {
			acciones.colocarEnSuelo().colocarRecurso(new Posicion(1, mapa.tamanio().enY()), new RecursoMineral(1000));
			acciones.colocarEnSuelo().colocarRecurso(new Posicion(mapa.tamanio().enX(), 1), new RecursoGasVespeno(1000));
			
		} catch (PosicionInvalida e) {}		
	}	
	
	public void iniciarPartida() {
		
		RecursosDelJugador recursosIniciales = new RecursosDelJugador(MINERAL_INICIAL, VESPENO_INICIAL);
		
		turno = new Turno(jugadores);
		
		try {
			acciones.colocarEdificio().realizar(new Posicion(1,1), jugadores.get(0).edificioCentral());
			
			if (jugadores.size() == 2)
				acciones.colocarEdificio().realizar(new Posicion(mapa.tamanio().enX()-2 , mapa.tamanio().enY()-2), jugadores.get(1).edificioCentral());
			
			for(int i = 0; i< jugadores.size(); i++)
				jugadores.get(i).recursos().agregar(recursosIniciales);
			
		} catch (PosicionInvalida e) {}		
	}

	public Mapa mapa(){
		return this.mapa;
	}

	public Jugador jugadorActual() {
		return turno.jugadorActual();
	}
	
	public void pasarTurno() {
		
		try {
			turno.jugadorActual().progresoPorTurno();
			turno.jugadorActual().edificiosProgresoConstruccion();
			
		} catch (PosicionInvalida e) {}		
		
		turno.pasarTurno();
		
		this.actualizarObservadores();
	}
	
	public void colocarEdificio(Edificio edificio, Posicion posicion) throws PosicionInvalida {
		
		EdificioEnConstruccion edificioEnConstruccion = edificio.enConstruccion();
	
		acciones.colocarEdificio().realizar(posicion,edificioEnConstruccion);
		this.jugadorActual().agregarEdificioEnConstruccion(edificioEnConstruccion);		
	}
	
	public void moverUnidad(Unidad unidad, Posicion posicionDestino) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado {
		
		if(turno.jugadorActual().contieneUnidad(unidad))
			acciones.mover().realizar(posicionDestino, unidad);
		else
			throw new UnidadEnemigaSeleccionada();
	}
	
	public void atacarTierra(Unidad unidadAtacante,Posicion posicionDestino) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado {
		
		if(turno.jugadorActual().contieneUnidad(unidadAtacante))
			acciones.atacarTierra().realizar(posicionDestino, unidadAtacante);
		else
			throw new UnidadEnemigaSeleccionada();
	}

	public void atacarAire(Unidad unidadAtacante, Posicion posicionDestino) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado {
		
		if(turno.jugadorActual().contieneUnidad(unidadAtacante))
			acciones.atacarAire().realizar(posicionDestino, unidadAtacante);
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
	
	/************* privado ***********************/
	
	private void actualizarObservadores() {
		setChanged();
		notifyObservers();		
	}
		
	/************** viejo  para actualizar construccion terminada *********************/
	
	public void colocarEdificio(Jugador jugador, Edificio edificio, Posicion posicion) throws PosicionInvalida {
	
		mapa.removerObjeto(posicion, mapa.tierra, edificio.tamanio());	//realizar accionRemover
		acciones.colocarEdificio().realizar(posicion, edificio);
		jugador.agregarEdificio(edificio);		
	}

	public void colocarUnidad(Jugador jugador, EdificioDeUnidades edificio,	Unidad unidad) throws PosicionInvalida {
		
		Posicion posicionParaUnidad; 
			
		if(unidad instanceof UnidadTerrestre)			
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadTerrestre(edificio.posicion());				
		else
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadAerea(edificio.posicion());
			
		acciones.colocarUnidad().realizar(posicionParaUnidad, unidad);
	}	
}