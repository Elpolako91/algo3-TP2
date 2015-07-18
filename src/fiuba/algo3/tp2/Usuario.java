package fiuba.algo3.tp2;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadEnemigaSeleccionada;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;

public class Usuario {
	
	private JuegoCraft juego;
	
	private Object objetoARealizar;
	private Object objetoSeleccionado;
	private boolean colocarEdificio = false;
	private boolean mover= false;
	private boolean atacarTierra = false;
	private boolean atacarAire = false;
	private boolean cargarUnidad = false;
	private boolean descargarUnidad = false;
	
	
	public Usuario(JuegoCraft unJuego){
		juego = unJuego;
	}
	
	public Jugador jugadorActual() {
		return juego.jugadorActual();
	}

	public void pasarTurno() {
		juego.pasarTurno();
	}

	public void colocarEdificio(Edificio edificio, Posicion posicion) throws PosicionInvalida {
		juego.colocarEdificio(edificio, posicion);
	}
	
	public void moverUnidad(Unidad unidad, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado {
		juego.moverUnidad(unidad, posicion);
	}
	
	public void atacarTierra(Unidad unidadAtacante, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado{
		juego.atacarTierra(unidadAtacante, posicion);
	}
	
	public void atacarAire(Unidad unidadAtacante, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada, UnidadMovimientoTerminado{
		juego.atacarAire(unidadAtacante, posicion);
	}
	
	public void cargarUnidad(UnidadTransporte transporte, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada{
		juego.cargarUnidad(transporte, posicion);
	}
	
	public void descargarUnidades(UnidadTransporte transporte, Posicion posicion) throws PosicionInvalida, UnidadEnemigaSeleccionada{
		juego.descargarUnidad(transporte, posicion);
	}
	
	public void seleccionar(Posicion posicion){
		
	}
	
	/************** para el control de vista *********************************/
	
	public void edificioAConstruir(Edificio edificio) {		
		objetoARealizar = edificio;		
	}

	public Object edificioAConstruir() {		
		return objetoARealizar;
	}

	public Object objetoSeleccionado() {
		
		return objetoSeleccionado;
	}

	public void objetoSeleccionado(Object objetoSeleccionado) {
		
		this.objetoSeleccionado = objetoSeleccionado;		
	}

	public void accionMover(boolean boleano) {
		
		this.mover  = boleano;
	}
	
	public boolean getAccionMover(){
		
		return this.mover;
	}
	
	public void accionAtacarTierra(boolean boleano) {
		
		this.atacarTierra = boleano;
	}
	
	public boolean getAccionAtacarTierra(){
		
		return this.atacarTierra;
	}

	public void accionAtacarAire(boolean boleano) {
		
		this.atacarAire = true;
	}
	
	public boolean getAccionAtacarAire(){
		
		return this.atacarAire;
	}

	public void colocarEdificio(boolean boleano) {
		
		this.colocarEdificio = boleano;
	}

	public boolean getColocarEdificio(){
		
		return this.colocarEdificio;
	}	
}