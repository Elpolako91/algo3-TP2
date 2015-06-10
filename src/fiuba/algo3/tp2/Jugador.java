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
	public List<UnidadTerran> unidades = new ArrayList<UnidadTerran> ();
	
	public Jugador(String unNombre, String unColor, String unaRaza) {

		this.nombre = unNombre;
		this.color = unColor;
		this.raza = unaRaza;
	}
	public String nombre() {
		
		return this.nombre;
	}
	public Object color() {
		
		return this.color;
	}
	public Object raza() {
		
		return this.raza;
	}
	public void juego(JuegoCraft unJuego) {
		this.juego = unJuego;		
	}
	
	public JuegoCraft juego(){
		return juego;
	}
	
	public void colocarEdificio(Posicion posicion, EdificioTerran unEdificio) {
		juego.mapa().colocarEdificio(unEdificio, posicion);
		unEdificio.posicion(posicion);
		edificios.add(unEdificio);
	}
	public void pasarTurno() {
		juego.pasarTurno();		
	}
	
	public UnidadMarine construirMarine(){
		UnidadMarine unidad= null;
		Iterator i= edificios.iterator();
		while(i.hasNext()){
			EdificioTerran edificio= (EdificioTerran)i.next();
			if (edificio instanceof Barraca){
				unidad = ((Barraca)edificio).construirUnidad();
				unidades.add(unidad);
				this.colocarUnidad(edificio.posicion(),unidad);
				
			}
			
		}
		return unidad;
	}
	
	public void colocarUnidad(Posicion edificioPosicion, UnidadTerran unidad) {
		juego.mapa().colocarUnidad(unidad, edificioPosicion);
		
	}
	public int edificios() {		
		return edificios.size();
	}
	public int unidades() {		
		return unidades.size();
	}
	public void moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		
		for(int i=0; i<30; i++)								//controlar si la unidad tiene movimientos
		juego.mapa().moverUnidad(unidad, posicionDestino);
		
	}
}
