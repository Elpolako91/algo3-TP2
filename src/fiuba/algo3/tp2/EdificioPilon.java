package fiuba.algo3.tp2;

public class EdificioPilon extends EdificioDeSuministro {
	
	public EdificioPilon(){
		
		tamanio = new Tamanio(2,2);
		nombre = "Pilon";
		tiempoConstruccion = 5;
		vidaActual = 300;
		vidaMaxima = 300;
		escudoActual = 300;
		escudoMaximo = 300;
		costoRecurso = new RecursosDelJugador(100,0);
	}

}
