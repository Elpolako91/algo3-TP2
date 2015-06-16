package fiuba.algo3.tp2;

public class PosicionMapa extends Posicion{

	private int z;

	public PosicionMapa(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int z(){
		return z;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x();
		result = prime * result + this.y();
		result = prime * result + z;
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
		PosicionMapa other = (PosicionMapa) obj;
		if (this.x() != other.x())
			return false;
		if (this.y() != other.y())
			return false;
		if (this.z() != other.z())
			return false;
		return true;
	}

	public PosicionMapa obtenerNuevaMovidaEn(int i, int j) {
		
			i = i+ this.x();
			j = j + this.y();
			
		return new PosicionMapa(i,j,this.z());
	}
	
	public PosicionMapa obtenerPosicionSuelo(Posicion pos){
		
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),0);
		return posMapa;
	}
	
	public PosicionMapa obtenerPosicionTerrestre(Posicion pos){
		
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),1);
		return posMapa;
	}
	
	public PosicionMapa obtenerPosicionAerea(Posicion pos){
		
		PosicionMapa posMapa = new PosicionMapa(pos.x(),pos.y(),2);
		return posMapa;
	}

}
