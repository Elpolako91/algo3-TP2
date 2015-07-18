package fiuba.algo3.tp2.acciones;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelJugador;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;
import fiuba.algo3.tp2.objetosDelMapa.unidades.Unidad;

public class AccionAtacarAire extends AccionDelJugador{
	
	public AccionAtacarAire(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicionDeAtaque, ObjetoDelMapa objeto) throws PosicionInvalida, UnidadMovimientoTerminado {
		
		Unidad unidadAtacante = (Unidad) objeto;
		int distanciaAtaque = unidadAtacante.posicion().distancia(posicionDeAtaque);
		
		if( (distanciaAtaque > unidadAtacante.rangoAire()) || (!preguntar.estaOcupadoAire(posicionDeAtaque)))
			throw new PosicionInvalida();
		
		if (unidadAtacante.ataquePosible()) {
			
			ObjetoDelJugador objetoAereo = (ObjetoDelJugador) mapa.contenido(posicionDeAtaque, mapa.aire);
			objetoAereo.disminuirVida(unidadAtacante.danioAire());
			
			unidadAtacante.turnoTerminado();
			
			if (objetoAereo.estaDestruido()){
				mapa.removerObjeto(posicionDeAtaque, mapa.aire);
				objetoAereo.posicion(null);				
			}
		}	
		else
			throw new UnidadMovimientoTerminado();
	}
}