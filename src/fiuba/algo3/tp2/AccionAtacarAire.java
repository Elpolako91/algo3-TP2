package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;

public class AccionAtacarAire extends AccionDelJugador{
	
	public AccionAtacarAire(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion posicionDeAtaque, ObjetoDelMapa objeto) throws PosicionInvalida, UnidadMovimientoTerminado {
		
		Unidad unidadAtacante = (Unidad) objeto;
		int distanciaAtaque = unidadAtacante.posicion().distancia(posicionDeAtaque);
		
		if( (distanciaAtaque > unidadAtacante.rango()) || (!preguntar.estaOcupadoAire(posicionDeAtaque)))
			throw new PosicionInvalida();
		
		if (unidadAtacante.ataquePosible()) {
			
			Raza objetoAereo = (Raza) mapa.contenido(posicionDeAtaque, mapa.aire);
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