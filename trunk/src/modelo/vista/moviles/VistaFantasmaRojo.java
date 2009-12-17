package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Objetivo;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaRojo extends VistaFantasma {

	

	public VistaFantasmaRojo(Fantasma fantasma) {
		super(fantasma);
		super.setImagenAtrapar("ImagenesDePersonajes/rojo.JPG");
		super.setImagenComido("ImagenesDePersonajes/rojo.JPG");
	}

}
