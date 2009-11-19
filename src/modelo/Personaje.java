package modelo;

public abstract class Personaje {
	
	int posicionX;
	int posicionY;
	int direccionX;
	int direccionY;
	
	public void mover() {
		if (direccionX == 0 | direccionY == 0) {
			posicionX += direccionX;
			posicionY += direccionY;
		}
		else
			//definir que excepcion lanzar. esto es para que el pac no se pueda mover en diagonal
			throw new RuntimeException();
	}
}