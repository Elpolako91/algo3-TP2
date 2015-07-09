package fiuba.algo3.tp2;


public class EdificioAsimilador extends EdificioRecolectorDeVespeno {
	
	public EdificioAsimilador(RecursosDelJugador unosRecursos){
		
		super ();
		nombre = "Asimilador";
		vidaMaxima = 450;
		vidaActual = 450;
		escudoActual = 450;
		escudoMaximo = 450;
		recursos = unosRecursos;
		tiempoConstruccion = 6;
		costoRecurso = new RecursosDelJugador(100,0);
	}
}
