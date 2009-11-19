package modelo;

public class Pac implements Personaje{

	int posicionX;
	int posicionY;
	boolean power;
	
	public Pac (int posicionX, int posicionY){
		this.power = false;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
}
