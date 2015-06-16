package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class EdificioCentralTerran extends EdificioTerran implements Edificio {
	
	private List<EdificioTerran> edificios = new ArrayList<EdificioTerran> ();
	
	public EdificioCentralTerran() {		
		vidaMaxima = 2000;
		vidaActual = 2000;
		tamanio = new Tamanio(3,3);
		
	}
	
	public EdificioBarraca construirBarraca() {
		
		EdificioBarraca barraca = new EdificioBarraca();
		edificios.add(barraca);
		return (barraca);
	}

	public EdificioRefineria construirRecolectorGasVespeno() {
		
		EdificioRefineria recGas = new EdificioRefineria();
		edificios.add(recGas);
		return (recGas);
	}

	public EdificioCentroMineral construirRecolectorMineral() {
		
		EdificioCentroMineral recMineral = new EdificioCentroMineral();
		edificios.add(recMineral);
		return (recMineral);
	}

	public EdificioDeposito construirAsentamiento() {
		
		EdificioDeposito deposito = new EdificioDeposito();
		edificios.add(deposito);
		return deposito;
	}

	public EdificioFabrica construirFabrica() {
		
		for(int i = 0; i <= edificios.size(); i++){
			if(edificios.get(i).getClass() == EdificioBarraca.class ){
			
			EdificioFabrica fabrica = new EdificioFabrica();
			edificios.add(fabrica);
			return fabrica;
			}
		}
		return null;
	}

	public EdificioPuertoEstelarTerran construirPuertoEstelarTerran() {
		
		for(int i = 0; i <= edificios.size(); i++){
			if(edificios.get(i).getClass() == EdificioFabrica.class ){
			
			EdificioPuertoEstelarTerran puerto = new EdificioPuertoEstelarTerran();
			edificios.add(puerto);
			return puerto;
			}
		}
		return null;
	}				
}