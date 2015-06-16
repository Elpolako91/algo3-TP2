package fiuba.algo3.tp2;

public class EdificioDeposito extends EdificioTerran implements Asentamiento {
	
	public EdificioDeposito(){
		
		tamanio = new Tamanio(2,2);
		nombre = "deposito";
		tiempoConstruccion = 6;
		vidaActual = 500;
		vidaMaxima = 500;
		costoRecurso = new RecursosDelJugador(100,0);
	}

}
