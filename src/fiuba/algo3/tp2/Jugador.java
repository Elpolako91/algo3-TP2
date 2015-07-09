package fiuba.algo3.tp2;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	private JuegoCraft juego;
	private EdificioCentral base;
	private List<Edificio> edificios = new ArrayList<Edificio> ();
	private List<EdificioEnConstruccion> edificiosEnConstruccion = new ArrayList<EdificioEnConstruccion> ();
	private List<Unidad> unidades = new ArrayList<Unidad> ();
	private RecursosDelJugador recursos;
	private Suministro suministros;
	private Edificio edificioAConstruir;
	
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
	
	/******************************************************************************/
	public void agregarEdificioEnConstruccion(EdificioEnConstruccion edificio) {
		edificiosEnConstruccion.add(edificio);		
	}	
	
	
	public void agregarEdificio(Edificio edificio){
		edificios.add(edificio);
	}
	
	public boolean agregarUnidad(Unidad unidad){
		if(suministros.hayCantidadSuficiente(unidad.costoSuministro()) && (recursos.hayCantidadSuficiente(unidad.costoRecursos()))){
			
			unidades.add(unidad);
			suministros.gastar(unidad.costoSuministro());
			recursos.descontar(unidad.costoRecursos());
			return true;
		}			
		else
			return false;
	}
	
	public boolean eliminarUnidad(Unidad unidad) {
		if(unidades.remove(unidad)){
			suministros.reponer(unidad.costoSuministro());
			return true;
		}
		else
			return false;
	}

	public void eliminarEdificio(Edificio edificio) {
		edificios.remove(edificio);	
	}
	
	public void construirEdificio(Posicion posicion, Edificio edificio) {
		juego.construirEdificio(this, edificio, posicion);
	}
	
		
	public void atacarTierra(Unidad unidadAtacante,Posicion posicionDestino) {
		
		if(unidades.contains(unidadAtacante))
			juego.atacarTierra(this,unidadAtacante, posicionDestino);
	}
	
	public void atacarAire(Unidad unidadAtacante,Posicion posicionDestino) {
		
		if(unidades.contains(unidadAtacante))
			juego.atacarAire(this,unidadAtacante, posicionDestino);
	}
		
	public void moverUnidad(Unidad unidad, Posicion posicionDestino) {
		
		if(unidades.contains(unidad))				
			juego.moverUnidad(this, unidad, posicionDestino);
		
	}

	public void pasarTurno() {
		juego.pasarTurno(this);
		
	}

	public EdificioCentral edificioCentral() {
		return base;
	}

	public void edificiosProgresoConstruccion() {
		
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

	public void progresoPorTurno() {
		
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
				
					edificioMineral.recolectaMineral();
				}
			else
				if(edificio instanceof EdificioRecolectorDeVespeno){
				
					EdificioRecolectorDeVespeno edificioVespeno = (EdificioRecolectorDeVespeno) edificio;
				
					edificioVespeno.recolectarVespeno();
			}						
		}
		
		for(int i = 0; i < unidades.size(); i++){
			
			Unidad unidad = unidades.get(i);
			
			unidad.empezarTurno();
		}		
	}
	
	public void edificioAConstruir(Edificio edificio) {
		
		edificioAConstruir = edificio;
		
	}

	public Edificio edificioAConstruir() {
		
		return edificioAConstruir;
	}

	public void cargarUnidad(UnidadTransporte transporte,	UnidadTerrestre unidadACargar) {
		
		juego.cargarUnidad(this, transporte, unidadACargar);
		
	}

	public void descargarUnidad(UnidadTransporte transporte) {
		
		juego.descargarUnidad(this, transporte);
		
	}

	
}
