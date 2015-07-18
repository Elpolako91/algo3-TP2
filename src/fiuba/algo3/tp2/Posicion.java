package fiuba.algo3.tp2;

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
	
	public int x(){
		return x;
	}

	public int y() {
		return y;
	}
	
	public int distancia(Posicion p2){
		
		int distancia= Math.abs(this.x-p2.x)+Math.abs(this.y-p2.y);
		return distancia;
	}

	public Posicion obtenerPosicionAlrededor() {	//IMPLEMENTAR BIEN CON RANDOM DE incremento de -1 a 1
		 		
		Posicion posicion = new Posicion(this.x +1, this.y +1);
		return posicion;
	}

	public Posicion direccion(Posicion p2) {
		
		int i=0,j=0;
		
		if (this.x> p2.x())	i=-1;
			else 
		if (this.x < p2.x()) i =1;
		
			
		if (this.y> p2.y())j =-1;
			else
		if (this.y < p2.y()) j = 1;
		
		return this.obtenerNuevaMovidaEn(i, j);
	}

	public Posicion obtenerNuevaMovidaEn(int i, int j) {
		
			i = i+ this.x();
			j = j + this.y();
			
		return new Posicion(i,j);
	}
		
	public boolean estaDentro(Tamanio t){
		if((this.x() >= 1) && (this.x() <= t.enX()) && (this.y() >= 1) && (this.y() <= t.enY()))
			return true;
		else
			return false;		
	}
	
	public Posicion posicionEnEspiral(Posicion posicionAnterior){
		
		Posicion posicionActual = this;
		int i = 0, j = 0, max = 1;
		int mov = 0;
		
		while(!(posicionAnterior.equals(posicionActual))){
			switch(mov){			
			case 0:
				i++;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(1, 0);
				if(i == max) 
					mov = 1;
			break;
			
			case 1:
				j++;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(0,1);
				if(j == max){
					mov = 2;
				}
			break;		
			
			case 2:
				i--;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(-1, 0);
				if(-i == max)
					mov = 3;
			break;
			
			case 3: 
				j--;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(0, -1);
				if(-j == max){
					mov = 0;
					max ++;
				}
			break;
			}
			
		}
		
			switch(mov){			
			case 0:
				i++;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(1, 0);
				if(i == max)
					mov = 1;
			break;
			
			case 1:
				j++;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(0,1);
				if(j == max){
					mov = 2;
				}
			break;		
			
			case 2:
				i--;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(-1, 0);
				if(-i == max)
					mov = 3;
			break;
			
			case 3: 
				j--;
				posicionActual = posicionActual.obtenerNuevaMovidaEn(0, -1);
				if(-j == max){
					mov = 0;
					max ++;
				}
			break;
		}
		return posicionActual;
		
	}
}
