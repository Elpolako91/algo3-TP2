package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.edificios.Edificio;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public class AccionAtacarTierra extends AccionDelJugador{

	public AccionAtacarTierra(Mapa unMapa) {
		super(unMapa);
	}

	public void realizar(Posicion posicionDeAtaque, ObjetoDelMapa objeto ) throws PosicionInvalida, UnidadMovimientoTerminado {
				
		Unidad unidadAtacante = (Unidad) objeto;
		int distanciaAtaque = unidadAtacante.posicion().distancia(posicionDeAtaque);
		
		if( (distanciaAtaque > unidadAtacante.rangoTierra()) || (!preguntar.estaOcupadoTierra(posicionDeAtaque)))
				throw new PosicionInvalida();
		
		if (unidadAtacante.ataquePosible()) {
			
			ObjetoDelJugador objetoTerrestre = (ObjetoDelJugador) mapa.contenido(posicionDeAtaque, mapa.tierra);
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