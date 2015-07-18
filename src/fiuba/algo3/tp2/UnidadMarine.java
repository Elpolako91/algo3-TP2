package fiuba.algo3.tp2;


public class UnidadMarine extends UnidadTerrestre {

	public UnidadMarine() {
		
		nombre = "marine";
		vidaMaxima = 40;
		vidaActual = 40;
		danioAire = 6;
		danioTierra = 6;
		rangoTierra = 4;
		rangoAire = 4;
		costoRecurso = new RecursosDelJugador(50,0);
		costoSuministro = 1;
		tiempoConstruccion = 3;
		ocupacionTransporte = 1;
		vision = 7;
	}

}
