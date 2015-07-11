package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class JuegoCraft extends Observable {
	
	final int MINERAL_INICIAL = 1000;
	final int VESPENO_INICIAL = 1000;
	private Mapa mapa;
	private Turno turno;
	private List<Jugador> jugadores = new ArrayList<Jugador> ();
	private AccionesPosibles acciones;
	
	public List<Jugador> jugadores() {
		return jugadores;
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
		
		RecursosDelJugador recursosIniciales = new RecursosDelJugador(MINERAL_INICIAL, VESPENO_INICIAL);
		
		turno = new Turno(jugadores);
		
		acciones.colocarEnTierra().realizar(new Posicion(1,1), jugadores.get(0).edificioCentral());
		if (jugadores.size() == 2)
			acciones.colocarEnTierra().realizar(new Posicion(mapa.tamanio().enX()-2 , mapa.tamanio().enY()-2), jugadores.get(1).edificioCentral());
		
		for(int i = 0; i< jugadores.size(); i++)
			jugadores.get(i).recursos().agregar(recursosIniciales);
		
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
		
		acciones.colocarEnSuelo().colocarTerrenoEnTodoElMapa();
		
		
		acciones.colocarEnSuelo().colocarTerrenoEnTodoElMapa();
		acciones.colocarEnSuelo().colocarRecurso(new Posicion(1, mapa.tamanio().enY()), new RecursoMineral(1000));
		acciones.colocarEnSuelo().colocarRecurso(new Posicion(mapa.tamanio().enX(), 1), new RecursoGasVespeno(1000));
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
	
	public void construirEdificio(Jugador jugador, Edificio edificio, Posicion posicion) {
		
		EdificioEnConstruccion edificioEnConstruccion = edificio.enConstruccion();
	
		acciones.colocarEnTierra().realizar(posicion,edificioEnConstruccion);
		jugador.agregarEdificioEnConstruccion(edificioEnConstruccion);		
	}
	
	public void colocarEdificio(Jugador jugador, Edificio edificio, Posicion posicion) {
	
		acciones.removerDeSuelo().edificio(posicion, edificio.tamanio());
		acciones.colocarEnTierra().realizar(posicion, edificio);
		jugador.agregarEdificio(edificio);		
	}

	public void colocarUnidad(Jugador jugador, EdificioDeUnidades edificio,	Unidad unidad) {
		
		Posicion posicionParaUnidad; 
			
		if(unidad instanceof UnidadTerrestre){
			
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadTerrestre(edificio.posicion());
			acciones.colocarEnTierra().realizar(posicionParaUnidad, (UnidadTerrestre)unidad);
		}			
		else{
			posicionParaUnidad = acciones.preguntar().encontrarPosicionParaUnidadAerea(edificio.posicion());
			acciones.colocarEnAire().realizar(posicionParaUnidad,(UnidadAerea) unidad);
		}			
	}
	
	public void moverUnidad(Jugador jugador, Unidad unidad, Posicion posicionDestino) {
		
		if(unidad instanceof UnidadTerrestre)
			acciones.moverTerrestre().realizar(posicionDestino, (UnidadTerrestre) unidad);
		else
			acciones.moverAerea().realizar(posicionDestino, (UnidadAerea) unidad); 
	}
	
	public void atacarTierra(Jugador jugador, Unidad unidadAtacante,Posicion posicionDestino) {
		acciones.atacarTierra().realizar(posicionDestino, unidadAtacante);
	}

	public void atacarAire(Jugador jugador, Unidad unidadAtacante, Posicion posicionDestino) {
		acciones.atacarAire().realizar(posicionDestino, unidadAtacante);
	}

	public void cargarUnidad(Jugador jugador, UnidadTransporte transporte, UnidadTerrestre unidadACargar) {
		
		if(transporte.tieneLugar(unidadACargar.ocupacionTransporte()) && (transporte.posicion().equals(unidadACargar.posicion()))){
			transporte.cargar(unidadACargar);
			acciones.removerDeSuelo().edificio(unidadACargar.posicion());
		}
	}

	public void descargarUnidad(Jugador jugador, UnidadTransporte transporte) {
		
		UnidadTerrestre unidad = transporte.descargarUnidad();
		acciones.colocarEnTierra().realizar(transporte.posicion(), unidad);
		
	}	
}