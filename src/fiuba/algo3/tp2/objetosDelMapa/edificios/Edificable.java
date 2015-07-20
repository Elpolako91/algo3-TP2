package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;

public interface Edificable {

	Tamanio tamanio();

	void posicion(Posicion posicion);

	Posicion posicion();

}
