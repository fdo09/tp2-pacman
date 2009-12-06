package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaNaranja extends Fantasma {

	public static final int PUNTOS = 200;
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		super.setPuntos(PUNTOS);
								
	}
	
	
	/*Realiza un movimiento segun la estrategia asignada, este fantasma es capar de realizar apoyo
	 * al fantasma que se encuentra mas cerca del Pacman, si el esta mas cerca que otro fantasma intentar�
	 * atraparlo. A la hora de huir, se acercar� al fantasma que se encuentra mas lejos, si el esta mas lejos, 
	 * seguir� huyendo.
	 */
	public void mover(){
		Punto nuevaPosicion;
		Collection<Punto> adjacentesValidos = this.getTablero().getAdjacentesValidos(super.getPosicion());
		switch (super.getEstado()){
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			super.setPosicion(nuevaPosicion);
			this.comer();
			break;
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			super.setPosicion(nuevaPosicion);
			this.serComido();
			break;
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
		}
	}
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas ceracno al pacman.
		 * En cambio si no es el mas cercano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		if (fantasmaMasCercano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().obtenerPosicion();
			
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesOrdenadasPacman.peekFirst();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasCercano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.peekFirst();
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas lejano al pacman, devulve el adjacente mas lejano al pacman.
		 * En cambio si no es el mas lejano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasLejano = fantasmasOrdenados.peekLast();
		
		if (fantasmaMasLejano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().obtenerPosicion();
			
			LinkedList<Punto> posicionesAPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAPacman.peekLast();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasLejano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.peekFirst();
		}
			
	}
	
}
