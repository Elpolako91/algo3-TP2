package fiuba.algo3.tp2;

import static org.junit.Assert.*;

import org.junit.Test;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.RecursosDelJugador;
import fiuba.algo3.tp2.juego.Suministro;
import fiuba.algo3.tp2.objetosDelMapa.edificios.EdificioBarraca;
import fiuba.algo3.tp2.objetosDelMapa.unidades.UnidadMarine;

public class TestJugador {
		
	@Test 
	public void testCrearJugador(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		assertEquals(jugador.nombre(), "facu");
		assertEquals(jugador.color(),"rojo");
		assertEquals(jugador.raza(), "terran");
		assertEquals(jugador.suministros().suministroTotal(), 5);
	}
	
	@Test 
	public void testJugadorAgregarEdificio(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		
		EdificioBarraca barraca = new EdificioBarraca(new RecursosDelJugador(1000,1000), new Suministro());
		jugador.agregarEdificio(barraca);
		
		assertEquals(jugador.edificios(), 1);
	}
		
	@Test 
	public void testJugadorAgregarUnidad(){
		
		Jugador jugador = new Jugador("facu", "rojo", "terran");
		jugador.suministros().agregar(10);
		jugador.recursos().agregar(new RecursosDelJugador(1000, 1000));
		
		UnidadMarine marine = new UnidadMarine();		
		jugador.agregarUnidad(marine);
		
		assertEquals(jugador.unidades(), 1);
	}	
}