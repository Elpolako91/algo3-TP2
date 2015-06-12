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
	private RecursoDelJugador recursos;
	private Suministro suministros;
	
	public Jugador(String unNombre, String unColor, String unaRaza) {

		nombre = unNombre;
		color = unColor;
		raza = unaRaza;
		suministros = new Suministro();
		recursos = new RecursoDelJugador(1000,1000);
	}
	/*************************	ACCESOR		*****************************************/
	
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
	
	/******************************************************************************/
	
	public void pasarTurno() {
		if(this.esMiTurno())juego.pasarTurno();		
	}
	
	private boolean esMiTurno(){
		if(juego.turno()==this)
			return true;		
		else 
			return false;
	}
	
	public void construirEdificio(Posicion posicion, EdificioTerran unEdificio) {
		if((this.esMiTurno())&&recursos.cantidadSuficiente(unEdificio.costoRecursos())){
			if(juego.colocarEdificio(unEdificio,posicion)){
					edificios.add(unEdificio);
					recursos.descontar(unEdificio.costoRecursos());
			}
		}
	}
	
	public UnidadMarine construirMarine(Barraca unaBarraca){
		UnidadMarine marine= unaBarraca.construirUnidad();
			if ((this.esMiTurno())&&recursos.cantidadSuficiente(marine.costoRecursos())&&(suministros.cantidadSuficiente(marine.costoSuministro()))){
				if(juego.colocarUnidad(marine,unaBarraca)){
					unidades.add(marine);
					recursos.descontar(marine.costoRecursos());
					suministros.descontar(marine.costoSuministro());
					return marine;
				}
			}
		return null;
	}
	
	public void atacar(UnidadTerran unidadAtacante,Posicion posicionDestino) {
		if(this.esMiTurno()&&(unidades.contains(unidadAtacante))){
			juego.atacar(this,unidadAtacante, posicionDestino);
			}
	}
		
		
	public void moverUnidad(UnidadTerran unidad, Posicion posicionDestino) {
		
		for(int i=0; i<30; i++)								//controlar si la unidad tiene movimientos
		juego.mapa().moverUnidad(unidad, posicionDestino);
		
	}

	public void eliminarUnidad(UnidadTerran unidadAtacada) {
		unidades.remove(unidadAtacada);		
	}
	
}
