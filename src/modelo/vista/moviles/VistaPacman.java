package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Direccion;
import modelo.moviles.Pacman;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPacman extends Imagen {

	private Pacman pacman;
	
	public VistaPacman() {
		String nombreArchivoImagen = "ImagenesDePersonajes/pacmanIzquierda.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		
	}
	
	public VistaPacman(Pacman pacman){
		String nombreArchivoImagen = "ImagenesDePersonajes/pacmanIzquierda.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		this.pacman = pacman;
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		this.refrescarImagen();
		grafico.drawImage(super.getImagen(), super.getPosicionable().getX(), super.getPosicionable().getY(), null);
	}

	private void refrescarImagen() {
		if(this.pacman.getDireccionA().equals(Direccion.izquierda()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanIzquierda.JPG");

		else if(this.pacman.getDireccionA().equals(Direccion.derecha()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanDerecha.JPG");

		else if(this.pacman.getDireccionA().equals(Direccion.abajo()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanAbajo.JPG");

		else if(this.pacman.getDireccionA().equals(Direccion.arriba()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanArriba.JPG");
	}

}
