package fiuba.algo3.tp2;

import java.util.List;

public class EdificioCentralTerran extends EdificioCentral {
	
	public EdificioCentralTerran(RecursosDelJugador recursosJugador, Suministro suministroJugador, List<Edificio> edificiosJugador) {		
		
		edificios = edificiosJugador;
		recursos = recursosJugador;
		suministros = suministroJugador;
		
		vidaMaxima = 2000;
		vidaActual = 2000;		
		tamanio = new Tamanio(3,3);		
		suministros.agregar(5);		
	}

	public EdificioCentroMineral construirRecolectorMineral() {
		
		EdificioCentroMineral recMineral = new EdificioCentroMineral(recursos);
		if(recursos.descontar(recMineral.costoRecursos()))
			return recMineral;
		else
			return null;
	}
	
	public EdificioRefineria construirRecolectorGasVespeno() {
		
		EdificioRefineria recGas = new EdificioRefineria(recursos);
		if(recursos.descontar(recGas.costoRecursos()))
			return recGas;
		else
			return null;
	}

	public EdificioDeposito construirAsentamiento() {
		
		EdificioDeposito deposito = new EdificioDeposito();
		if(recursos.descontar(deposito.costoRecursos()))
			return deposito;
		else
			return null;
	}
	
	public EdificioBarraca construirBarraca() {
		
		EdificioBarraca barraca = new EdificioBarraca(recursos, suministros);
		if(recursos.descontar(barraca.costoRecursos()))	
			return (barraca);
		else
			return null;
	}

	public EdificioFabrica construirFabrica() {
		
		EdificioFabrica fabrica = new EdificioFabrica(recursos, suministros);
		
		if(recursos.descontar(fabrica.costoRecursos()))			
			for(int i = 0; i < edificios.size(); i++)
				if(edificios.get(i) instanceof EdificioBarraca)
					return fabrica;			
		
		return null;
	}

	public EdificioPuertoEstelarTerran construirPuertoEstelarTerran() {
		
		EdificioPuertoEstelarTerran puerto = new EdificioPuertoEstelarTerran(recursos, suministros);
		
		if(recursos.descontar(puerto.costoRecursos()))
			for(int i = 0; i < edificios.size(); i++)
				if(edificios.get(i) instanceof EdificioFabrica)
					return puerto;
			
		return null;
	}	
}