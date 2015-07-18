package fiuba.algo3.tp2.objetosDelMapa.unidades;

import fiuba.algo3.tp2.juego.RecursosDelJugador;

public class UnidadNaveCiencia extends UnidadAerea {

	private int energiaMaxima;
	private int energiaActual;
	
	public UnidadNaveCiencia() {		
		
		super("Nave ciencia", 200, 0, 10, 10, new RecursosDelJugador(100,225), 2, 0, 0, 0, 0);
		
			energiaMaxima = 200;
			energiaActual = 50;		
	}
	
	@Override
	public void empezarTurno(){
		
		super.empezarTurno();
		
		if (energiaActual < 190)
			energiaActual = energiaActual + 10;
		else
			energiaActual = energiaMaxima;
	}
}