package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.acciones.AccionColocarEnSuelo;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;

public class Mapa1 extends Mapa{
	
	private AccionColocarEnSuelo colocarSuelo;
	
	public Mapa1(Tamanio tamanio) {
		super(tamanio);
		colocarSuelo = new AccionColocarEnSuelo(this);
		
		colocarSuelo.colocarTerrenoEnTodoElMapa();
		
		colocarSuelo.colocarRecurso(new Posicion(1, 5), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(2, 5), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(1, 6), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(2, 6), new RecursoMineral(5000));
		
		colocarSuelo.colocarRecurso(new Posicion(5, 1), new RecursoGasVespeno(5000));
		colocarSuelo.colocarRecurso(new Posicion(5, 2), new RecursoGasVespeno(5000));
		
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-5, 1), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-4, 1), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-3, 1), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-2, 1), new RecursoMineral(5000));
		
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-5, 2), new RecursoGasVespeno(5000));
		colocarSuelo.colocarRecurso(new Posicion(this.tamanio().enX()-2, 2), new RecursoGasVespeno(5000));
		
		colocarSuelo.colocarRecurso(new Posicion(1, this.tamanio().enY()-5), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(1, this.tamanio().enY()-6), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(2, this.tamanio().enY()-5), new RecursoMineral(5000));
		colocarSuelo.colocarRecurso(new Posicion(2, this.tamanio().enY()-6), new RecursoMineral(5000));
		
		colocarSuelo.colocarRecurso(new Posicion(1, this.tamanio().enY()), new RecursoGasVespeno(5000));
		colocarSuelo.colocarRecurso(new Posicion(2, this.tamanio().enY()), new RecursoGasVespeno(5000));
		
		colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX()/2,this.tamanio().enX()/4), 3);
		colocarSuelo.colocarAireAlrededorDe(new Posicion((this.tamanio().enX()/2)-4,this.tamanio().enX()/4), 2);
		colocarSuelo.colocarAireAlrededorDe(new Posicion((this.tamanio().enX()/2)-6,this.tamanio().enX()/4), 1);
		colocarSuelo.colocarAireAlrededorDe(new Posicion((this.tamanio().enX()/2)-8,this.tamanio().enX()), 2);
		colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX()/2,(this.tamanio().enX()/4)-4), 2);
		colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX()/2,(this.tamanio().enX()/4)-6), 1);
		colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX(),(this.tamanio().enX()/4)-8), 2);
		
		colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX()/4,this.tamanio().enX()/2), 3);
		colocarSuelo.colocarAireAlrededorDe(new Posicion((this.tamanio().enX()/4)-4,this.tamanio().enX()/2), 2);
		
		for(int i = 0; i <= 15; i++){
			colocarSuelo.colocarAireAlrededorDe(new Posicion(this.tamanio().enX()/2,(this.tamanio().enY()/4)+i), 3);
			colocarSuelo.colocarAireAlrededorDe(new Posicion((this.tamanio().enX()/4)+i,(this.tamanio().enY()/2)), 3);
		}
	}

}
