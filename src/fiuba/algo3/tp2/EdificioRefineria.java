package fiuba.algo3.tp2;


public class EdificioRefineria extends EdificioRecolectorDeVespeno {
	
	public EdificioRefineria(RecursosDelJugador unosRecursos) {
	
		nombre = "Refineria";
		vidaMaxima = 750;
		vidaActual = 750;
		recursos = unosRecursos;
		tiempoConstruccion = 6;
		costoRecurso = new RecursosDelJugador(100,0);
	}

}
