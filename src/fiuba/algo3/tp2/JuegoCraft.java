package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class JuegoCraft {
	
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
		turno = new Turno(jugadores);
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
	}
	
	public void pasarTurno(Jugador jugador) {
		if(turno.turnoActual() == jugador)
			turno.pasarTurno();		
	}
	
	public void colocarEdificio(Jugador jugador, EdificioTerran edificio, Posicion posicion) {
		
		if((turno.turnoActual() == jugador) && (acciones.colocar().colocarEdificio(posicion, edificio)))			
			jugador.agregarEdificio(edificio);		
	}

	public void colocarUnidad(Jugador jugador, EdificioTerran edificio) {
		
		Posicion posicionEncontrada = mapa.encontrarPosicionParaUnidad(edificio.posicion()); //este metodo esta en Mapa, falta refactorizar
		UnidadTerran unidad = ((EdificioBarraca) edificio).construirUnidad();		// este metodo deberia recibir un edificio con interface para contruir unidades
		
		if((turno.turnoActual() == jugador) && (acciones.colocar().colocarUnidadTerrestre(posicionEncontrada, unidad)))
			jugador.agregarUnidad(unidad);		
	}

	/*********** Desde Aca Falta Hacer/Refactorizar *****************/
	
	public void atacar(Jugador jugador, UnidadTerran unidadAtacante,
			Posicion posicionDestino) {
		
		// TODO Auto-generated method stub
		
	}

	public void moverUnidad(Jugador jugador, UnidadTerran unidad,
			Posicion posicionDestino) {
		// TODO Auto-generated method stub
		
	}


	
	/*
	public boolean colocarUnidad(UnidadTerran unaUnidad, EdificioTerran unEdificio) {
		Posicion posicionUnidad = mapa.encontrarPosicionParaUnidad(unEdificio.posicion());
		unaUnidad.posicion(posicionUnidad);
		mapa.colocarObjeto(unaUnidad, posicionUnidad);
		return true;
	}

	public void atacar(Jugador jugadorAtacante,UnidadTerran unidadAtacante, Posicion posicionDestino) {
		if(unidadAtacante.posicion().distancia(posicionDestino)<= unidadAtacante.rango()&&((mapa.hayUnidad(posicionDestino))||(mapa.hayEdificio(posicionDestino)))){
			UnidadTerran unidadAtacada = (UnidadTerran) mapa.contenido(posicionDestino);
			unidadAtacada.disminuirVida(unidadAtacante.danioTierra());
			if (unidadAtacada.estaDestruido()){
				mapa.colocarTerreno(posicionDestino);
				Jugador jugadorAtacado = this.jugadorEnemigo(jugadorAtacante);
				jugadorAtacado.eliminarUnidad(unidadAtacada);					//ACA DEBE IR UNIDADES DEL ENEMIG
			}
		}
	}

	private Jugador jugadorEnemigo(Jugador jugadorAtacante) {
		if(jugadorAtacante == jugador1) 
			return jugador2;
		else
			return jugador1;
	}
	*/
	
}