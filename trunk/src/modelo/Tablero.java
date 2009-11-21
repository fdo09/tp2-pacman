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
		// TODO Un metodo que devuelva la posicion del pac.
		return null;
	}

	public Collection<Point> getCasa() {
		// TODO Un metodo que devuelva una coleccion con todas las posiciones de la casa.
		return null;
	}

	public Casillero getCasillero(Point punto) {
		// TODO Un metodo que dado un punto me devuelva el casillero en esa posicion
		return null;
	}

	public boolean hayObstaculo(Point unaPosicion) {
		//INCLUYE LAS PAREDES FRONTERA SI ?
		return false;
	}
	
	
}
