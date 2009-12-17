package modelo.vista.fijos;

import modelo.fijos.Casillero;
import modelo.fijos.Punto;

public class VistaPremioRojo extends VistaPremio{
	
	public VistaPremioRojo(Casillero premioActual, Punto posicion){
		super(premioActual, posicion);
		String nombreArchivoImagen = "manzana2.JPG";
		setNombreArchivoImagen(nombreArchivoImagen);
	}

}
