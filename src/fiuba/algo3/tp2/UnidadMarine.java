package fiuba.algo3.tp2;

public class UnidadMarine extends UnidadTerran {

	public UnidadMarine() {
		
		nombre = "marine";
		vidaMaxima = 40;
		vidaActual = 40;
		danioAire = 6;
		danioTierra = 6;
		rango = 4;
		costoRecurso = new RecursosDelJugador(50,0);
		costoSuministro = 1;
	}

}
