package fiuba.algo3.tp2;

public class EdificioNexoMineral extends EdificioProtos implements RecolectorDeRecursos {
	
	public EdificioNexoMineral(){
		
		tamanio = new Tamanio(2,2);
		this.vidaMaxima = 250;
		this.vidaActual = 250;
		this.escudoActual = 250;
		this.escudoMaximo = 250;
		costoRecurso = new RecursosDelJugador(100,0);
	}
}
