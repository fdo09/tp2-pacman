package modelo.vista.control;

import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPrincipal extends Imagen {

	public VistaPrincipal(){
		String nombreArchivoImagen = "inicio.jpg";
		setNombreArchivoImagen(nombreArchivoImagen);
		Punto posicionImagen = new Punto (5*25, 0);
		setPosicionable(posicionImagen);
	}

}
