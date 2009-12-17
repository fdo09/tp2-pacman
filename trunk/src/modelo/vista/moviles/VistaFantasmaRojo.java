package modelo.vista.moviles;

import modelo.moviles.Fantasma;

public class VistaFantasmaRojo extends VistaFantasma {

	

	public VistaFantasmaRojo(Fantasma fantasma) {
		super(fantasma);
		super.setImagenAtrapar("ImagenesDePersonajes/rojo.JPG");
		super.setImagenComido("ImagenesDePersonajes/rojo.JPG");
	}

}
