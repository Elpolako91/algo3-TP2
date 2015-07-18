package fiuba.algo3.tp2;

import java.util.List;


public abstract class EdificioCentral extends Edificio{

	protected List<Edificio> edificios;
	protected RecursosDelJugador recursos;
	protected Suministro suministros;
	
	protected EdificioCentral(RecursosDelJugador recursosJugador, Suministro suministroJugador, List<Edificio> edificiosJugador){
		
		edificios = edificiosJugador;
		recursos = recursosJugador;
		suministros = suministroJugador;
		suministros.agregar(5);
		tamanio = new Tamanio(3,3);
	}
}
