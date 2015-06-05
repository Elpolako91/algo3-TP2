package fiuba.algo3.tp2;

public class Jugador {

	private String nombre;
	private String color;
	private String raza;
	
	public Jugador(String unNombre, String unColor, String unaRaza) {
		
		this.nombre = unNombre;
		this.color = unColor;
		this.raza = unaRaza;
	}
	public String nombre() {
		
		return this.nombre;
	}
	public Object color() {
		
		return this.color;
	}
	public Object raza() {
		
		return this.raza;
	}

}
