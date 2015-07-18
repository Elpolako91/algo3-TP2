package fiuba.algo3.tp2;

public enum TipoDeCapa {

	SUELO(0),AEREO(1),TERRESTRE(2);
	
	private int n;
	
	private TipoDeCapa(int i){
		
		n = i;
	}
	
	public int numero(){
		return n;
	}
}
