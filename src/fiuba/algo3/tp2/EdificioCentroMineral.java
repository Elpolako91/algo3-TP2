package fiuba.algo3.tp2;


public class EdificioCentroMineral extends EdificioRecolectorDeMineral {
		
	public EdificioCentroMineral(RecursosDelJugador unosRecursos) {
		
		nombre = "Centro de mineral";
		vidaMaxima = 500;
		vidaActual = 500;
		recursos = unosRecursos;
		tiempoConstruccion = 4;
		costoRecurso = new RecursosDelJugador(50,0);
	}
}
