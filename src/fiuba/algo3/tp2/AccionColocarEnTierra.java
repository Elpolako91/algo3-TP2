package fiuba.algo3.tp2;


public class AccionColocarEnTierra extends AccionDelJugador{	
		
	public AccionColocarEnTierra(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion unaPosicion, Raza objeto) {
		
		if (objeto instanceof EdificioEnConstruccion){
			
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
			
			if( objeto instanceof EdificioRecolectorDeMineral)
				this.colocarRecolectorDeMineral(unaPosicion, (EdificioRecolectorDeMineral) objeto);
			else
				if(objeto instanceof EdificioRecolectorDeVespeno)
					this.colocarRecolectorDeGasVespeno(unaPosicion, (EdificioRecolectorDeVespeno) objeto);
			else
				if (objeto instanceof UnidadTerrestre)
					this.colocarUnidadTerrestre(unaPosicion, (UnidadTerrestre) objeto);			
			else
				if(objeto instanceof Edificio)
					this.colocarEdificio(unaPosicion, (Edificio) objeto);
		}					
	}
	
	private boolean colocarUnidadTerrestre(Posicion posicion, UnidadTerrestre unidad) {
		
		if((preguntar.hayTerreno(posicion)) && ( (!preguntar.hayUnidadTerrestre(posicion)) && (!preguntar.hayEdificio(posicion)))){
			
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, unidad);
			unidad.posicion(posicion);
			return true;
		}
		else
			return false;
	}

	private boolean colocarEdificio(Posicion posicion, Edificio edificio) {
		
		if((preguntar.hayTerreno(posicion, edificio.tamanio())) && (!preguntar.hayUnidadTerrestre(posicion, edificio.tamanio())) && (!preguntar.hayEdificio(posicion, edificio.tamanio()))){
			
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			mapa.colocarObjeto(posTerrestre, edificio, edificio.tamanio());
			edificio.posicion(posicion);
			return true;
		}
		else
			return false;
		
	}

	private boolean colocarRecolectorDeMineral(Posicion posicion, Edificio recolectorMineral) {
		if(preguntar.hayMineral(posicion)){
			
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			
			if (recolectorMineral instanceof EdificioRecolectorDeMineral)
				((EdificioRecolectorDeMineral) recolectorMineral).extraeDe((RecursoMineral) mapa.contenido(posSuelo));
			
			mapa.colocarObjeto(posTerrestre, recolectorMineral);
			recolectorMineral.posicion(posicion);
			return true;
		}
		else
			return false;
	}

	private boolean colocarRecolectorDeGasVespeno(Posicion posicion, Edificio recolectorGasVespeno) {
		
		if(preguntar.hayGasVespeno(posicion)){
			
			PosicionMapa posSuelo = new PosicionMapa(posicion.x(),posicion.y(),0);
			PosicionMapa posTerrestre = new PosicionMapa(posicion.x(),posicion.y(),1);
			
			if (recolectorGasVespeno instanceof EdificioRecolectorDeVespeno)
				( (EdificioRecolectorDeVespeno) recolectorGasVespeno).extraeDe((RecursoGasVespeno) mapa.contenido(posSuelo));
			
			mapa.colocarObjeto(posTerrestre, recolectorGasVespeno);
			recolectorGasVespeno.posicion(posicion);
			
			return true;
		}
		else
			return false;
		
	}
}
