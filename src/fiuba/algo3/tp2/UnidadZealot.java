package fiuba.algo3.tp2;

public class UnidadZealot extends UnidadTerrestre {
	
	public UnidadZealot() {
		
		nombre = "zealot";
		vidaMaxima = 60;
		vidaActual = 60;
		escudoMaximo = 100;
		escudoActual = 100;
		danioAire = 0;
		danioTierra = 8;
		rangoTierra = 1;
		rangoAire = 0;
		costoRecurso = new RecursosDelJugador(100,0);
		costoSuministro = 2;
		tiempoConstruccion = 4;
		ocupacionTransporte = 2;
		vision = 7;
	}

}
