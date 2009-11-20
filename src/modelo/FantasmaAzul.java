package modelo;

import java.awt.Point;

public class FantasmaAzul extends Fantasma {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
	public FantasmaAzul(Tablero tablero, Point posicion) {
		super(tablero, posicion);
						
	}

	public void huir() {
		Point posicionPac = tablero.posicionPac();
		
	}

	public void atrapar() {
		Point posicionPac = tablero.posicionPac();

		
	}

	public void regresar() {
		// TODO Auto-generated method stub
		
	}

}
