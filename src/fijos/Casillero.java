package fijos;

enum Estados{VIVO, COMIDO};

public abstract class Casillero {
	/* cada casillero puede tener un atributo objeto donde se almacena el objeto. Y un atributo
	 * personaje donde se almacena el casillero. Esto es para solucionar el proble de que en un
	 * mismo casillero puede haber un fantasma y una semilla. Hay que definir el dise�o de los
	 * mensajes entre un personaje y un elemento al es pisar un casillero
	 * contiene puede tener Semilla, Pared, Vacio o fruta
	 */
	private Estados estado;
	
	public Casillero(){
		this.estado = Estados.COMIDO;
	}
	
	//Se llamara a este metodo desde el pac cuando este se mueva sobre un casillero.
	public abstract void comer();
}
