package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;

public class Celda {
	
	private ObjetoDelMapa contenido;
	
	public Celda(ObjetoDelMapa unContenido){
		contenido = unContenido;
	}

	public ObjetoDelMapa contenido() {	
		return contenido;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return true;
	}
}