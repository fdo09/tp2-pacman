package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaNaranja extends Fantasma {

	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estados.ATRAPAR;
								
	}
	
	
	/*Realiza un movimiento segun la estrategia asignada, este fantasma es capar de realizar apoyo
	 * al fantasma que se encuentra mas cerca del Pacman, si el esta mas cerca que otro fantasma intentará
	 * atraparlo. A la hora de huir, se acercará al fantasma que se encuentra mas lejos, si el esta mas lejos, 
	 * seguirá huyendo.
	 */
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
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas ceracno al pacman.
		 * En cambio si no es el mas cercano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		if (fantasmaMasCercano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesOrdenadasPacman.peekFirst();
		}
		else {
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasCercano.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAFantasmaCercano.peekFirst();
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas lejano al pacman, devulve el adjacente mas lejano al pacman.
		 * En cambio si no es el mas lejano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasLejano = fantasmasOrdenados.peekLast();
		if (fantasmaMasLejano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			LinkedList<Punto> posicionesAPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAPacman.peekLast();
		}
		else {
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasLejano.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAFantasmaCercano.peekFirst();
		}
			
	}

}
