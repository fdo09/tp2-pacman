package modelo.moviles;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public abstract class Personaje{

	private Tablero tablero;
	private Punto posicion;
	private Punto posicionInicial;
	
	public Personaje(Tablero tablero, Punto posicion){
		this.tablero = tablero;
		this.posicion = posicion;
		this.posicionInicial = new Punto(posicion);
	}
	
	public abstract void mover();

	public void setPosicion(Punto posicion) {
		this.posicion.nuevaPosicion(posicion);
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
		this.posicionInicial.nuevaPosicion(posicionInicial);
	}

	public Punto getPosicionInicial() {
		return posicionInicial;
	}
	
	
}