package fiuba.algo3.tp2;


public class UnidadAltoTemplario extends UnidadTerrestre {
	
	public UnidadAltoTemplario() {
		
		nombre = "alto templario";
		vidaMaxima = 40;
		vidaActual = 40;
		escudoMaximo = 40;
		escudoActual = 40;
		danioAire = 0;
		danioTierra = 0;
		rangoTierra = 0;
		rangoAire = 0;
		costoRecurso = new RecursosDelJugador(50,150);
		costoSuministro = 2;
		tiempoConstruccion = 7;
		ocupacionTransporte = 2;
		vision = 7;
	}

}
