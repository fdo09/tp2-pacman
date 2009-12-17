package modelo.vista.moviles;



import java.awt.Graphics;

import modelo.moviles.Fantasma;
import modelo.moviles.Objetivo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaFantasma extends Imagen {
	
	private Fantasma fantasma;
	private String imagenAtrapar;
	private String imagenHuir;
	private String imagenComido;
	
	
	public VistaFantasma(Fantasma fantasma) {
		this.fantasma = fantasma;
		this.imagenHuir = "ImagenesDePersonajes/rosa.JPG";
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		this.refrescarImagen();
		grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), super.getPosicionable().getY(), null);
	}
	
	private void refrescarImagen() {
		if(this.fantasma.getObjetivo().equals(Objetivo.atrapar()))
			super.setNombreArchivoImagen(this.imagenAtrapar);

		else if(this.fantasma.getObjetivo().equals(Objetivo.huir()))
			super.setNombreArchivoImagen(this.imagenHuir);

		else if(this.fantasma.getObjetivo().equals(Objetivo.comido()))
			super.setNombreArchivoImagen(this.imagenComido);
	}

	public void setImagenAtrapar(String imagenAtrapar) {
		this.imagenAtrapar = imagenAtrapar;
	}

	public void setImagenHuir(String imagenHuir) {
		this.imagenHuir = imagenHuir;
	}

	public void setImagenComido(String imagenComido) {
		this.imagenComido = imagenComido;
	}
	

}
