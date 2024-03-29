package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public class FantasmaNaranja extends Fantasma implements ObjetoVivo {
	

	
	public FantasmaNaranja(Tablero tablero, Punto posicion, int velocidad) {
		super(tablero, posicion, velocidad);
		
					
	}
	

	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas ceracno al pacman.
		 * En cambio si no es el mas cercano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = super.getTablero().getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasCercano = fantasmasOrdenados.removeFirst();
		
		if (fantasmaMasCercano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().getPosicion();
			
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesOrdenadasPacman.removeFirst();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasCercano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.removeFirst();
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas lejano al pacman, devulve el adjacente mas lejano al pacman.
		 * En cambio si no es el mas lejano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = super.getTablero().getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasLejano = fantasmasOrdenados.removeLast();
		
		if (fantasmaMasLejano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().getPosicion();
			
			LinkedList<Punto> posicionesAPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAPacman.removeLast();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasLejano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.removeFirst();
		}
			
	}
	
	
	
	

}
