package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.*;

public class FantasmaAmarillo extends Fantasma {
	
	private Tablero tablero;
	

	public FantasmaAmarillo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
	}


	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekFirst();
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekLast();
	}

}
