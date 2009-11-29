package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

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
		ArrayDeque<Punto> pila = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.pop();
	}

	
	public Punto getPosicion(){
		return this.posicion;
	}

	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}

	protected ArrayDeque<Punto> obtenerFantasmasOrdenadosPorDistancia() {
		
		ArrayList<Punto> posicionesDeFantasmas = tablero.obtenerPosicionesDeFantasmas();
		
		Punto posicionDelPacman = tablero.obtenerPacman().obtenerPosicion();
		
		ArrayDeque<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.obtenerPosicionesOrdenadas(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
	}
	
	
}
	