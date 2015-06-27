package fiuba.algo3.tp2;


public class EdificioNexoMineral extends EdificioRecolectorDeMineral {
	
	public EdificioNexoMineral(RecursosDelJugador unosRecursos){
		
		nombre = "Centro de mineral";
		vidaMaxima = 250;
		vidaActual = 250;
		escudoActual = 250;
		escudoMaximo = 250;
		recursos = unosRecursos;
		tiempoConstruccion = 4;
		costoRecurso = new RecursosDelJugador(50,0);
	}
}
