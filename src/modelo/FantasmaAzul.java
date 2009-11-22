package modelo;

import java.awt.Point;
import java.util.Collection;

public class FantasmaAzul extends Fantasma {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
	public FantasmaAzul(Tablero tablero, Point posicion) {
		super(tablero, posicion);
						
	}
	/*
	 para calcular la menor o mayor distancia se puede armar una lista con las 4 posiciones posibles y luego ordenarla segun su distancia al pac.
	 luego intentar moverse en la menor distancia. Si no se puede (por una pared) tratar de moverse en la segunda menor distancia.... 
	 */

		public void huir() {
		Point posicionPac = tablero.posicionPac();
		double distanciaPac = this.posicion.distance(posicionPac);
		Collection<Point> adjacentes = this.calcAdjacentes();
	}

	public void atrapar() {
		Point posicionPac = tablero.posicionPac();
		double distanciaPac = this.posicion.distance(posicionPac);
		Collection<Point> adjacentes = this.calcAdjacentes();
		
	}

	public void regresar() {
		// TODO Auto-generated method stub
		
	}
	
}
