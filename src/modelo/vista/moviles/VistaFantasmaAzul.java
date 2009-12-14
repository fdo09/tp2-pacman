package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Objetivo;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaAzul extends Imagen {
	
	private Fantasma fantasma;

	public VistaFantasmaAzul(Fantasma fantasma) {
		String nombreArchivoImagen = "ImagenesDePersonajes/azul.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		this.fantasma = fantasma;
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		this.refrescarImagen();
		grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), super.getPosicionable().getY(), null);
	}

	private void refrescarImagen() {
		if(this.fantasma.getObjetivo().equals(Objetivo.atrapar()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/azul.JPG");

		else if(this.fantasma.getObjetivo().equals(Objetivo.huir()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/rosa.JPG");

		else if(this.fantasma.getObjetivo().equals(Objetivo.comido()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/azul.JPG");
	}

}
