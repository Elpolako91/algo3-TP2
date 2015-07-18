package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;

public class AccionAtacarTierra extends AccionDelJugador{

	public AccionAtacarTierra(Mapa unMapa) {
		super(unMapa);
	}

	public void realizar(Posicion posicionDeAtaque, ObjetoDelMapa objeto ) throws PosicionInvalida, UnidadMovimientoTerminado {
				
		Unidad unidadAtacante = (Unidad) objeto;
		int distanciaAtaque = unidadAtacante.posicion().distancia(posicionDeAtaque);
		
		if( (distanciaAtaque > unidadAtacante.rango()) || (!preguntar.estaOcupadoTierra(posicionDeAtaque)))
				throw new PosicionInvalida();
		
		if (unidadAtacante.ataquePosible()) {
			
			Raza objetoTerrestre = (Raza) mapa.contenido(posicionDeAtaque, mapa.tierra);
			objetoTerrestre.disminuirVida(unidadAtacante.danioTierra());
			
			unidadAtacante.turnoTerminado();
			
			if (objetoTerrestre.estaDestruido()){
				
				if( objetoTerrestre instanceof Edificio)
					mapa.removerObjeto(((Edificio) objetoTerrestre).posicion(), mapa.tierra, ((Edificio) objetoTerrestre).tamanio());
				else
					mapa.removerObjeto(posicionDeAtaque, mapa.tierra);
				
				objetoTerrestre.posicion(null);				
			}			
		}
		else
			throw new UnidadMovimientoTerminado();
	}
}