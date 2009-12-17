package modelo.vista.moviles;

import modelo.moviles.Fantasma;

public class VistaFantasmaInmune extends VistaFantasma {

	

	public VistaFantasmaInmune(Fantasma fantasma) {
		super(fantasma);
		super.setImagenAtrapar("ImagenesDePersonajes/verde.JPG");
		super.setImagenComido("ImagenesDePersonajes/verde.JPG");
		super.setImagenHuir("ImagenesDePersonajes/verde.JPG");
	}
}
