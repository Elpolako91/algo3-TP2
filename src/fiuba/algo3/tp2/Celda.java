package fiuba.algo3.tp2;

public class Celda {
	
	protected Object contenido;

	public void contenido(Object unObjeto) {		
		this.contenido = unObjeto;		
	}

	public Object contenido() {	
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
