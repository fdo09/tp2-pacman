package modelo;

import java.awt.Point;
import fijos.*;

public class FantasmaRojo extends Fantasma {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
	
	public FantasmaRojo(Tablero tablero, Point posicion) {
		super(tablero, posicion);
		this.estado = Estados.INMUNE;			
	}

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
