package fiuba.algo3.tp2.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.NoHayObjetosTerminados;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.mapa.Vision;
import fiuba.algo3.tp2.objetosDelMapa.edificios.*;
import fiuba.algo3.tp2.objetosDelMapa.unidades.*;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	
	private Vision vision;
	
	private RecursosDelJugador recursos;
	private Suministro suministros;
	
	private EdificioCentral base;
	private List<Edificio> edificios = new ArrayList<Edificio> ();
	private List<EnConstruccion> edificiosEnConstruccion = new ArrayList<EnConstruccion> ();
	private List<Unidad> unidades = new ArrayList<Unidad> ();
	
	public Jugador(String unNombre, String unColor, String unaRaza) {

		nombre = unNombre;
		color = unColor;
		raza = unaRaza;
		recursos = new RecursosDelJugador();
		suministros = new Suministro();
				
		if ( unaRaza == "terran")
			base = new EdificioCentralTerran(recursos, suministros, edificios);
		
		if (unaRaza == "protos")
			base = new EdificioCentralProtos(recursos, suministros, edificios);	
		
	}
	
	public String nombre() {
		return nombre;
	}
	
	public String color() {
		return color;
	}
	
	public int edificios() {
		return edificios.size();
	}

	public EdificioCentral edificioCentral() {
		return base;
	}

	public RecursosDelJugador recursos() {
		return recursos;
	}

	public void agregarEdificioEnConstruccion(EnConstruccion edificioEnConstruccion) {
		edificiosEnConstruccion.add(edificioEnConstruccion);
		this.descubrir(edificioEnConstruccion.posicion(), edificioEnConstruccion.vision());
	}

	public void progresoPorTurno() {
		
		for(int i = 0; i < edificiosEnConstruccion.size(); i++){
			
			EnConstruccion edificioActual = edificiosEnConstruccion.get(i);
			
			if(edificioActual.estaDestruido()){
				edificiosEnConstruccion.remove(i);
				i--;
			}
			else
				edificiosEnConstruccion.get(i).progresa();
		}			
		
		for(int i = 0; i < edificios.size(); i++){
			
			Edificio edificio = edificios.get(i);
			
			if(edificio.estaDestruido()){
				
				edificios.remove(i);
				i--;
			}
			else{
				
				if(edificio instanceof EdificioDeUnidades){
					
					EdificioDeUnidades edificioDeUnidades = (EdificioDeUnidades) edificio;
					
					edificioDeUnidades.unidadesProgresoConstruccion();
				}
				else
					if(edificio instanceof EdificioRecolectorRecurso)
						((EdificioRecolectorRecurso) edificio).recolectar();
			}			
		}		
		
		for(int i = 0; i < unidades.size(); i++){			
			Unidad unidad = unidades.get(i);
			if (unidad.estaDestruido()){
				
				suministros.reponer(unidad.costoSuministro());
				unidades.remove(i);
				i--;
			}				
			else
				unidad.empezarTurno();
		}		
	}

	private boolean hayEdificiosTerminados() {
		
		for(int i = 0; i < edificiosEnConstruccion.size(); i++)
			if(edificiosEnConstruccion.get(i).tiempoConstruccion() == 0)
				return true;
		
		return false;
	}

	public EnConstruccion obtenerEdificioTerminado() throws NoHayObjetosTerminados {			
		
		if(this.hayEdificiosTerminados()){
			
			for(int i = 0; i < edificiosEnConstruccion.size(); i++)
				if(edificiosEnConstruccion.get(i).tiempoConstruccion() == 0){
												
					EnConstruccion edificio = edificiosEnConstruccion.get(i);
					edificiosEnConstruccion.remove(i);
					
					if(edificio.edificioTerminado() instanceof EdificioDeSuministro)
						suministros.agregar(5);
					
					return edificio;
			}
			throw new NoHayObjetosTerminados();
				
		}
		else
			throw new NoHayObjetosTerminados();
	}

	public void agregarEdificio(Edificio edificio) {
		edificios.add(edificio);		
	}

	public Suministro suministros() {
		return suministros;
	}

	public int unidades() {
		return unidades.size();
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	private boolean hayUnidadTerminada() {
		
		for(int i = 0; i < edificios.size(); i++)
			if((edificios.get(i) instanceof EdificioDeUnidades) && 
					(((EdificioDeUnidades) edificios.get(i)).hayUnidadesTerminadas()))
				return true;
		
		return false;
	}
	
	public Unidad obtenerUnidadTerminada() throws NoHayObjetosTerminados {
		
		if(this.hayUnidadTerminada()){
			
			for(int i = 0; i < edificios.size(); i++)
				if((edificios.get(i) instanceof EdificioDeUnidades) && (((EdificioDeUnidades) edificios.get(i)).hayUnidadesTerminadas())){
															
					Unidad unidad = ((EdificioDeUnidades) edificios.get(i)).unidadTerminada();
					unidad.posicion(edificios.get(i).posicion());
					return unidad;
				}			
		}		
		throw new NoHayObjetosTerminados();			
	}

	public boolean contieneUnidad(Unidad unidad) {
		
		if(unidades.contains(unidad))
			return true;
		else
			return false;
	}

	public String raza() {
		return raza;
	}

	
	public void crearVision(Tamanio tamanio) {
		vision = new Vision(tamanio);
		this.descubrir(base.posicion(), base.vision());
	}
	
	public boolean hayVision(Posicion posicion){
		return vision.hayVisibilidad(posicion);
	}

	public void descubrir(Posicion posicion, int rango) {
		vision.descubrir(posicion, rango);		
	}
}
