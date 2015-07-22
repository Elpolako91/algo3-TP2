package fiuba.algo3.tp2.objetosDelMapa.edificios;

import java.util.List;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;

public class EdificioCentralTerran extends EdificioCentral {
	
	public EdificioCentralTerran(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles,
			List<Edificio> edificiosJugador) {
		
		super("Central terran", 2000, 0, recursosDisponibles, suministrosDisponibles, edificiosJugador, new ImageIcon(EdificioCentralTerran.class.getResource("/imagenes/razaTerran.jpg")));
	}

	public EdificioCentroMineral construirRecolectorMineral() throws RecursosInsuficientes {
		
		EdificioCentroMineral recMineral = new EdificioCentroMineral(this.recursosDisponibles());
		this.recursosDisponibles().descontar(recMineral.costoRecursos());
		return recMineral;
	}
	
	public EdificioRefineria construirRecolectorGasVespeno() throws RecursosInsuficientes {
		
		EdificioRefineria recGas = new EdificioRefineria(this.recursosDisponibles());
		this.recursosDisponibles().descontar(recGas.costoRecursos());
		return recGas;
	}

	public EdificioDeposito construirAsentamiento() throws RecursosInsuficientes {
		
		EdificioDeposito deposito = new EdificioDeposito();
		this.recursosDisponibles().descontar(deposito.costoRecursos());
		return deposito;
	}
	
	public EdificioBarraca construirBarraca() throws RecursosInsuficientes {
		
		EdificioBarraca barraca = new EdificioBarraca(this.recursosDisponibles(), this.suministros());
		this.recursosDisponibles().descontar(barraca.costoRecursos());
		return barraca;
	}

	public EdificioFabrica construirFabrica() throws RecursosInsuficientes, RequerimientosInsuficientes {
				
		boolean hayBarraca = false;
		
		for(int i = 0; i < this.edificios().size(); i++)
			if(this.edificios().get(i) instanceof EdificioBarraca)				
				hayBarraca = true;
		
		if(hayBarraca){
			
			EdificioFabrica fabrica = new EdificioFabrica(this.recursosDisponibles(), this.suministros());
			this.recursosDisponibles().descontar(fabrica.costoRecursos());
			return fabrica;
		}
		else
			throw new RequerimientosInsuficientes();
	}

	public EdificioPuertoEstelarTerran construirPuertoEstelarTerran() throws RecursosInsuficientes, RequerimientosInsuficientes {
		
		boolean hayFabrica = false;
		
		for(int i = 0; i < this.edificios().size(); i++)
			if(this.edificios().get(i) instanceof EdificioFabrica)
				hayFabrica = true;
		if(hayFabrica){
			
			EdificioPuertoEstelarTerran puerto = new EdificioPuertoEstelarTerran(this.recursosDisponibles(), this.suministros());
			this.recursosDisponibles().descontar(puerto.costoRecursos());
			return puerto;
		}
		else
			throw new RequerimientosInsuficientes();
	}	
}