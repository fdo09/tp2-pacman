package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import fijos.*;

enum Estados{ATRAPAR, HUIR, COMIDO};

public abstract class Fantasma extends Personaje {

	private Tablero tablero;
	private Punto posicion; 
	private Estados estado;
	
	

	public Fantasma(Tablero tablero, Punto posicion) {
		
		this.estado = Estados.ATRAPAR;
		this.tablero = tablero;
		this.posicion = posicion;
		
		
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
		Collection<Punto> adjacentesValidos = this.tablero.obtenerAdjacentesValidos(this.posicion);
		
		switch (this.estado){
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			this.posicion = nuevaPosicion;
			this.comer();
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			this.posicion = nuevaPosicion;
			this.serComido();
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
			this.posicion = nuevaPosicion;
		}
	}
	
	
	protected void comer() {
		Pacman pacman = this.tablero.obtenerPacman();
		if(this.posicion.equals(pacman.obtenerPosicion())){
			pacman.serComido();
		}
	}
	
	
	protected void serComido(){
		Pacman pacman = this.tablero.obtenerPacman();
		Punto posicionPacman = pacman.obtenerPosicion();
		if(this.posicion.equals(posicionPacman)){
			this.estado = Estados.COMIDO;
		}
	}
	
	
	public boolean esComible(){
		return (this.estado == Estados.HUIR);
	}
	
	
	protected Punto calcularRegreso(Collection<Punto> adjacentesValidos){
		Punto destino = this.tablero.obtenerCasa();
		LinkedList<Punto> posicionesDestino = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
		return posicionesDestino.pop();
		
	}

	
	public Punto getPosicion(){
		return this.posicion;
	}

	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}

	protected LinkedList<Punto> obtenerFantasmasOrdenadosPorDistancia() {
		
		LinkedList<Punto> posicionesDeFantasmas = tablero.obtenerPosicionesDeFantasmas();
		
		Punto posicionDelPacman = tablero.obtenerPacman().obtenerPosicion();
		
		LinkedList<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.obtenerPosicionesOrdenadas(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
	}
	
	
}
	