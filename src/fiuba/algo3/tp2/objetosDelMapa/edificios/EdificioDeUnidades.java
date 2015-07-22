package fiuba.algo3.tp2.objetosDelMapa.edificios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public abstract class EdificioDeUnidades extends Edificio{
	
	private List<Unidad> unidadesEnConstruccion = new ArrayList<Unidad> ();
	private RecursosDelJugador recursos;
	private Suministro suministros;

	protected EdificioDeUnidades(String unNombre, int vida, int escudo,	int unTiempoConstruccion, RecursosDelJugador costo,
			Tamanio unTamanio, RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles, ImageIcon unaImagen) {
		
		super(unNombre, vida, escudo, unTiempoConstruccion, costo, unTamanio, unaImagen);		
		recursos = recursosDisponibles;
		suministros = suministrosDisponibles;		
	}
	
	public void unidadesProgresoConstruccion(){
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)			
			unidadesEnConstruccion.get(i).progresa();
	}

	public boolean hayUnidadesTerminadas() {
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)
			if(unidadesEnConstruccion.get(i).tiempoConstruccion() == 0)
				return true;
		
		return false;
	}

	public Unidad unidadTerminada() {
		
		for(int i = 0; i < unidadesEnConstruccion.size(); i++)
			if(unidadesEnConstruccion.get(i).tiempoConstruccion() == 0)
				return unidadesEnConstruccion.remove(i);
		
		return null;
	}
	
	protected void crearUnidad(Unidad unidad) throws RecursosInsuficientes{
		
		try{
			suministros.gastar(unidad.costoSuministro());
		}
		catch(RecursosInsuficientes e){
			throw new RecursosInsuficientes();
		}
		
		try{
			recursos.descontar(unidad.costoRecursos());
			unidadesEnConstruccion.add(unidad);
		}
		catch(RecursosInsuficientes e){
			suministros.reponer(unidad.costoSuministro());
			throw new RecursosInsuficientes();
		}
	}
}
