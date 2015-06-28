package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class JuegoCraft extends Observable {
	
	private Mapa mapa;
	private Turno turno;
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private AccionesPosibles acciones;
	
	public int jugadores() {
		return jugadores.size();
	}
	
	private boolean sePuedeCargarJugador(String unNombre, String unColor){
		
		boolean cargarJugador = true;
		
		for(int i = 0; i< jugadores.size(); i++){
			
			Jugador jugadorActual = jugadores.get(i);
			if ((jugadorActual.nombre() == unNombre) || (jugadorActual.color() == unColor))
				cargarJugador = false;			
		}		
		return cargarJugador;
	}
	
	public Jugador cargarJugador(String unNombre, String unColor, String unaRaza) {
		
		if (this.sePuedeCargarJugador(unNombre, unColor)){
			
			Jugador jugador = new Jugador(unNombre, unColor, unaRaza);
			jugador.juego(this);
			jugadores.add(jugador);
			return jugador;
		}
		else
			return null;
	}

	public void iniciarPartida() {
		
		RecursosDelJugador recursosIniciales = new RecursosDelJugador(1000,1000);
		
		turno = new Turno(jugadores);
		
		for(int i = 0; i< jugadores.size(); i++){
			
			acciones.colocar().colocarEdificioEdificioCentral(jugadores.get(i).edificioCentral());
			jugadores.get(i).recursos().agregar(recursosIniciales);
		}
	}

	public Mapa mapa(){
		return this.mapa;
	}

	public Jugador turno() {
		return turno.turnoActual();
	}

	public void cargarMapa(Mapa unMapa) {
		mapa = unMapa;
		acciones = new AccionesPosibles(unMapa);
		
		acciones.colocar().colocarTerrenoEnTodoElMapa();
		acciones.colocar().colocarRecurso(new Posicion(1, mapa.tamanio().enY()), new RecursoMineral(1000));
		acciones.colocar().colocarRecurso(new Posicion(mapa.tamanio().enX(), 1), new RecursoGasVespeno(1000));
	}
	
	public void pasarTurno(Jugador jugador) {
		if(turno.turnoActual() == jugador){
			
			jugador.progresoPorTurno();
			jugador.edificiosProgresoConstruccion();			
			
			turno.pasarTurno();
		}
		this.actualizarObservadores();
			
	}
	
	private void actualizarObservadores() {
		setChanged();
		notifyObservers();		
	}

	public void colocarEdificio(Jugador jugador, Edificio edificio, Posicion posicion) {
		
		if((edificio instanceof EdificioRecolectorDeMineral) && (acciones.colocar().colocarRecolectorDeMineral(posicion, (EdificioRecolectorDeMineral) edificio)))	
			jugador.agregarEdificioEnConstruccion(edificio);
		
		if(edificio instanceof EdificioRecolectorDeMineral)
			return;
		
		if((edificio instanceof EdificioRecolectorDeVespeno) && (acciones.colocar().colocarRecolectorDeGasVespeno(posicion, (EdificioRecolectorDeVespeno) edificio)))	
			jugador.agregarEdificioEnConstruccion(edificio);
		
		if(edificio instanceof EdificioRecolectorDeVespeno)
			return;
			
		if(acciones.colocar().colocarEdificio(posicion, edificio))
			jugador.agregarEdificioEnConstruccion(edificio);		
	}

	public void colocarUnidad(Jugador jugador, EdificioDeUnidades edificio,	Unidad unidad) {
		
		Posicion posicionParaUnidad; 
			
		if(unidad instanceof UnidadTerrestre){
			
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadTerrestre(edificio.posicion());
			acciones.colocar().colocarUnidadTerrestre(posicionParaUnidad, (UnidadTerrestre)unidad);
		}			
		else{
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadAerea(edificio.posicion());
			acciones.colocar().colocarUnidadAerea(posicionParaUnidad,(UnidadAerea) unidad);
		}
			
			
	}
	
	public void moverUnidad(Jugador jugador, Unidad unidad, Posicion posicionDestino) {
		
		if(unidad instanceof UnidadTerrestre)
			acciones.mover().moverUnidadTerrestre(posicionDestino, (UnidadTerrestre) unidad);
		else
			acciones.mover().moverUnidadAerea(posicionDestino, (UnidadAerea) unidad); 
	}
	
	public void atacarTierra(Jugador jugador, Unidad unidadAtacante,Posicion posicionDestino) {
		acciones.atacar().atacarTierra(posicionDestino, unidadAtacante);
	}

	public void atacarAire(Jugador jugador, Unidad unidadAtacante, Posicion posicionDestino) {
		acciones.atacar().atacarAire(posicionDestino, unidadAtacante);
	}	
}