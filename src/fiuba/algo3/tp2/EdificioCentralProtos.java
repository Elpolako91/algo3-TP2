package fiuba.algo3.tp2;

import java.util.List;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;

public class EdificioCentralProtos extends EdificioCentral{
	
	public EdificioCentralProtos(RecursosDelJugador recursosJugador, Suministro suministroJugador, List<Edificio> edificiosJugador) {
		
		super(recursosJugador, suministroJugador, edificiosJugador);
		
		nombre = "Central Protos";
		vidaActual = 1000;
		vidaMaxima = 1000;
		escudoActual = 1000;
		escudoMaximo = 1000;
	}

	public EdificioNexoMineral construirRecolectorMineral() throws RecursosInsuficientes {
		
		EdificioNexoMineral nexo = new EdificioNexoMineral(recursos);
		recursos.descontar(nexo.costoRecursos());
		return nexo;
	}

	public EdificioAsimilador construirRecolectorGasVespeno() throws RecursosInsuficientes {
		
		EdificioAsimilador asimilador = new EdificioAsimilador(recursos);
		recursos.descontar(asimilador.costoRecursos());
		return asimilador;
	}

	public EdificioPilon construirAsentamiento() throws RecursosInsuficientes {
		
		EdificioPilon pilon = new EdificioPilon();
		recursos.descontar(pilon.costoRecursos());
		return pilon;
	}

	public EdificioAcceso construirAcceso() throws RecursosInsuficientes {
		
		EdificioAcceso acceso = new EdificioAcceso(recursos, suministros);
		recursos.descontar(acceso.costoRecursos());
		return acceso;
	}

	public EdificioPuertoEstelarProtos construirPuertoEstelarProtos() throws RecursosInsuficientes {

		boolean hayAcceso = false;
		
		EdificioPuertoEstelarProtos puerto = new EdificioPuertoEstelarProtos(recursos, suministros);		
		recursos.descontar(puerto.costoRecursos());		
		
		for(int i = 0; i < edificios.size(); i++)
			if(edificios.get(i) instanceof EdificioAcceso)
				hayAcceso = true;
		
		if(hayAcceso)
			return puerto;
		else
			throw new RecursosInsuficientes();
	}

	public EdificioArchivosTemplarios crearArchivosTemplarios() throws RecursosInsuficientes {
		
		boolean hayPuerto = false;
		EdificioArchivosTemplarios arch = new EdificioArchivosTemplarios(recursos, suministros);
		
		recursos.descontar(arch.costoRecursos());
		for(int i = 0; i < edificios.size(); i++)
			if(edificios.get(i) instanceof EdificioPuertoEstelarProtos)
				hayPuerto = true;
		
		if(hayPuerto)
			return arch;
		else
			throw new RecursosInsuficientes();
	}
}
