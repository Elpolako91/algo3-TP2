package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class EdificioCentralProtos extends EdificioProtos {
	
	private List<EdificioProtos> edificios = new ArrayList<EdificioProtos> ();
	
	public EdificioCentralProtos() {
		
		this.vidaActual = 1000;
		this.vidaMaxima = 1000;
		this.escudoActual = 1000;
		this.escudoMaximo = 1000;
	}

	public EdificioNexoMineral construirNexoMineral() {
		
		EdificioNexoMineral nexo = new EdificioNexoMineral();
		edificios.add(nexo);
		return nexo;
	}

	public EdificioAsimilador construirAsimilador() {
		
		EdificioAsimilador asimilador = new EdificioAsimilador();
		edificios.add(asimilador);
		return asimilador;
	}

	public EdificioPilon construirPilon() {
		
		EdificioPilon pilon = new EdificioPilon();
		edificios.add(pilon);
		return pilon;
	}

	public EdificioAcceso construirAcceso() {
		
		EdificioAcceso acceso = new EdificioAcceso();
		edificios.add(acceso);
		return acceso;
	}

	public EdificioPuertoEstelarProtos construirPuertoEstelar() {
		
		for( int i = 0; i <= edificios.size(); i++ ){
			if(edificios.get(i).getClass() == EdificioAcceso.class){
				EdificioPuertoEstelarProtos puerto = new EdificioPuertoEstelarProtos();
				edificios.add(puerto);
				return puerto;
			}
		}
		return null;
	}

	public EdificioArchivosTemplarios crearArchivosTemplarios() {
		
		for( int i = 0; i <= edificios.size(); i++ ){
			if(edificios.get(i).getClass() == EdificioPuertoEstelarProtos.class){
				EdificioArchivosTemplarios arch = new EdificioArchivosTemplarios();
				edificios.add(arch);
				return arch;
			}
		}
		return null;
	}
}
