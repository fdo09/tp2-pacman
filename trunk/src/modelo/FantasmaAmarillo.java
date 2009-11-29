package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.*;

public class FantasmaAmarillo extends Fantasma {
	
	private Tablero tablero;
	private Punto posicion;
	private Estados estado;

	public FantasmaAmarillo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
	}


	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.ordenarPosicionesPorDistancia(adjacentesValidos);
		return pila.peekFirst();
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.ordenarPosicionesPorDistancia(adjacentesValidos);
		return pila.peekLast();
	}

}
