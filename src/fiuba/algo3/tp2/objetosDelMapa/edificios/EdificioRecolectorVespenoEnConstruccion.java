package fiuba.algo3.tp2.objetosDelMapa.edificios;

public class EdificioRecolectorVespenoEnConstruccion extends EdificioRecolectorDeVespeno implements EnConstruccion{

	private EdificioRecolectorDeVespeno edificioAConstruir;
	
	public EdificioRecolectorVespenoEnConstruccion(EdificioRecolectorDeVespeno edificio) {
		
		super(edificio.nombre(), edificio.vidaMaxima(), edificio.escudoMaximo(), edificio.tiempoConstruccion(), 
				edificio.costoRecursos(), edificio.recursosJuntados(), null);
		
		edificioAConstruir = edificio;
	}
	
	public EdificioRecolectorDeVespeno edificioTerminado(){
		return edificioAConstruir;
	}
}
