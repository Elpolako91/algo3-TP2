package fiuba.algo3.tp2;

public class EdificioEnConstruccion extends Edificio {
	
	private Edificio edificioAconstruir;
		
	public EdificioEnConstruccion(Edificio unEdificio){
		edificioAconstruir = unEdificio;
	}
	
	public Edificio edificioTerminado(){
		return edificioAconstruir;
	}
	
	public Tamanio tamanio(){
		
		return edificioAconstruir.tamanio();
	}
	
	public int tiempoConstruccion(){
		
		return edificioAconstruir.tiempoConstruccion();
	}
	
	public void progresa(){
		
		edificioAconstruir.progresa();
	}
}
