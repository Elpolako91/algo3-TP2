package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.excepciones.RecursosInsuficientes;
import fiuba.algo3.tp2.juego.Suministro;

public class TestSuministro {
	
	@Test 
	public void testCrearSuministro(){
			
		Suministro suministro = new Suministro();
		
		assertEquals(suministro.suministroGastados(), 0);
		assertEquals(suministro.suministroTotal(),0);
	}
	
	@Test 
	public void testAgregarSuministro(){
			
		Suministro suministro = new Suministro();
		
		suministro.agregar(10);
		assertEquals(suministro.suministroGastados(), 0);
		assertEquals(suministro.suministroTotal(),10);
	}
	
	@Test 
	public void testQuitarSuministro(){
			
		Suministro suministro = new Suministro();
		
		suministro.agregar(10);
		suministro.quitar(5);
		
		assertEquals(suministro.suministroGastados(), 0);
		assertEquals(suministro.suministroTotal(),5);
	}
	
	@Test 
	public void testGastarSuministro(){
			
		Suministro suministro = new Suministro();
		
		suministro.agregar(10);
		try {
			suministro.gastar(5);
			
		} catch (RecursosInsuficientes e) {
		}
		
		assertEquals(suministro.suministroGastados(), 5);
		assertEquals(suministro.suministroTotal(),10);
	}
	
	@Test 
	public void testNoDeberiaGastarSuministroDeMas(){
			
		Suministro suministro = new Suministro();
		
		suministro.agregar(2);
		try {
			suministro.gastar(5);
			assertTrue(false);
			
		} catch (RecursosInsuficientes e) {}
		
		assertEquals(suministro.suministroGastados(), 0);
		assertEquals(suministro.suministroTotal(),2);
	}
	
	@Test 
	public void testReponerSuministro(){
			
		Suministro suministro = new Suministro();
		
		
		
		try {
			suministro.agregar(10);
			suministro.gastar(8);
			suministro.reponer(6);
			
		} catch (RecursosInsuficientes e) {}		
		
		assertEquals(suministro.suministroGastados(), 2);
		assertEquals(suministro.suministroTotal(),10);
	}

}