package fiuba.algo3.tp2;


public class UnidadNaveCiencia extends UnidadAerea {

	private int energiaMaxima;
	private int energiaActual;

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
		energiaMaxima = 200;
		energiaActual = 50;
	}
	
	public void empezarTurno(){
		
		super.empezarTurno();
		
		if (energiaActual < 190)
			energiaActual = energiaActual + 10;
		else
			energiaActual = energiaMaxima;
	}
}
