package fiuba.algo3.tp2;

public class AccionAtacarAire extends AccionDelJugador{
	
	public AccionAtacarAire(Mapa unMapa) {
		super(unMapa);
	}

	@Override
	public void realizar(Posicion pos, Raza objeto) {
		
	Unidad unidadAtacante = (Unidad) objeto;
		
	if ((unidadAtacante.ataquePosible()) &&(unidadAtacante.posicion().distancia(pos) <= unidadAtacante.rango()) && (preguntar.estaOcupadoAire(pos))){
			
			PosicionMapa posMapa = new PosicionMapa(pos.x(), pos.y(), 2);
			UnidadAerea objetoAereo = (UnidadAerea) mapa.contenido(posMapa);
			objetoAereo.disminuirVida(unidadAtacante.danioAire());
			
			if (objetoAereo.estaDestruido()){
				mapa.removerObjeto(posMapa);
				objetoAereo.posicion(null);				
			}
			unidadAtacante.turnoTerminado();
		}
		
	}
}