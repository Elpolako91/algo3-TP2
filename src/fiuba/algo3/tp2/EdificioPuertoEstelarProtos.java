package fiuba.algo3.tp2;

public class EdificioPuertoEstelarProtos extends EdificioProtos implements EdificioPuertoEstelar {
	
	public  EdificioPuertoEstelarProtos() {
		
		tamanio = new Tamanio(2,2);
		nombre = "puerto estelar protos";
		tiempoConstruccion = 10;
		vidaActual = 600;
		vidaMaxima = 600;
		escudoActual = 600;
		escudoMaximo = 600;
		costoRecurso = new RecursosDelJugador(150,150);
	}
	
	public UnidadScout construirScout() {
		UnidadScout unidad = new UnidadScout();
		return unidad;
	}
	
	public UnidadNaveTransporteProtos construirNaveTransporte() {
		UnidadNaveTransporteProtos unidad = new UnidadNaveTransporteProtos();
		return unidad;
	}
}
