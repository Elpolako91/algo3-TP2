package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.acciones.AccionPreguntar;
import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Tamanio;
import fiuba.algo3.tp2.objetosDelMapa.RecursoGasVespeno;
import fiuba.algo3.tp2.objetosDelMapa.RecursoMineral;
import fiuba.algo3.tp2.objetosDelMapa.Terreno;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioDeposito;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadEspectro;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;

public class TestAccionPreguntar {
	
	private Mapa mapa;
	private AccionPreguntar accion;
		
	@Before
	public void setUp(){
		
		mapa = new Mapa(new Tamanio(10,10));
		accion = new AccionPreguntar(mapa);
	}
	
	@Test
	public void testHayTerreno(){
			
		Posicion pos = new Posicion (1,1);
		
		try {
			mapa.colocarObjeto(pos, mapa.suelo, new Terreno());
			
			assertTrue(accion.hayTerreno(pos));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testNoHayTerreno(){
				
		Posicion pos = new Posicion (1,1);
						
		try {
			mapa.colocarObjeto(pos, mapa.tierra, new Terreno());
			
			assertFalse(accion.hayTerreno(pos));
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testHayTerrenoConTamanio(){
				
		Posicion pos = new Posicion (1,1);
		Tamanio tamanio = new Tamanio(2,2);
		
		try {
			mapa.colocarObjeto(pos, mapa.suelo, new Terreno(), tamanio);
			
			assertTrue(accion.hayTerreno(pos,tamanio));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testNoHayTerrenoConTamanio(){
				
		Posicion pos = new Posicion (1,1);
		Tamanio tamanio = new Tamanio(2,2);
		
		try {
			mapa.colocarObjeto(pos, mapa.suelo, new Terreno());
			
			assertFalse(accion.hayTerreno(pos,tamanio));
			
		} catch (PosicionInvalida e) {}				
	}
	
	@Test
	public void testNoHayTerrenoConTamanioBis(){
		
		Posicion pos = new Posicion (1,1);
		Tamanio tamanio = new Tamanio(2,2);
		
		try {
			mapa.colocarObjeto(pos, mapa.tierra, new Terreno(), tamanio);
			assertFalse(accion.hayTerreno(pos,tamanio));
			
		} catch (PosicionInvalida e) {}		
	}

	@Test
	public void testEstaOcupadoLaTierra(){
				
		Posicion pos = new Posicion (1,1);
		UnidadMarine marine = new UnidadMarine();
		
		try {
			mapa.colocarObjeto(pos, mapa.tierra, marine);
			
			assertTrue(accion.estaOcupadoTierra(pos));
			assertTrue(accion.hayEnTierra(pos, marine));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testEstaOcupadoElAire(){
				
		Posicion pos = new Posicion (1,1);
		UnidadEspectro espectro = new UnidadEspectro();
		
		try {
			mapa.colocarObjeto(pos, mapa.aire, espectro);
			
			assertTrue(accion.estaOcupadoAire(pos));
			assertTrue(accion.hayEnAire(pos, espectro));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testNoEstaOcupadoAireNiTierra(){
		
		Posicion pos = new Posicion (1,1);
						
		try {
			assertFalse(accion.estaOcupadoAire(pos));
			assertFalse(accion.estaOcupadoTierra(pos));
			
		} catch (PosicionInvalida e) {}
	}
	
	@Test
	public void testHayGasVespeno(){
		
		Posicion pos = new Posicion (1,1);
		
		try {
			mapa.colocarObjeto(pos, mapa.suelo, new RecursoGasVespeno(1000));
			
			assertTrue(accion.hayGasVespeno(pos));
			
		} catch (PosicionInvalida e) {}		
	}
	
	@Test
	public void testHayMineral(){
		
		Posicion pos = new Posicion (1,1);
		
		try {
			mapa.colocarObjeto(pos, mapa.suelo, new RecursoMineral(1000));
			
			assertTrue(accion.hayMineral(pos));
			
		} catch (PosicionInvalida e) {}	
	}
	
	@Test
	public void testEdificioOcupaLaTierra(){
		
		Posicion pos = new Posicion (1,1);
		EdificioDeposito edificio = new EdificioDeposito();
		
		try {
			mapa.colocarObjeto(pos, mapa.tierra, edificio);
			
			assertTrue(accion.estaOcupadoTierra(pos));
			assertTrue(accion.hayEnTierra(pos, edificio));
			
		} catch (PosicionInvalida e) {}		
	}
}
