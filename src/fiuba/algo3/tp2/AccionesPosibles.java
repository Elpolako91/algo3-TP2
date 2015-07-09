package fiuba.algo3.tp2;

public class AccionesPosibles {

	private AccionColocarEnTierra colocarEnTierra;
	private AccionColocarEnAire colocarEnAire;
	private AccionColocarEnSuelo colocarEnSuelo;
	private AccionMoverUnidadTerrestre moverTerrestre;
	private AccionMoverUnidadAerea moverAerea;
	private AccionAtacarTierra atacarTierra;
	private AccionAtacarAire atacarAire;
	private AccionPreguntar preguntar;
	private AccionRemover remover;
	
	public AccionesPosibles(Mapa unMapa){
		
		colocarEnTierra = new AccionColocarEnTierra(unMapa);
		colocarEnAire = new AccionColocarEnAire(unMapa);
		colocarEnSuelo = new AccionColocarEnSuelo(unMapa);
		moverTerrestre = new AccionMoverUnidadTerrestre(unMapa);
		moverAerea = new AccionMoverUnidadAerea(unMapa);
		atacarTierra = new AccionAtacarTierra(unMapa);
		atacarAire = new AccionAtacarAire(unMapa);
		preguntar = new AccionPreguntar(unMapa);
		remover = new AccionRemover(unMapa);
	}
	
	public AccionColocarEnTierra colocarEnTierra(){
		return colocarEnTierra;
	}
	
	public AccionColocarEnSuelo colocarEnSuelo(){
		return colocarEnSuelo;
	}
	
	public AccionColocarEnAire colocarEnAire(){
		return colocarEnAire;
	}
	
	public AccionMoverUnidadTerrestre moverTerrestre(){
		return moverTerrestre;
	}
	
	public AccionMoverUnidadAerea moverAerea(){
		return moverAerea;
	}
	
	public AccionAtacarTierra atacarTierra(){
		return atacarTierra;
	}
	
	public AccionAtacarAire atacarAire(){
		return atacarAire;
	}
	
	public AccionPreguntar preguntar(){
		return preguntar;
	}

	public AccionRemover removerDeSuelo() {
		return remover;
	}
}
