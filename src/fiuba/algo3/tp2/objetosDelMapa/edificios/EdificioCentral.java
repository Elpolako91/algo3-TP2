package fiuba.algo3.tp2.objetosDelMapa.edificios;

import java.util.List;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;


public abstract class EdificioCentral extends Edificio{
	
	final int SUMINISTRO_INICIAL = 5;
	
	private List<Edificio> edificios;
	private RecursosDelJugador recursos;
	private Suministro suministros;
	
	public EdificioCentral(String unNombre, int vida, int escudo, RecursosDelJugador recursosDisponibles,
			Suministro suministrosDisponibles, List<Edificio> edificiosJugador, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, 0, null, new Tamanio(3,3), unaImagen);
		
		edificios = edificiosJugador;
		recursos = recursosDisponibles;
		suministros = suministrosDisponibles;
		suministros.agregar(SUMINISTRO_INICIAL);
	}
	
	public List<Edificio> edificios(){
		return edificios;
	}
	
	public RecursosDelJugador recursosDisponibles(){
		return recursos;
	}
	
	public Suministro suministros(){
		return suministros;
	}
}
