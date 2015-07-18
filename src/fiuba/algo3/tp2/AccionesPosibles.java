package fiuba.algo3.tp2;

public class AccionesPosibles {

	private AccionColocarEnSuelo colocarEnSuelo;
	private AccionColocarEdificio colocarEdificio;
	private AccionColocarUnidad colocarUnidad;
	
	private AccionMoverUnidad mover;
	
	private AccionAtacarTierra atacarTierra;
	private AccionAtacarAire atacarAire;
	
	private AccionCargarUnidad cargarUnidad;
	private AccionDescargarUnidad descargarUnidad;
	
	private AccionPreguntar preguntar;
	
	public AccionesPosibles(Mapa unMapa){
		
		colocarEnSuelo = new AccionColocarEnSuelo(unMapa);
		colocarEdificio = new AccionColocarEdificio(unMapa);
		colocarUnidad = new AccionColocarUnidad(unMapa);
		
		mover = new AccionMoverUnidad(unMapa);
		
		atacarTierra = new AccionAtacarTierra(unMapa);
		atacarAire = new AccionAtacarAire(unMapa);
		
		cargarUnidad = new AccionCargarUnidad(unMapa);
		
		preguntar = new AccionPreguntar(unMapa);
	}
		
	public AccionColocarEnSuelo colocarEnSuelo(){
		return colocarEnSuelo;
	}
	
	public AccionColocarUnidad colocarUnidad(){
		return colocarUnidad;
	}
	
	public AccionColocarEdificio colocarEdificio(){
		return colocarEdificio;
	}
	
	public AccionMoverUnidad mover(){
		return mover;
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
	
	public AccionCargarUnidad cargar(){
		return cargarUnidad;
	}
	
	public AccionDescargarUnidad descargar(){
		return descargarUnidad;
	}
}
