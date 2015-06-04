package fiuba.algo3.tp2;

import java.util.Random;

public class GeneradorDeNumerosAleatorios {

	public int generarNumeroAleatorio() {
													/*Tira un número aleatorio entre 0 y 1000 */
		Random ndm = new Random();
		
		return (ndm.nextInt(10-0+1)+0);
		
	}
	


}
