package fiuba.algo3.tp2;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	private JuegoCraft juego;
	private List<EdificioTerran> edificios = new ArrayList<EdificioTerran> ();
	private List<UnidadTerran> unidades = new ArrayList<UnidadTerran> ();
	private RecursoDelJugador recursos;
	private Suministro suministros;
	
	public Jugador(String unNombre, String unColor, String unaRaza) {

		nombre = unNombre;
		color = unColor;
		raza = unaRaza;
		recursos = new RecursoDelJugador(1000,1000);
	}
	
	public String nombre() {		
		return nombre;
	}
	
	public String color() {		
		return color;
	}
	
	public String raza() {		
		return raza;
	}
	
	public RecursoDelJugador recursos() {
		return recursos;
	}
	
	public void juego(JuegoCraft unJuego) {
		juego = unJuego;		
	}
	
	public JuegoCraft juego(){
		return juego;
	}
	
	public int edificios() {		
		return edificios.size();
	}
	
	public int unidades() {		
		return unidades.size();
	}
	
	public void pasarTurno() {
		if(this.esMiTurno())juego.pasarTurno();		
	}
	
	private boolean esMiTurno(){
		if(juego.turno()==this)return true; else return false;
	}
	
	public void colocarEdificio(Posicion posicion, EdificioTerran unEdificio) {
		if(recursos.cantidadSuficiente(unEdificio.costo())){
			if(juego.mapa().colocarEdificio(unEdificio, posicion)){
				recursos.descontar(unEdificio.costo());
				unEdificio.posicion(posicion);
				edificios.add(unEdificio);
			}
		}
	}
	
	public UnidadMarine construirMarine(Barraca unaBarraca){
		UnidadMarine marine= unaBarraca.construirUnidad();
			if (recursos.cantidadSuficiente(marine.costo())){
				recursos.descontar(marine.costo());
				juego.mapa().colocarUnidad(marine, unaBarraca.posicion());
				unidades.add(marine);
				return marine;
			}
		return null;
	}
		
	public void moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		
		for(int i=0; i<30; i++)								//controlar si la unidad tiene movimientos
		juego.mapa().moverUnidad(unidad, posicionDestino);
		
	}
	public void atacar(UnidadTerran unidad,Posicion posicionDestino) {
			if(unidad.posicion().distancia(posicionDestino)<= unidad.rango()){
				juego.mapa().hayUnidad(posicionDestino);
				UnidadTerran unidadAtacada = (UnidadTerran) juego.mapa().contenido(posicionDestino);
				juego.mapa().atacar(unidad, posicionDestino);
				if (unidadAtacada.estaDestruido()){
					juego.mapa().colocarTerreno(posicionDestino);
					unidades.remove(unidadAtacada);					//ACA DEBE IR UNIDADES DEL ENEMIGO ! ! !
				}
			}
		}		
}
