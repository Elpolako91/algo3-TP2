package fiuba.algo3.tp2;

import java.util.List;

public class EdificioCentralProtos extends EdificioCentral{
	
	public EdificioCentralProtos(RecursosDelJugador recursosJugador, Suministro suministroJugador, List<Edificio> edificiosJugador) {
		
		edificios = edificiosJugador;
		recursos = recursosJugador;
		suministros = suministroJugador;
		
		vidaActual = 1000;
		vidaMaxima = 1000;
		escudoActual = 1000;
		escudoMaximo = 1000;	
		tamanio = new Tamanio(3,3);		
		suministros.agregar(5);	
	}

	public EdificioNexoMineral construirRecolectorMineral() {
		
		EdificioNexoMineral nexo = new EdificioNexoMineral(recursos);
		if(recursos.descontar(nexo.costoRecursos()))
			return nexo;
		else
			return null;
	}

	public EdificioAsimilador construirRecolectorGasVespeno() {
		
		EdificioAsimilador asimilador = new EdificioAsimilador(recursos);
		if(recursos.descontar(asimilador.costoRecursos()))
			return asimilador;
		else
			return null;
	}

	public EdificioPilon construirAsentamiento() {
		
		EdificioPilon pilon = new EdificioPilon();
		if(recursos.descontar(pilon.costoRecursos()))
			return pilon;
		else
			return null;
	}

	public EdificioAcceso construirAcceso() {
		
		EdificioAcceso acceso = new EdificioAcceso(recursos, suministros);
		if(recursos.descontar(acceso.costoRecursos()))	
			return (acceso);
		else
			return null;
	}

	public EdificioPuertoEstelarProtos construirPuertoEstelarProtos() {

		EdificioPuertoEstelarProtos puerto = new EdificioPuertoEstelarProtos(recursos, suministros);
		
		if(recursos.descontar(puerto.costoRecursos()))			
			for(int i = 0; i < edificios.size(); i++)
				if(edificios.get(i) instanceof EdificioAcceso)
					return puerto;			
		
		return null;
	}

	public EdificioArchivosTemplarios crearArchivosTemplarios() {
		
		EdificioArchivosTemplarios arch = new EdificioArchivosTemplarios(recursos, suministros);
		
		if(recursos.descontar(arch.costoRecursos()))
			for(int i = 0; i < edificios.size(); i++)
				if(edificios.get(i) instanceof EdificioPuertoEstelarProtos)
					return arch;
			
		return null;
	}
}
