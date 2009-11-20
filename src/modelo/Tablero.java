package modelo;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

public class Tablero {
	
	HashMap<Point, Casillero> casilleros;
	
	public Tablero (int base, int altura, Collection<Integer> casilleros){
		//Capacidad inicial es base*altura+1 para prevenir que no se llene el HashMap. 
		//Ya q se si se llena se tiene que volver a agrandar y eso consume bastantes recursos.
		this.casilleros = new HashMap<Point, Casillero>(base*altura+1, 1);
	}

	public Point posicionPac() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
