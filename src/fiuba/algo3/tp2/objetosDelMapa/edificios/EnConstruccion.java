package fiuba.algo3.tp2.objetosDelMapa.edificios;

import fiuba.algo3.tp2.mapa.Posicion;

public interface EnConstruccion extends Edificable {

	int tiempoConstruccion();

	void progresa();

	Edificio edificioTerminado();

	void posicion(Posicion posicion);

	boolean estaDestruido();
}
