package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Objetivo;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaInmune extends Imagen {

	private Fantasma fantasma;

	public VistaFantasmaInmune(Fantasma fantasma) {
		String nombreArchivoImagen = "ImagenesDePersonajes/verde.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		this.fantasma = fantasma;
	}
}
