package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Objetivo;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaAzul extends VistaFantasma {
	
	

	public VistaFantasmaAzul(Fantasma fantasma) {
		super(fantasma);
		super.setImagenAtrapar("ImagenesDePersonajes/azul.JPG");
		super.setImagenComido("ImagenesDePersonajes/azul.JPG");
	}
}
