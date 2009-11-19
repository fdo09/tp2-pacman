package modelo;

public abstract class Fantasma extends Personaje {

	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;

	public Fantasma(int coordenadaEnX, int coordenadaEnY) {
		
		this.estado = "Deambulando";
		this.fueComido = false;
		
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
		
	}

	public abstract void mover();
	
}
