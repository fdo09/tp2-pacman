package modelo.moviles;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public abstract class Personaje{

	private Tablero tablero;
	private Punto posicion; 
	
	public abstract void mover();
	
	
}