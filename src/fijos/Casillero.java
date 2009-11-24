package fijos;

public class Casillero {
	/* cada casillero puede tener un atributo objeto donde se almacena el objeto. Y un atributo
	 * personaje donde se almacena el casillero. Esto es para solucionar el proble de que en un
	 * mismo casillero puede haber un fantasma y una semilla. Hay que definir el dise�o de los
	 * mensajes entre un personaje y un elemento al es pisar un casillero
	 * contiene puede tener Semilla, Pared, Vacio o fruta
	 */
	private String contiene;
	
	public Casillero(String nuevo){
		this.contiene = nuevo;
	}
	
	public String get_contenido(){
		return this.contiene;
	}
	
	public void set_contenido(String nuevo){
	// El juego pone una fruta en un casillero en un det momento.
		this.contiene = nuevo;
	}
	
	
	
}
