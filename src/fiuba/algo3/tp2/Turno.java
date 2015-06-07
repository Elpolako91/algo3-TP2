package fiuba.algo3.tp2;

public class Turno {
	
	private boolean miTurno = true;

	public boolean esTurno() {
		
		return miTurno;
		
	}

	public void terminoMiTurno() {
		
		this.miTurno = false;
		
	}

}
