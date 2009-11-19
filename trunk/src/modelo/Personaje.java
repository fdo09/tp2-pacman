package modelo;

public abstract class Personaje {
	
	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;

	public abstract void mover();
}