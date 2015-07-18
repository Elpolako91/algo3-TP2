package fiuba.algo3.tp2;


public class UnidadGolliat extends UnidadTerrestre {

	public UnidadGolliat() {
		
		nombre = "golliat";
		vidaMaxima = 125;
		vidaActual = 125;
		danioAire = 10;
		danioTierra = 12;
		rangoTierra = 6;
		rangoAire = 5;
		costoRecurso = new RecursosDelJugador(100,50);
		costoSuministro = 2;
		tiempoConstruccion = 6;
		ocupacionTransporte = 2;
		vision = 8;
	}

}
