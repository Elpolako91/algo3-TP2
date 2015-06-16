package fiuba.algo3.tp2;

public class AccionesPosibles {

	private AccionColocar colocar;
	private AccionMover mover;
	private AccionAtacar atacar;
	private AccionPreguntar preguntar;
	
	public AccionesPosibles(Mapa unMapa){
		colocar = new AccionColocar(unMapa);
		mover = new AccionMover(unMapa);
		atacar = new AccionAtacar(unMapa);
		preguntar = new AccionPreguntar(unMapa);
	}
	
	public AccionColocar colocar(){
		return colocar;
	}
	
	public AccionMover mover(){
		return mover;
	}
	
	public AccionAtacar atacar(){
		return atacar;
	}
	
	public AccionPreguntar preguntar(){
		return preguntar;
	}
}
