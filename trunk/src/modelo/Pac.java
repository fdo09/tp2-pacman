package modelo;


public class Pac implements Personaje{

	
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;
	
	
	public Pac (int coordenadaEnX, int coordenadaEnY){
		
		this.fueComido = false;
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
	}

	public void mover() {

		/* Depende de la tecla presionada, el Pac se movera en determinada direccion
		 * siempre y cuando el movimiento sea posible.*/
		
	}

}
