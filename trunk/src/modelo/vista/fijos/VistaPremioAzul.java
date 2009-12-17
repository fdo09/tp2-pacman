package modelo.vista.fijos;

import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.vista.fijos.VistaPremio;

public class VistaPremioAzul extends VistaPremio {
	
	public VistaPremioAzul(Casillero premioActual, Punto posicion){
		super(premioActual, posicion);
		String nombreArchivoImagen = "pacmanDerecha.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
	}

}
