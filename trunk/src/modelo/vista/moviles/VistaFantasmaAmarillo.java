package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Direccion;
import modelo.moviles.Estado;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaAmarillo extends Imagen {

	private Fantasma fantasma;
	
	public VistaFantasmaAmarillo(Fantasma fantasma) {
		String nombreArchivoImagen = "ImagenesDePersonajes/amarillo.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		this.fantasma = fantasma;
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		this.refrescarImagen();
		grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), super.getPosicionable().getY(), null);
	}

	private void refrescarImagen() {
		if(this.fantasma.getEstado().equals(Estado.atrapar()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/amarillo.JPG");

		else if(this.fantasma.getEstado().equals(Estado.huir()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/rosa.JPG");

		else if(this.fantasma.getEstado().equals(Estado.comido()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/amarillo.JPG");
	}
}
