package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

enum Estados{ATRAPAR, HUIR, COMIDO};

public abstract class Fantasma extends Personaje {

	private Estados estado;
	private int puntos;

	public Fantasma(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.setEstado(Estados.ATRAPAR);
	}
	
	protected abstract Punto calcularHuida(Collection<Punto> adjacentesValidos);

	protected abstract Punto calcularAtrapada(Collection<Punto> adjacentesValidos);
	
	public void mover(){
		/*
		 * Realiza el movimiento del fantasma de acuerdo a su estado y su estrategia. La estrategia esta implementada en 
		 * cada fantasma.
		 * Luego de moverse verifica si esta en la misma posicion que el pacman para comerselo o ser comido por �l.
		 */
		Punto nuevaPosicion;
		Collection<Punto> adjacentesValidos = this.getTablero().getAdjacentesValidos(this.getPosicion());
		
		switch (this.getEstado()){
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
			this.comer();
			break; //FEDE no lo borres
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			this.setPosicion(nuevaPosicion);
			this.serComido();
			break;
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
		}
	}
	
	
	protected void comer() {
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.obtenerPosicion())){
			pacman.serComido();
		}
	}
	
	
	protected void serComido(){
		
		//this.setEstado(Estados.COMIDO);
			
		this.setPosicion(super.getPosicionInicial());
			
		this.estado = Estados.ATRAPAR;
		
	}
	
	
	public boolean esComible(){
		return (this.getEstado() == Estados.HUIR);
	}
	
	
	protected Punto calcularRegreso(Collection<Punto> adjacentesValidos){
		Punto destino = this.getTablero().getCasa();
		LinkedList<Punto> posicionesDestino = destino.getPosicionesOrdenadas(adjacentesValidos);
		return posicionesDestino.pop();
		
	}

	
	public Punto getPosicion(){
		return super.getPosicion();
	}


	public void cambiarEstado() {
		
		this.setEstado(Estados.HUIR);
		
	}

	protected LinkedList<Punto> getFantasmasOrdenadosPorDistancia() {
		
		LinkedList<Punto> posicionesDeFantasmas = getTablero().getPosicionesDeFantasmas();
		
		Punto posicionDelPacman = getTablero().getPacman().obtenerPosicion();
		
		LinkedList<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.getPosicionesOrdenadas(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
	}

	public int obtenerPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setTablero(Tablero tablero) {
		super.setTablero(tablero);
	}

	public Tablero getTablero() {
		return super.getTablero();
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setPosicion(Punto posicion) {
		super.setPosicion(posicion);
	}

	
}
	