package modelo.vista.moviles;

import java.awt.Graphics;

import modelo.moviles.Direccion;
import modelo.moviles.Pacman;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPacman extends Imagen {

	private Pacman pacman;
	
	public VistaPacman() {
		String nombreArchivoImagen = "ImagenesDePersonajes/pacmanIzquierda.jpg";
		setNombreArchivoImagen(nombreArchivoImagen);
		
	}
	
	public VistaPacman(Pacman pacman){
		String nombreArchivoImagen = "ImagenesDePersonajes/pacmanIzquierda.jpg";
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
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanIzquierda.jpg");

		else if(this.pacman.getDireccionA().equals(Direccion.derecha()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanDerecha.jpg");

		else if(this.pacman.getDireccionA().equals(Direccion.abajo()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanAbajo.jpg");

		else if(this.pacman.getDireccionA().equals(Direccion.arriba()))
			super.setNombreArchivoImagen("ImagenesDePersonajes/pacmanArriba.jpg");
	}

}
