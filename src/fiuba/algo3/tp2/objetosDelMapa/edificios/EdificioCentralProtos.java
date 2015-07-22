package fiuba.algo3.tp2.objetosDelMapa.edificios;

import java.util.List;

import javax.swing.ImageIcon;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.excepciones.RequerimientosInsuficientes;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;

public class EdificioCentralProtos extends EdificioCentral{
	
	public EdificioCentralProtos(RecursosDelJugador recursosDisponibles, Suministro suministrosDisponibles,
			List<Edificio> edificiosJugador) {
		
		super("Central protos", 1000, 1000, recursosDisponibles, suministrosDisponibles, edificiosJugador, new ImageIcon(EdificioCentralProtos.class.getResource("/imagenes/razaProtos.jpg")));
	}

	public EdificioNexoMineral construirRecolectorMineral() throws RecursosInsuficientes {
		
		EdificioNexoMineral nexo = new EdificioNexoMineral(this.recursosDisponibles());
		this.recursosDisponibles().descontar(nexo.costoRecursos());
		return nexo;
	}

	public EdificioAsimilador construirRecolectorGasVespeno() throws RecursosInsuficientes {
		
		EdificioAsimilador asimilador = new EdificioAsimilador(this.recursosDisponibles());
		this.recursosDisponibles().descontar(asimilador.costoRecursos());
		return asimilador;
	}

	public EdificioPilon construirAsentamiento() throws RecursosInsuficientes {
		
		EdificioPilon pilon = new EdificioPilon();
		this.recursosDisponibles().descontar(pilon.costoRecursos());
		return pilon;
	}

	public EdificioAcceso construirAcceso() throws RecursosInsuficientes {
		
		EdificioAcceso acceso = new EdificioAcceso(this.recursosDisponibles(), this.suministros());
		this.recursosDisponibles().descontar(acceso.costoRecursos());
		return acceso;
	}

	public EdificioPuertoEstelarProtos construirPuertoEstelarProtos() throws RecursosInsuficientes, RequerimientosInsuficientes {

		boolean hayAcceso = false;
		
		for(int i = 0; i < this.edificios().size(); i++)
			if(this.edificios().get(i) instanceof EdificioAcceso)
				hayAcceso = true;
		
		if(hayAcceso){
			
			EdificioPuertoEstelarProtos puerto = new EdificioPuertoEstelarProtos(this.recursosDisponibles(), this.suministros());		
			this.recursosDisponibles().descontar(puerto.costoRecursos());
			return puerto;
		}
		else
			throw new RequerimientosInsuficientes();
	}

	public EdificioArchivosTemplarios crearArchivosTemplarios() throws RecursosInsuficientes, RequerimientosInsuficientes {
		
		boolean hayPuerto = false;
		
		for(int i = 0; i < this.edificios().size(); i++)
			if(this.edificios().get(i) instanceof EdificioPuertoEstelarProtos)
				hayPuerto = true;
		
		if(hayPuerto){
			
			EdificioArchivosTemplarios arch = new EdificioArchivosTemplarios(this.recursosDisponibles(), this.suministros());
			this.recursosDisponibles().descontar(arch.costoRecursos());		
			return arch;
		}
		else
			throw new RequerimientosInsuficientes();
	}
}
