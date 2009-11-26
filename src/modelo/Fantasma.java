package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import fijos.*;

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
	
	protected void moverDerecha(){
		this.posicion.x += 1;
		Casillero casillero = tablero.getCasillero(this.posicion);
	}

	protected void moverIzquierda(){
		this.posicion.x -= 1;
		Casillero casillero = tablero.getCasillero(this.posicion);
	}
	
	protected void moverArriba(){
		this.posicion.y += 1;
		Casillero casillero = tablero.getCasillero(this.posicion);
	}
	
	protected void moverAbajo(){
		this.posicion.y -= 1;
		Casillero casillero = tablero.getCasillero(this.posicion);
	}
	
	public void regresar(){
		Collection<Point> casa = this.tablero.getCasa();
		
		for(Point punto : casa){
			Casillero casilleroAux = tablero.getCasillero(punto);
			if (casilleroAux == null) {
				this.posicion = punto;
				return;
			}
		}
	}
	
	public abstract void huir();
	public abstract void atrapar();
	
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
	
}
