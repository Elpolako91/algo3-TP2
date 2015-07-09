package fiuba.algo3.tp2;

public class UnidadNaveTransporteProtos extends UnidadTransporte {

	public UnidadNaveTransporteProtos() {
		
		nombre = "nave transporte";
		vidaMaxima = 60;
		vidaActual = 60;
		escudoMaximo = 80;
		escudoActual = 80;
		danioAire = 0;
		danioTierra = 0;
		rangoTierra = 0;
		rangoAire = 0;
		costoRecurso = new RecursosDelJugador(200,0);
		costoSuministro = 2;
		tiempoConstruccion = 8;
		vision = 8;
		capacidad = 8;
	}

}
