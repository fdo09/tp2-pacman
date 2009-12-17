package modelo.moviles;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public abstract class Personaje {

	private Tablero tablero;
	private Punto posicion;
	private Punto posicionInicial;
	private Estado estado;
	
	public Personaje(Tablero tablero, Punto posicion){
		this.tablero = tablero;
		this.posicion = posicion;
		this.posicionInicial = new Punto(posicion);
		this.estado = Estado.vivo();
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public int getX() {
		
		return 25 * this.posicion.getPuntoX();
	}


	public int getY() {
		
		return 25 * this.posicion.getPuntoY();
	}

	
	
}