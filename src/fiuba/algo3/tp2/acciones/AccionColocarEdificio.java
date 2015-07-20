package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificable;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRecolectorDeMineral;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioRecolectorDeVespeno;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EnConstruccion;

public class AccionColocarEdificio extends AccionDelMapa{

	public AccionColocarEdificio(Mapa unMapa) {
		super(unMapa);
	}
	
	public void realizar(Posicion posicion, Edificable edificio) throws PosicionInvalida{
		
		if(!(edificio instanceof EnConstruccion))
			mapa.removerObjeto(posicion, mapa.tierra, edificio.tamanio());
				
		if(edificio instanceof EdificioRecolectorDeMineral)
			this.colocarRecolectorDeMineral(posicion, (EdificioRecolectorDeMineral) edificio);
		else
			if(edificio instanceof EdificioRecolectorDeVespeno)
				this.colocarRecolectorDeGasVespeno(posicion, (EdificioRecolectorDeVespeno) edificio);
		else
			this.colocarEdificio(posicion, (Edificio) edificio);
				
		edificio.posicion(posicion);			
	}
	
	private void colocarEdificio(Posicion posicion, Edificio edificio) throws PosicionInvalida {
		
		if(preguntar.hayTerreno(posicion, edificio.tamanio())){
			
			mapa.colocarObjeto(posicion, mapa.tierra, edificio, edificio.tamanio());
		}
		else
			throw new PosicionInvalida();
	}

	private void colocarRecolectorDeMineral(Posicion posicion, EdificioRecolectorDeMineral edificio) throws PosicionInvalida {
		
		if(preguntar.hayMineral(posicion)){
								
			mapa.colocarObjeto(posicion, mapa.tierra, edificio);
			edificio.extraeDe((RecursoMineral) mapa.contenido(posicion, mapa.suelo));
		}
		else
			throw new PosicionInvalida();
	}

	private void colocarRecolectorDeGasVespeno(Posicion posicion, EdificioRecolectorDeVespeno edificio) throws PosicionInvalida {
		
		if(preguntar.hayGasVespeno(posicion)){
			
			mapa.colocarObjeto(posicion, mapa.tierra, edificio);
			edificio.extraeDe((RecursoGasVespeno) mapa.contenido(posicion, mapa.suelo));
		}
		else
			throw new PosicionInvalida();
	}

}