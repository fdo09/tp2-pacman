package modelo.vista.fijos;

import modelo.fijos.Casillero;
import modelo.fijos.Punto;

public class VistaPremioVida extends VistaPremio {
	
	public VistaPremioVida(Casillero premioActual, Punto posicion){
		super(premioActual, posicion);
		String nombreArchivoImagen = "pacmanDerecha.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
	}

}
