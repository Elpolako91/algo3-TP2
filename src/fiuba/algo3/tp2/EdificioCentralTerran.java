package fiuba.algo3.tp2;

import java.util.List;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;

public class EdificioCentralTerran extends EdificioCentral {
	
	public EdificioCentralTerran(RecursosDelJugador recursosJugador, Suministro suministroJugador, List<Edificio> edificiosJugador) {		
		
		super(recursosJugador, suministroJugador, edificiosJugador);
		
		nombre = "Central Terran";
		vidaMaxima = 2000;
		vidaActual = 2000;		
	}

	public EdificioCentroMineral construirRecolectorMineral() throws RecursosInsuficientes {
		
		EdificioCentroMineral recMineral = new EdificioCentroMineral(recursos);
		recursos.descontar(recMineral.costoRecursos());
		return recMineral;
	}
	
	public EdificioRefineria construirRecolectorGasVespeno() throws RecursosInsuficientes {
		
		EdificioRefineria recGas = new EdificioRefineria(recursos);
		recursos.descontar(recGas.costoRecursos());
		return recGas;
	}

	public EdificioDeposito construirAsentamiento() throws RecursosInsuficientes {
		
		EdificioDeposito deposito = new EdificioDeposito();
		recursos.descontar(deposito.costoRecursos());
		return deposito;
	}
	
	public EdificioBarraca construirBarraca() throws RecursosInsuficientes {
		
		EdificioBarraca barraca = new EdificioBarraca(recursos, suministros);
		recursos.descontar(barraca.costoRecursos());
		return barraca;
	}

	public EdificioFabrica construirFabrica() throws RecursosInsuficientes, RequerimientosInsuficientes {
				
		boolean hayBarraca = false;
		
		EdificioFabrica fabrica = new EdificioFabrica(recursos, suministros);
		recursos.descontar(fabrica.costoRecursos());
			
		for(int i = 0; i < edificios.size(); i++)
			if(edificios.get(i) instanceof EdificioBarraca)				
				hayBarraca = true;
			
		if(hayBarraca)
			return fabrica;
		else
			throw new RequerimientosInsuficientes();
	}

	public EdificioPuertoEstelarTerran construirPuertoEstelarTerran() throws RecursosInsuficientes, RequerimientosInsuficientes {
		
		boolean hayFabrica = false;
		
		EdificioPuertoEstelarTerran puerto = new EdificioPuertoEstelarTerran(recursos, suministros);
		recursos.descontar(puerto.costoRecursos());
		
		for(int i = 0; i < edificios.size(); i++)
			if(edificios.get(i) instanceof EdificioFabrica)
				hayFabrica = true;
			
		if(hayFabrica)
			return puerto;
		else
			throw new RequerimientosInsuficientes();
	}	
}