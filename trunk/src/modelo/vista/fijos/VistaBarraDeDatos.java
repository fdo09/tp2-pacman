package modelo.vista.fijos;

import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaBarraDeDatos extends Imagen{
	
	public VistaBarraDeDatos(){
		String nombreArchivoImagen = "barraDatos.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
		setPosicionable(new Punto (0 , 25*25));
	}

}
