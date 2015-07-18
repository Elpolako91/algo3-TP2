package fiuba.algo3.tp2;


public class UnidadEspectro extends UnidadAerea {

	public UnidadEspectro() {
		
		nombre = "espectro";
		vidaMaxima = 120;
		vidaActual = 120;
		danioAire = 20;
		danioTierra = 8;
		rangoTierra = 5;
		rangoAire = 5;
		costoRecurso = new RecursosDelJugador(150,100);
		costoSuministro = 2;
		tiempoConstruccion = 8;
		vision = 7;
	}
	
	

}
