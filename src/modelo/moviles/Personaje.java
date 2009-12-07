package modelo.moviles;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public abstract class Personaje{

	private Tablero tablero;
	private Punto posicion;
	private Punto posicionInicial;
	
	public Personaje(Tablero tablero, Punto posicion){
		this.setTablero(tablero);
		this.setPosicion(posicion);
		this.setPosicionInicial(posicion);
	}
	
	public abstract void mover();

	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	public Punto getPosicion() {
		return this.posicion;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setPosicionInicial(Punto posicionInicial) {
		this.posicionInicial = posicionInicial;
	}

	public Punto getPosicionInicial() {
		return posicionInicial;
	}
	
	
}