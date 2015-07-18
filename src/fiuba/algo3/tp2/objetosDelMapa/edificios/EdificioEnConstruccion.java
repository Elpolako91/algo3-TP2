package fiuba.algo3.tp2.objetosDelMapa.edificios;

public class EdificioEnConstruccion extends Edificio {
	
	private Edificio edificioAconstruir;
	
	public EdificioEnConstruccion(Edificio edificio) {
		
		super(edificio.nombre(), edificio.vidaMaxima(), edificio.escudoMaximo(), edificio.tiempoConstruccion(),
				edificio.costoRecursos(), edificio.tamanio());
		
		edificioAconstruir = edificio;
	}	
	
	public Edificio edificioTerminado(){
		return edificioAconstruir;
	}
		
	public int tiempoConstruccion(){
		
		return edificioAconstruir.tiempoConstruccion();
	}
	
	public void progresa(){
		
		edificioAconstruir.progresa();
	}
}
