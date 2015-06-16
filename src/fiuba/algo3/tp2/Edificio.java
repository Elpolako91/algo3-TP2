package fiuba.algo3.tp2;

public interface Edificio extends Terrestre{
	
	public EdificioBarraca construirBarraca();

	public RecolectorDeRecursos construirRecolectorGasVespeno();

	public RecolectorDeRecursos construirRecolectorMineral();

	public Asentamiento construirAsentamiento();
	
	public EdificioFabrica construirFabrica();

	public EdificioPuertoEstelar construirPuertoEstelar();

	public EdificioAcceso construirAcceso();

	public EdificioArchivosTemplarios crearArchivosTemplarios();
}