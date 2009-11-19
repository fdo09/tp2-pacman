package modelo;

public class Pac extends Personaje{

	int posicionX;
	int posicionY;
	int direccionX;
	int direccionY;
	boolean power;
	
	public Pac (int posicionX, int posicionY){
		this.power = false;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

}
