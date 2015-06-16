package fiuba.algo3.tp2;

public class EdificioPuertoEstelarTerran extends EdificioTerran implements EdificioPuertoEstelar {
	
	public EdificioPuertoEstelarTerran(){
		
		tamanio = new Tamanio(2,2);
		nombre = "puerto estelar terran";
		tiempoConstruccion = 10;
		vidaActual = 1300;
		vidaMaxima = 1300;
		costoRecurso = new RecursosDelJugador(150,100);
	}
	
	public UnidadEspectro construirEspectro() {
		UnidadEspectro unidad = new UnidadEspectro();
		return unidad;
	}
	
	public UnidadNaveCiencia construirNaveCiencia() {
		UnidadNaveCiencia unidad = new UnidadNaveCiencia();
		return unidad;
	}
	
	public UnidadNaveTransporteTerran construirNaveTransporte() {
		UnidadNaveTransporteTerran unidad = new UnidadNaveTransporteTerran();
		return unidad;
	}

}
