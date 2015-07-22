package fiuba.algo3.tp2.objetosDelMapa.edificios;

import javax.swing.ImageIcon;

public class EdificioEnConstruccion extends Edificio implements EnConstruccion {
	
	private Edificio edificioAconstruir;
	
	public EdificioEnConstruccion(Edificio edificio, ImageIcon unaImagen) {
		
		super(edificio.nombre(), edificio.vidaMaxima(), edificio.escudoMaximo(), edificio.tiempoConstruccion(),
				edificio.costoRecursos(), edificio.tamanio(), null);
		
		edificioAconstruir = edificio;
	}	
	
	public Edificio edificioTerminado(){
		return edificioAconstruir;
	}
}
