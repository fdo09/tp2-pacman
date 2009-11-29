package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.Punto;
import fijos.Tablero;

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
			ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return pila.peekFirst();
		}
		else 
			return fantasmaMasCercano;
	}


	@Override
	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasLejano = fantasmasOrdenados.peekLast();
		if (fantasmaMasLejano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return pila.peekLast();
		}
		else 
			return fantasmaMasLejano;
	}

}
