package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Fantasma;
import modelo.moviles.Objetivo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaAmarillo extends VistaFantasma {


	
	public VistaFantasmaAmarillo(Fantasma fantasma) {
		super(fantasma);
		setImagenAtrapar("ImagenesDePersonajes/amarillo.JPG");
		setImagenComido("ImagenesDePersonajes/amarillo.JPG");
	}
	
}
