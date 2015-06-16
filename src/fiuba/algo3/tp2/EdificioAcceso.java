package fiuba.algo3.tp2;

public class EdificioAcceso extends EdificioProtos {
	
	public EdificioAcceso(){
		
		tamanio = new Tamanio(2,2);
		this.vidaActual = 500;
		this.vidaMaxima = 500;
		this.escudoActual = 500;
		this.escudoMaximo = 500;
		this.nombre = "acceso";
		costoRecurso = new RecursosDelJugador(150,0);
		
	}
	
	public UnidadZealot construirZealot() {
		UnidadZealot unidad = new UnidadZealot();
		return unidad;
	}
	
	public UnidadDragon construirDragon() {
		UnidadDragon unidad = new UnidadDragon();
		return unidad;
	}
}
