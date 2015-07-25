package fiuba.algo3.tp2.objetosDelMapa.edificios;

public class EdificioEnConstruccion extends Edificio implements EnConstruccion {
	
	private Edificio edificioAconstruir;
	
	public EdificioEnConstruccion(Edificio edificio) {
		
		super(edificio.nombre(), edificio.vidaMaxima(), edificio.escudoMaximo(), edificio.tiempoConstruccion(),
				edificio.costoRecursos(), edificio.tamanio(), null);
		
		edificioAconstruir = edificio;
	}	
	
	public Edificio edificioTerminado(){
		return edificioAconstruir;
	}
}
