package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;


public class EdificioAcceso extends EdificioDeUnidades {
	
	public EdificioAcceso(RecursosDelJugador recursosJugador, Suministro suministroJugador){
		
		super(recursosJugador, suministroJugador);
		
		tamanio = new Tamanio(2,2);
		nombre = "Acceso";
		tiempoConstruccion = 8;
		vidaActual = 500;
		vidaMaxima = 500;
		escudoActual = 500;
		escudoMaximo = 500;
		costoRecurso = new RecursosDelJugador(150,0);
	}
	
	public UnidadZealot construirZealot() throws RecursosInsuficientes {
		
		UnidadZealot zealot = new UnidadZealot();
		this.crearUnidad(zealot);
		return zealot;	
	}
	
	public UnidadDragon construirDragon() throws RecursosInsuficientes {
		
		UnidadDragon dragon = new UnidadDragon();
		this.crearUnidad(dragon);
		return dragon;
	}
}
