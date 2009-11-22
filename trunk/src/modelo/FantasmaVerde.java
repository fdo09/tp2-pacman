package modelo;

import java.awt.Point;

public class FantasmaVerde extends Fantasma {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
	public FantasmaVerde(Tablero tablero, Point posicion) {
		super(tablero, posicion);
						
	}

	/*
	 * ESTE FANTASMA, PODRÍA IR POR EL CAMINO MAS LARGO,
	 * ya que como hizo fede tenemos en una lista todas los movimientos posibles
	 * y calculamos la distancia al pacman desde ellos.
	 */
	
	
	public void huir() {
		// TODO Auto-generated method stub
		
		
	}

	public void atrapar() {
		// TODO Auto-generated method stub
		
	}

	public void regresar() {
		// TODO Auto-generated method stub
		
	}

}
