package fiuba.algo3.tp2;

public class EdificioAsimilador extends EdificioProtos implements RecolectorDeRecursos {
	
	public EdificioAsimilador(){
		
		tamanio = new Tamanio(2,2);
		this.escudoActual = 450;
		this.escudoMaximo = 450;
		this.vidaActual = 450;
		this.vidaMaxima = 450;
		costoRecurso = new RecursosDelJugador(100,0);
	}
}
