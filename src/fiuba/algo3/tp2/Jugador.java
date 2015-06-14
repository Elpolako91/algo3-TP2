package fiuba.algo3.tp2;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	private JuegoCraft juego;
	private List<EdificioTerran> edificios = new ArrayList<EdificioTerran> ();
	private List<UnidadTerran> unidades = new ArrayList<UnidadTerran> ();
	private RecursosDelJugador recursos;
	private Suministro suministros;
	
	public Jugador(String unNombre, String unColor, String unaRaza) {

		nombre = unNombre;
		color = unColor;
		raza = unaRaza;
		suministros = new Suministro();
		recursos = new RecursosDelJugador(1000,1000);
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
	
	public boolean agregarEdificio(EdificioTerran edificio){
		
		if (recursos.hayCantidadSuficiente(edificio.costoRecursos())){
			
			edificios.add(edificio);
			recursos.descontar(edificio.costoRecursos());
			return true;
		}
		else
			return false;
	}
	
	public boolean agregarUnidad(UnidadTerran unidad){
		if(suministros.hayCantidadSuficiente(unidad.costoSuministro()) && (recursos.hayCantidadSuficiente(unidad.costoRecursos()))){
			
			unidades.add(unidad);
			suministros.gastar(unidad.costoSuministro());
			recursos.descontar(unidad.costoRecursos());
			return true;
		}			
		else
			return false;
	}
	
	public boolean eliminarUnidad(UnidadTerran unidad) {
		if(unidades.remove(unidad)){
			suministros.reponer(unidad.costoSuministro());
			return true;
		}
		else
			return false;
	}

	public void eliminarEdificio(EdificioTerran edificio) {
		edificios.remove(edificio);	
	}
	
	public void construirEdificio(Posicion posicion, EdificioTerran edificio) {
		juego.colocarEdificio(this, edificio, posicion);
	}
	
	public void construirUnidad(EdificioTerran edificio){
		
		if(edificios.contains(edificio))
			juego.colocarUnidad(this, edificio);
	}
	
	public void atacar(UnidadTerran unidadAtacante,Posicion posicionDestino) {
		
		if(unidades.contains(unidadAtacante))
			juego.atacar(this,unidadAtacante, posicionDestino);
	}
		
	public void moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		
		if(unidades.contains(unidad))				
			juego.moverUnidad(this, unidad, posicionDestino);
		
	}

	public void pasarTurno() {
		juego.pasarTurno(this);
		
	}	
}
