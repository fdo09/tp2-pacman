package modelo.moviles;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public abstract class Personaje{

	protected Tablero tablero;
	protected Punto posicion; 
	
	public abstract void mover();
	
	
}