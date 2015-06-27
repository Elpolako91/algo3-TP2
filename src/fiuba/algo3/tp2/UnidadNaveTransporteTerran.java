package fiuba.algo3.tp2;


public class UnidadNaveTransporteTerran extends UnidadAerea {

	private int capacidad;

	public UnidadNaveTransporteTerran() {
		
		nombre = "nave transporte";
		vidaMaxima = 150;
		vidaActual = 150;
		danioAire = 0;
		danioTierra = 0;
		rangoTierra = 0;
		rangoAire = 0;
		costoRecurso = new RecursosDelJugador(100,100);
		costoSuministro = 2;
		tiempoConstruccion = 7;
		vision = 8;
		capacidad = 8;
	}

}
