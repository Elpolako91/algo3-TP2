package fiuba.algo3.tp2;

public class Jugador {
	
	private String nombre;
	private String color;
	private String raza;
	private Turno turno;
	
	public Jugador(String unNombre, String unColor, String unaRaza) {
		
		this.nombre = unNombre;
		this.color = unColor;
		this.raza = unaRaza;
		this.turno = new Turno();
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
	
	public boolean esMiTurno(){
		
		if ( turno.esTurno() ){
			
			return true;
			
		}else
			
			return false; /*Capaz una excepcion*/
	}
	public void pasarTurno() {
		
		this.turno.terminoMiTurno();
		
	}

}
