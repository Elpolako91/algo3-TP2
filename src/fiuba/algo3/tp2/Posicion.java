package fiuba.algo3.tp2;

import java.util.Random;

public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int obtenerPosicionCercanaEnX(int i) {
		
		return ( this.x + i );
		
	}
	
	public int obtenerPosicionCercanaEnY(int j) {
		
		return ( this.y + j );
		
	}
	
	public int distancia(Posicion p2){
		
		int distancia= (int) Math.sqrt(Math.pow(this.x-p2.x, 2)+Math.pow(this.y-p2.y,2));
		
		return distancia;
	}

	public Posicion obtenerPosicionAlrededor() {	//IMPLEMENTAR BIEN CON RANDOM DE incremento de -1 a 1
		 		
		Posicion posicion = new Posicion(this.x +1, this.y +1);
		return posicion;
	}
	
	public int x(){
		return x;
	}

	public int y() {
		return y;
	}

	public Posicion direccion(Posicion p2) {
		int i=0,j=0;
		if (this.x> p2.x())i=-1;
		else 
			if(this.x < p2.x()) i =1;
			
		if (this.y> p2.y())j =-1;
		else
		if(this.y < p2.y()) j = 1;
						
		i=i+ this.x;
		j=j+ this.y;
		
		Posicion direccion= new Posicion(i,j);
		return direccion;
	}


}
