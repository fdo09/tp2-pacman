package moviles;

import java.util.Collection;
import java.util.LinkedList;

import fijos.Punto;
import fijos.Tablero;

public class FantasmaAmarillo extends Fantasma {
	
	public static final int PUNTOS = 200;
	private Tablero tablero;
	

	public FantasmaAmarillo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
	}


	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * Esta estrategia devuelve siempre el adjacente valido que esta a menor distancia del pacman
		 */
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return posicionesOrdenadasPacman.peekFirst();
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * Esta estrategia devuelve siempre el adjacente valido que esta a mayor distancia del pacman
		 */
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return posicionesOrdenadasPacman.peekLast();
	}

}
