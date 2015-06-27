package fiuba.algo3.tp2;

public class UnidadScout extends UnidadAerea {
	
	public UnidadScout() {
		
		nombre = "scout";
		vidaMaxima = 100;
		vidaActual = 100;
		escudoMaximo = 150;
		escudoActual = 150;
		danioAire = 14;
		danioTierra = 8;
		rangoTierra = 4;
		rangoAire = 4;
		costoRecurso = new RecursosDelJugador(300,150);
		costoSuministro = 3;
		tiempoConstruccion = 9;
		vision = 7;
	}

}
