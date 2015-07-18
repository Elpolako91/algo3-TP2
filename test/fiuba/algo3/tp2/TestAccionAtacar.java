package fiuba.algo3.tp2;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.acciones.AccionAtacarAire;
import fiuba.algo3.tp2.acciones.AccionAtacarTierra;
import fiuba.algo3.tp2.acciones.AccionColocarEdificio;
import fiuba.algo3.tp2.acciones.AccionColocarEnSuelo;
import fiuba.algo3.tp2.acciones.AccionColocarUnidad;
import fiuba.algo3.tp2.acciones.AccionPreguntar;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.excepciones.UnidadMovimientoTerminado;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadEspectro;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadZealot;

public class TestAccionAtacar {
	
private Mapa mapa;
	
	private AccionPreguntar preguntar;	
	private AccionColocarEnSuelo colocarSuelo;
	private AccionColocarUnidad	colocarUnidad;
	private AccionColocarEdificio colocarEdificio;
	
	private AccionAtacarTierra atacarTierra;
	private AccionAtacarAire atacarAire;
	
	private UnidadMarine marine1;
	private UnidadMarine marine2;
	private UnidadZealot zealot;
	
	private EdificioDeposito deposito;
	private UnidadEspectro espectro1;
	private UnidadEspectro espectro2;	
		
	@Before
	public void setUp(){
		mapa = new Mapa(new Tamanio(10,10));
		preguntar = new AccionPreguntar(mapa);
		
		colocarSuelo = new AccionColocarEnSuelo(mapa);
		colocarUnidad = new AccionColocarUnidad(mapa);
		colocarEdificio = new AccionColocarEdificio(mapa);
		
		atacarTierra = new AccionAtacarTierra(mapa);
		atacarAire = new AccionAtacarAire(mapa);
		
		marine1 = new UnidadMarine();
		marine2 = new UnidadMarine();
		zealot = new UnidadZealot();
		
		deposito = new EdificioDeposito();
		espectro1 = new UnidadEspectro();
		espectro2 = new UnidadEspectro();
	}
	
	/***************************** Tests atacar tierra *************************************************/
		
	@Test
	public void testUnidadAtacaAOtraAdistancia() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
			
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, marine2);
			
			atacarTierra.realizar(posicionPorAtacar, marine1);
			assertEquals(34, marine2.vidaActual());	
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}		
	}
	
	@Test
	public void testUnidadDebeAtacarUnaSolaVezPorTurno() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
			
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, marine2);
			
			atacarTierra.realizar(posicionPorAtacar, marine1);
			atacarTierra.realizar(posicionPorAtacar, marine1);
			
			assertTrue(false);			
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertEquals(34, marine2.vidaActual());	
	}
	
	@Test
	public void testUnidadAtacaAOtraSinDistancia() {
			
		Posicion posicionDeAtacante = new Posicion(4,5);
		Posicion posicionPorAtacar = new Posicion(5,5);		
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, zealot);
			colocarUnidad.realizar(posicionPorAtacar, marine1);
			
			atacarTierra.realizar(posicionPorAtacar, zealot);
			assertEquals(32, marine1.vidaActual());	
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}
	}
	
	@Test
	public void testUnidadNoDebeAtacarAlEstarFueraDeRango() {
		
		Posicion posicionDeAtacante = new Posicion(3,3);
		Posicion posicionPorAtacar = new Posicion(8,3);
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, marine2);
			
			atacarTierra.realizar(posicionPorAtacar, marine1);
			
			assertTrue(false);
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertEquals(40, marine2.vidaActual());	
	}
	
	@Test
	public void testUnidadAtacaEdificio() {
				
		Posicion posicionDeAtacante = new Posicion(3,3);
		Posicion posicionPorAtacar = new Posicion(7,3);
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarEdificio.realizar(posicionPorAtacar, deposito);
			
			atacarTierra.realizar(posicionPorAtacar, marine1);
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	

		assertEquals(494, deposito.vidaActual());	
	}
	
	@Test
	public void testUnidadAtacaEdificioBis() {
		
		Posicion posicionDeAtacante = new Posicion(7,3);
		Posicion posicionEdificio = new Posicion(2,2);
		
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarEdificio.realizar(posicionEdificio, deposito);
			
			atacarTierra.realizar(posicionEdificio.obtenerNuevaMovidaEn(1, 1), marine1);
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	

		assertEquals(494, deposito.vidaActual());
	}
	
	@Test
	public void testUnidadTerrestreMataAOtraTerrestre() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, marine2);
			
			for(int i = 0; i<10; i++){
				atacarTierra.realizar(posicionPorAtacar, marine1);
				marine1.empezarTurno();
			}
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	
		try {
			assertFalse(preguntar.hayEnTierra(posicionPorAtacar, marine2));
			assertEquals(0, marine2.vidaActual());
			
		} catch (PosicionInvalida e) {}	
	}
	
	@Test
	public void testDestruirEdificio() {
			
		Posicion posicionDeAtacante = new Posicion(5,5);
		Posicion posicionPorAtacar = new Posicion(6,6);	
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarEdificio.realizar(posicionPorAtacar, deposito);
			
			for(int i = 0; i<100; i++){
				atacarTierra.realizar(posicionPorAtacar.obtenerNuevaMovidaEn(1, 1), marine1);
				marine1.empezarTurno();
			}
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	
		try {
			assertEquals(0, deposito.vidaActual());
			assertFalse(preguntar.estaOcupadoTierra(posicionPorAtacar));
			
		} catch (PosicionInvalida e) {}	
	}
	
	@Test
	public void testUnidadAereaAtacaAUnidadTerrestre() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, espectro1);
			colocarUnidad.realizar(posicionPorAtacar, marine1);
			
			atacarTierra.realizar(posicionPorAtacar, espectro1);
			
			assertEquals(32, marine1.vidaActual());
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	}
	
	@Test
	public void testUnidadAtacaAlaNada() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);			
			atacarTierra.realizar(posicionPorAtacar, marine1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertTrue(marine1.ataquePosible());
	}
	
	@Test	
	public void testUnidadAereaAtacaAUnidadTerrestreEnLaMismaPosicion() {
		
		Posicion posicion = new Posicion(4,4);
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicion, marine1);
			colocarUnidad.realizar(posicion, espectro1);
			atacarTierra.realizar(posicion, espectro1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertEquals(32, marine1.vidaActual());
	}
	
	/************************************* test Ataque Aire ***********************************************/
	
	@Test
	public void testUnidadTerrestreAtacaAUnidadAereaEnDistintaPosicion() {
		
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);		
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, espectro1);
			atacarAire.realizar(posicionPorAtacar, marine1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertEquals(114, espectro1.vidaActual());
	}
	
	@Test
	public void testUnidadTerrestreAtacaAUnidadAereaEnLaMismaPosicion() {
		
		Posicion posicion = new Posicion(4,4);
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicion, marine1);
			colocarUnidad.realizar(posicion, espectro1);
			atacarAire.realizar(posicion, marine1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
		
		assertEquals(114, espectro1.vidaActual());
	}
	
	@Test
	public void testUnidadAereaAtacaAOtraUnidadAerea() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);		
	
		try {			
			colocarUnidad.realizar(posicionDeAtacante, espectro1);
			colocarUnidad.realizar(posicionPorAtacar, espectro2);
			atacarAire.realizar(posicionPorAtacar, espectro1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	
		assertEquals(100, espectro2.vidaActual());
	}	
	
	@Test
	public void testUnidadAereaAtacaALaNada() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);		
	
		try {			
			colocarUnidad.realizar(posicionDeAtacante, espectro1);
			atacarAire.realizar(posicionPorAtacar, espectro1);
						
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	
		assertTrue(espectro1.ataquePosible());
	}
	
	@Test
	public void testUnidadTerrestreMataAUnidadAerea() {
			
		Posicion posicionDeAtacante = new Posicion(4,4);
		Posicion posicionPorAtacar = new Posicion(6,6);	
	
		try {			
			colocarSuelo.colocarTerrenoEnTodoElMapa();
			colocarUnidad.realizar(posicionDeAtacante, marine1);
			colocarUnidad.realizar(posicionPorAtacar, espectro1);
			
			for(int i = 0; i<25; i++){
				atacarAire.realizar(posicionPorAtacar, marine1);
				marine1.empezarTurno();
			}
			
		} catch (PosicionInvalida | UnidadMovimientoTerminado e) {}	
	
		try {
			assertFalse(preguntar.hayEnAire(posicionPorAtacar, espectro1));
			assertEquals(0, espectro1.vidaActual());
			
		} catch (PosicionInvalida e) {}	
	}
}
