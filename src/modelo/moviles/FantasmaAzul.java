package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaAzul extends Fantasma {

	private Tablero tablero;
	private Punto posicion;
	
	
	public FantasmaAzul(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
						
	}
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas ceracno al pacman.
		 * En cambio si no es el mas cercano, devuelve el segundo adjacente mas cercano al pacman. En caso de que no haya 
		 * una segunda posicion valida, devuelve la primera. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(this.posicion)){
			return posicionesOrdenadasPacman.peekFirst();
		}
		else {
			Punto movimiento1 = posicionesOrdenadasPacman.pop();
			try{
				Punto movimiento2 = posicionesOrdenadasPacman.pop();
				return movimiento2;
			}
			catch(NoSuchElementException error){
				return movimiento1;
			}
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas lejano al pacman.
		 * En cambio si no es el mas cercano, devuelve el segundo adjacente mas lejano al pacman. En caso de que no haya 
		 * una segunda posicion valida, devuelve la primera. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(this.posicion)){
			return posicionesOrdenadasPacman.peekLast();
		}
		else {
			Punto movimiento1 = posicionesOrdenadasPacman.removeLast();
			try{
				Punto movimiento2 = posicionesOrdenadasPacman.removeLast();
				return movimiento2;
			}
			catch(NoSuchElementException error){
				return movimiento1;
			}
		}
	}
	
}
