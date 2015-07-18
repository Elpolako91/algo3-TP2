package fiuba.algo3.tp2;


public class UnidadDragon extends UnidadTerrestre {
	
	public UnidadDragon() {
		
		nombre = "dragon";
		vidaMaxima = 80;
		vidaActual = 80;
		escudoMaximo = 100;
		escudoActual = 100;
		danioAire = 20;
		danioTierra = 20;
		rangoTierra = 4;
		rangoAire = 4;
		costoRecurso = new RecursosDelJugador(125,50);
		costoSuministro = 2;
		tiempoConstruccion = 6;
		ocupacionTransporte = 4;
		vision = 8;
	}
}
