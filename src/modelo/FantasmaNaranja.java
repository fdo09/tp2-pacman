package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import fijos.*;

public class FantasmaNaranja extends Fantasma {


	private Tablero tablero;
	private Punto posicion;
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
						
	}
	
	
	@Override
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		if (fantasmaMasCercano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			ArrayDeque<Punto> pila = posicionPacman.ordenarPosicionesPorDistancia(adjacentesValidos);
			return pila.peekFirst();
		}
		else 
			return fantasmaMasCercano;
	}


	@Override
	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}

}
