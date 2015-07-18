package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;

public class AccionColocarEdificio extends AccionDelJugador{	
		
	public AccionColocarEdificio(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion unaPosicion, ObjetoDelMapa objeto) throws PosicionInvalida {
		
	/*	if (objeto instanceof EdificioEnConstruccion){
			
			if(((EdificioEnConstruccion) objeto).edificioTerminado() instanceof EdificioRecolectorDeMineral)
				this.colocarRecolectorDeMineral(unaPosicion, (Edificio) objeto);
			else
				if(((EdificioEnConstruccion) objeto).edificioTerminado() instanceof EdificioRecolectorDeVespeno)
					this.colocarRecolectorDeGasVespeno(unaPosicion, (Edificio) objeto);
			else
				if(objeto instanceof Edificio)
					this.colocarEdificio(unaPosicion, (EdificioEnConstruccion) objeto);
		}
		else{
		*/	
			if( objeto instanceof EdificioRecolectorDeMineral)
				this.colocarRecolectorDeMineral(unaPosicion, (EdificioRecolectorDeMineral) objeto);
			else
				if(objeto instanceof EdificioRecolectorDeVespeno)
					this.colocarRecolectorDeGasVespeno(unaPosicion, (EdificioRecolectorDeVespeno) objeto);	
			else
				if(objeto instanceof Edificio)
					this.colocarEdificio(unaPosicion, (Edificio) objeto);
		//}					
	}
	
	

	private void colocarEdificio(Posicion posicion, Edificio edificio) throws PosicionInvalida {
		
		if(preguntar.hayTerreno(posicion, edificio.tamanio())){
			
			mapa.colocarObjeto(posicion, mapa.tierra, edificio, edificio.tamanio());
			edificio.posicion(posicion);
		}		
	}

	private void colocarRecolectorDeMineral(Posicion posicion, EdificioRecolectorDeMineral recolectorMineral) throws PosicionInvalida {
		
		if(preguntar.hayMineral(posicion)){
								
			mapa.colocarObjeto(posicion, mapa.tierra, recolectorMineral);
			recolectorMineral.extraeDe((RecursoMineral) mapa.contenido(posicion, mapa.suelo));
			recolectorMineral.posicion(posicion);
		}
	}

	private void colocarRecolectorDeGasVespeno(Posicion posicion, EdificioRecolectorDeVespeno recolectorGasVespeno) throws PosicionInvalida {
		
		if(preguntar.hayGasVespeno(posicion)){
			
			mapa.colocarObjeto(posicion, mapa.tierra, recolectorGasVespeno);
			recolectorGasVespeno.extraeDe((RecursoGasVespeno) mapa.contenido(posicion, mapa.suelo));
			recolectorGasVespeno.posicion(posicion);
		}		
	}
}