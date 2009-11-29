package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.*;

enum Estados{ATRAPAR, HUIR, INMUNE, COMIDO};

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
		case ATRAPAR: case INMUNE:
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
		ArrayDeque<Punto> pila = destino.ordenarPosicionesPorDistancia(adjacentesValidos);
		return pila.pop();
	}

	
	public Punto getPosicion(){
		return this.posicion;
	}

	public void cambiarEstado() {
		// TODO Auto-generated method stub
		
	}


	/* Por el momento este codigo no sirve
	protected ArrayList<Point> obtenerPosicionesAdyacentes() {
		
		ArrayList<Point> posicionesAdyacentes = new ArrayList<Point>();
		
		Point ptoAuxArriba = new Point();
		ptoAuxArriba = this.posicion;
		ptoAuxArriba.translate(0,1);
		posicionesAdyacentes.add(ptoAuxArriba);
		
		Point ptoAuxAbajo = new Point();
		ptoAuxAbajo = this.posicion;
		ptoAuxAbajo.translate(0,-1);
		posicionesAdyacentes.add(ptoAuxAbajo);

		Point ptoAuxDerecha = new Point();
		ptoAuxDerecha = this.posicion;
		ptoAuxDerecha.translate(1,0);
		posicionesAdyacentes.add(ptoAuxDerecha);
		
		Point ptoAuxIzquierda = new Point();
		ptoAuxIzquierda = this.posicion;
		ptoAuxIzquierda.translate(-1,0);
		posicionesAdyacentes.add(ptoAuxIzquierda);
		
		return posicionesAdyacentes;
	}
	*/
}
