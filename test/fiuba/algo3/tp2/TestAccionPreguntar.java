package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAccionPreguntar {
		
	@Test
	public void testHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,0);
		
		mapa.colocarObjeto(posMapa, new Terreno());
				
		assertTrue(accion.hayTerreno(pos));
	}
	
	@Test
	public void testNoHayTerreno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
						
		assertFalse(accion.hayTerreno(pos));
	}
	
	@Test
	public void testHayTerrenoConTamanio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,0);
		Tamanio tamanio = new Tamanio(2,2);
		
		mapa.colocarObjeto(posMapa, new Terreno(), tamanio);
				
		assertTrue(accion.hayTerreno(pos,tamanio));
	}
	
	@Test
	public void testNoHayTerrenoConTamanio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,0);
		Tamanio tamanio = new Tamanio(2,2);
		
		mapa.colocarObjeto(posMapa, new Terreno());
				
		assertFalse(accion.hayTerreno(pos,tamanio));
	}
	
	@Test
	public void testNoHayTerrenoConTamanioBis(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(2,2,0);
		Tamanio tamanio = new Tamanio(2,2);
		
		mapa.colocarObjeto(posMapa, new Terreno());
				
		assertFalse(accion.hayTerreno(pos,tamanio));
	}

	@Test
	public void testHayUnidadTerrestre(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,1);
		
		mapa.colocarObjeto(posMapa, new UnidadMarine());
				
		assertTrue(accion.hayUnidadTerrestre(pos));
	}
	
	@Test
	public void testNoHayUnidadTerrestre(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
						
		assertFalse(accion.hayUnidadTerrestre(pos));
	}
	
	@Test
	public void testHayGasVespeno(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,0);
		
		mapa.colocarObjeto(posMapa, new RecursoGasVespeno());
				
		assertTrue(accion.hayGasVespeno(pos));
	}
	
	@Test
	public void testHayMineral(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,0);
		
		mapa.colocarObjeto(posMapa, new RecursoMineral());
				
		assertTrue(accion.hayMineral(pos));
	}
	
	@Test
	public void testHayEdificio(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
		PosicionMapa posMapa = new PosicionMapa(1,1,1);
		
		mapa.colocarObjeto(posMapa, new Barraca());
				
		assertTrue(accion.hayEdificio(pos));
	}
	
	@Test
	public void testEstaFueraDelMapa(){
		
		Mapa mapa = new Mapa(new Tamanio(10,10));
		AccionPreguntar accion = new AccionPreguntar(mapa);
		
		Posicion pos = new Posicion (1,1);
				
		assertFalse(accion.estaFueraDelMapa(pos));
	}
}
