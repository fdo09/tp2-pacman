package modelo;

public class Pac extends Personaje{
	
	boolean power;
	private String estado;
	private boolean fueComido;
	private int posicionEnX;
	private int posicionEnY;
	
	
	public Pac (int coordenadaEnX, int coordenadaEnY){
		this.power = false;
		this.estado = "Normal";
		this.fueComido = false;
		this.posicionEnX = coordenadaEnX;
		this.posicionEnY = coordenadaEnY;
	}

	public void mover() {
		// TODO Auto-generated method stub
		
	}

}
