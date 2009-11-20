package modelo;

import java.awt.Point;

enum Estados{ATRAPAR, HUIR, INMUNE, COMIDO};

public abstract class Fantasma implements Personaje {

	private Tablero tablero;
	private Point posicion; 
	private Estados estado;

	public Fantasma(Tablero tablero, Point posicion) {
		
		this.estado = Estados.ATRAPAR;
		this.tablero = tablero;
		this.posicion = posicion;
		
	}
	
	
	public void mover(){
		
		switch (this.estado){
			case ATRAPAR:
				this.atrapar();
			case HUIR:
				this.huir();
			case COMIDO:
				this.regresar();
			//falta ver que se hace cuando esta INMUNE
		}
	}
	
	public abstract void huir();
	public abstract void regresar();
	public abstract void atrapar();
	
}
