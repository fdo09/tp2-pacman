package modelo;

import fijos.Punto;
import fijos.Tablero;

public abstract class Personaje{

	private Tablero tablero;
	private Punto posicion; 
	
	public abstract void mover();
	
	
}