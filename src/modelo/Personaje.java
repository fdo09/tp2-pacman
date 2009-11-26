package modelo;

import java.awt.Point;

import fijos.Tablero;

public abstract class Personaje{

	private Tablero tablero;
	private Point posicion; 
	
	public abstract void mover();
	
	
}