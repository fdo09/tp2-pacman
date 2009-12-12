package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Estado;
import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasmaNaranja extends Imagen {

	private Fantasma fantasma;

	public VistaFantasmaNaranja(Fantasma fantasma) {
		String nombreArchivoImagen = "ImagenesDePersonajes/naranja.JPG";
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
			super.setNombreArchivoImagen("ImagenesDePersonajes/naranja.JPG");

		else if(this.fantasma.getEstado().equals(Estado.huir()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/rosa.JPG");

		else if(this.fantasma.getEstado().equals(Estado.comido()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/naranja.JPG");
	}
}
