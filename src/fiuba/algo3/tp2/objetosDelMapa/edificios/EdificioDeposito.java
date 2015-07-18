package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class EdificioDeposito extends EdificioDeSuministro {
	
	public EdificioDeposito(){		
		super("Deposito suministro", 500, 0, 6, new RecursosDelJugador(100,0));
	}
}