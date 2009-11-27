package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import fijos.*;

enum Estados{ATRAPAR, HUIR, INMUNE, COMIDO};

public abstract class Fantasma extends Personaje {

	private Tablero tablero;
	private Punto posicion; 
	private Estados estado;
	

	public Fantasma(Tablero tablero, Point posicion) {
		
		this.estado = Estados.ATRAPAR;
		this.tablero = tablero;
		this.posicion = posicion;
		
	}
	
	public void mover(){
		Punto nuevaPosicion;
		ArrayList<Point> adjacentesValidos = this.tablero.adjacentes();
		
		switch (this.estado){
		case ATRAPAR: case INMUNE:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			this.comer(nuevaPosicion);
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			this.serComido(nuevaPosicion);
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
		}
		
		this.posicion.cambiarPosicion(nuevaPosicion);
		
		this.comer(nuevaPosicion);
	}
	
	
	protected void comer(Punto nuevaPosicion) {
		Punto posicionPac = this.tablero.posicionPac();
		if(this.posicion.equals(posicionPac)){
			// El fantasma se come al pac. Definir que se hace.
		}
	}
	
	
	protected void serComido(Punto nuevaPosicion){
		Punto posicionPac = this.tablero.posicionPac();
		if(this.posicion.equals(posicionPac)){
			// El pac se come al fantasma. Definir que se hace.
		}
	}
		
	
	abstract Punto calcularHuida(ArrayList<Point> adjacentesValidos);

	abstract Punto calcularAtrapada(ArrayList<Point> adjacentesValidos);
	
	public Punto calcularRegreso(ArrayList<Point> adjacentesValidos){
		
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
