package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaAmarillo extends Fantasma {	

	public FantasmaAmarillo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
	}


	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * Esta estrategia devuelve siempre el adjacente valido que esta a menor distancia del pacman
		 */
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
		return posicionesOrdenadasPacman.peekFirst();
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * Esta estrategia devuelve siempre el adjacente valido que esta a mayor distancia del pacman
		 */
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
		return posicionesOrdenadasPacman.peekLast();
	}
	
}
