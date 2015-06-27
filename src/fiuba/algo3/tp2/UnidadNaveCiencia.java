package fiuba.algo3.tp2;


public class UnidadNaveCiencia extends UnidadAerea {

	public UnidadNaveCiencia() {
		
		nombre = "nave ciencia";
		vidaMaxima = 200;
		vidaActual = 200;
		danioAire = 0;
		danioTierra = 0;
		rangoTierra = 0;
		rangoAire = 0;
		costoRecurso = new RecursosDelJugador(100,225);
		costoSuministro = 2;
		tiempoConstruccion = 10;
		vision = 10;
	}

}
