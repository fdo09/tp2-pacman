package modelo.vista.fijos;

import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaVidas extends Imagen{

	public VistaVidas(){
		String nombreArchivoImagen = "pacman.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		Punto posicionVidas = new Punto (23*25, 12*25);
		setPosicionable(posicionVidas);
	}
	
	
	
}
