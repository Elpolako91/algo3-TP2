package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.acciones.AccionColocarEnSuelo;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;

public class MapaDePrueba extends Mapa{
	
	private AccionColocarEnSuelo colocarSuelo;
	
	public MapaDePrueba() {
		
		super( new Tamanio(10,10));
		colocarSuelo = new AccionColocarEnSuelo(this);
		
		colocarSuelo.colocarTerrenoEnTodoElMapa();
		colocarSuelo.colocarRecurso(new Posicion(1, this.tamanio().enY()), new RecursoMineral(1000));
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX(), 1), new RecursoGasVespeno(1000));
	}
}
