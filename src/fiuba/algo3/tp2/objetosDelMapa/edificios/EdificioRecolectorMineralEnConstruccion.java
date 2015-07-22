package fiuba.algo3.tp2.objetosDelMapa.edificios;

public class EdificioRecolectorMineralEnConstruccion extends EdificioRecolectorDeMineral implements EnConstruccion{

	private EdificioRecolectorDeMineral edificioAConstruir;
	
	public EdificioRecolectorMineralEnConstruccion(EdificioRecolectorDeMineral edificio) {
		
		super(edificio.nombre(), edificio.vidaMaxima(), edificio.escudoMaximo(), edificio.tiempoConstruccion(), 
				edificio.costoRecursos(), edificio.recursosJuntados(), null);
		
		edificioAConstruir = edificio;
	}
	
	public EdificioRecolectorDeMineral edificioTerminado(){
		return edificioAConstruir;
	}
}
