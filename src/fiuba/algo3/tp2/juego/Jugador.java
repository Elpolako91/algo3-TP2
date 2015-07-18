package fiuba.algo3.tp2.juego;

import java.util.List;
import java.util.ArrayList;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralProtos;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioCentralTerran;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeSuministro;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeUnidades;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioEnConstruccion;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRecolectorDeMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRecolectorDeVespeno;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	private EdificioCentral base;
	private List<Edificio> edificios = new ArrayList<Edificio> ();
	private List<EdificioEnConstruccion> edificiosEnConstruccion = new ArrayList<EdificioEnConstruccion> ();
	private List<Unidad> unidades = new ArrayList<Unidad> ();
	private RecursosDelJugador recursos;
	private Suministro suministros;
	
	private JuegoCraft juego;	
	
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
	
	/*************************	Accesosrs	*****************************************/
	
	public String nombre() {		
		return nombre;
	}
	
	public String color() {	
		return color;
	}
	
	public String raza() {		
		return raza;
	}
	
	public RecursosDelJugador recursos() {
		return recursos;
	}
		
	public Suministro suministros(){
		return suministros;
	}
	
	public void juego(JuegoCraft unJuego) {			// a eliminar
		juego = unJuego;
	}
	
	public JuegoCraft juego(){			// a eliminar
		return juego;
	}
	
	public int edificios() {		
		return edificios.size();
	}
	
	public int unidades() {		
		return unidades.size();
	}
	
	/******************************************************************************/
	public void agregarEdificioEnConstruccion(EdificioEnConstruccion edificio) {
		edificiosEnConstruccion.add(edificio);		
	}
	
	public void eliminarEdificioEnConstruccion(EdificioEnConstruccion edificio) {
		edificiosEnConstruccion.remove(edificio);		
	}
	
	public void agregarEdificio(Edificio edificio){
		edificios.add(edificio);
	}
	
	public void eliminarEdificio(Edificio edificio){
		edificios.remove(edificio);
	}
	
	public boolean contieneUnidad(Unidad unidad) {
		
		if(unidades.contains(unidad))
			return true;
		else
			return false;
	}
	
	public void agregarUnidad(Unidad unidad) throws RecursosInsuficientes{
		
		try{
			suministros.gastar(unidad.costoSuministro());
		}
		catch(RecursosInsuficientes e){}
		
		try{
			recursos.descontar(unidad.costoRecursos());
			unidades.add(unidad);
		}
		catch(RecursosInsuficientes e){
			suministros.reponer(unidad.costoSuministro());
		}	
	}
	
	public boolean eliminarUnidad(Unidad unidad) {
		if(unidades.remove(unidad)){
			suministros.reponer(unidad.costoSuministro());
			return true;
		}
		else
			return false;
	}
			
	public EdificioCentral edificioCentral() {
		return base;
	}

	public void edificiosProgresoConstruccion() throws PosicionInvalida {
		
		int i = 0;
		while( i < edificiosEnConstruccion.size()){
			
			edificiosEnConstruccion.get(i).progresa();
			
			if(edificiosEnConstruccion.get(i).tiempoConstruccion() == 0){
				
				EdificioEnConstruccion edificioEnContruccion = edificiosEnConstruccion.remove(i);
				Edificio edificio = edificioEnContruccion.edificioTerminado();
				juego.colocarEdificio(this, edificio, edificioEnContruccion.posicion());
				
				if (edificio instanceof EdificioDeSuministro)
					suministros.agregar(5);
			}
			else
				i++;
		}		
	}

	public void progresoPorTurno() throws PosicionInvalida {
		
		for(int i = 0; i < edificios.size(); i++){
			
			Edificio edificio = edificios.get(i);
			
			if(edificio instanceof EdificioDeUnidades){
				
				EdificioDeUnidades edificioDeUnidades = (EdificioDeUnidades) edificio;
				
				edificioDeUnidades.unidadesProgresoConstruccion();
				
				while (edificioDeUnidades.hayUnidadesTerminadas()){
					
					Unidad unidad = edificioDeUnidades.unidadTerminada();
					unidades.add(unidad);
					juego.colocarUnidad(this, edificioDeUnidades, unidad);
				}
			}
			else
				if(edificio instanceof EdificioRecolectorDeMineral){
				
					EdificioRecolectorDeMineral edificioMineral = (EdificioRecolectorDeMineral) edificio;
				
					edificioMineral.recolectar();
				}
			else
				if(edificio instanceof EdificioRecolectorDeVespeno){
				
					EdificioRecolectorDeVespeno edificioVespeno = (EdificioRecolectorDeVespeno) edificio;
				
					edificioVespeno.recolectar();
			}						
		}
		
		for(int i = 0; i < unidades.size(); i++){
			
			Unidad unidad = unidades.get(i);
			
			unidad.empezarTurno();
		}		
	}
	
	
}