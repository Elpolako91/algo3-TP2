package fiuba.algo3.tp2;

public class Celda {
	
	protected Object contenido;

	public Celda() {
	}

	public void colocarRecursoEnCelda(Recurso recurso) {
		
		this.contenido = recurso;
		
	}

	public Object getContenidoDeCelda() {
	
		return contenido;
	}

	public void colocarEdificioEnCelda(EdificioTerran edificio) {
		
		this.contenido = edificio;
		
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

	public void colocarUnidadMovil(UnidadTerran unidad) {
		
		this.contenido = unidad;
		
	}

	public void contenido(Object objeto) {
		contenido = objeto;
		
	}


}
