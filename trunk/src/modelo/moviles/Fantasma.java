package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.vista.Integrante;
import modelo.fijos.Punto;

enum Estados{ATRAPAR, HUIR, COMIDO};

public abstract class Fantasma extends Personaje implements Integrante{

	private Estados estado;
	private int puntos;
	private Punto casa;
	public static final int PUNTOS = 200;

	public Fantasma(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.setEstado(Estados.ATRAPAR);
		this.puntos = PUNTOS;
		this.casa = posicion;
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
			this.setPosicion(this.getPosicionInicial());
			this.setEstado(Estados.ATRAPAR);
		}
	}
	
	
	protected void comer() {
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion())){
			pacman.serComido();
		}
	}
	
	
	protected void serComido(){
		
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion()))
		{
			this.setPosicion(super.getPosicionInicial());
			Juego.getInstancia().getJugador().ganarPuntos(Fantasma.PUNTOS);
			this.estado = Estados.ATRAPAR;
		}
	}
	
	public boolean esComible(){
		return (this.getEstado() == Estados.HUIR);
	}
	
	protected Punto getCasa(){
		return this.casa;
	}
	
	protected Punto calcularRegreso(Collection<Punto> adjacentesValidos){
		Punto destino = this.getCasa();
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
		
		Punto posicionDelPacman = getTablero().getPacman().getPosicion();
		
		LinkedList<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.getPosicionesOrdenadas(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
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
	