package fiuba.algo3.tp2.mapa;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.tp2.excepciones.PosicionInvalida;
import fiuba.algo3.tp2.objetosDelMapa.ObjetoDelMapa;

public class Mapa {
	
	private Tamanio tamanio;
	
	public TipoDeCapa suelo = TipoDeCapa.SUELO;
	public TipoDeCapa tierra = TipoDeCapa.TERRESTRE;
	public TipoDeCapa aire = TipoDeCapa.AEREO;
	
	private List<CapaDeMapa> capas = new ArrayList<CapaDeMapa>();
	
	public Mapa(Tamanio unTamanio){
		
		tamanio = unTamanio;
		
		CapaDeMapa capaSuelo = new CapaDeMapa(unTamanio);
		capas.add(capaSuelo);
		
		CapaDeMapa capaTerrestre = new CapaDeMapa(unTamanio);
		capas.add(capaTerrestre);
		
		CapaDeMapa capaAerea = new CapaDeMapa(unTamanio);
		capas.add(capaAerea);
	}
	
	public Tamanio tamanio() {
		return tamanio;
	}

	public Object contenido(Posicion posicion, TipoDeCapa tipoDeCapa) throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		return capa.contenido(posicion);
	}
	
	public void colocarObjeto(Posicion posicion, TipoDeCapa tipoDeCapa, ObjetoDelMapa objeto) throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		capa.colocarObjeto(posicion, objeto);		
	}

	public void colocarObjeto(Posicion posicion, TipoDeCapa tipoDeCapa, ObjetoDelMapa objetoConTamanio, Tamanio unTamanio) 
			throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		capa.colocarObjeto(posicion, objetoConTamanio, unTamanio);
	}

	public void intercambiarObjetos(Posicion posicion1, Posicion posicion2, TipoDeCapa tipoDeCapa) throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		capa.intercambiarObjetos(posicion1, posicion2);		
	}

	public void removerObjeto(Posicion posicion, TipoDeCapa tipoDeCapa) throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		capa.removerObjeto(posicion);
	}

	public void removerObjeto(Posicion posicion, TipoDeCapa tipoDeCapa,  Tamanio unTamanio) throws PosicionInvalida {
		
		CapaDeMapa capa = capas.get(tipoDeCapa.numero());
		capa.removerObjeto(posicion, unTamanio);	
	}
}