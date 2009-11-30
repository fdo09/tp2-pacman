package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.NoSuchElementException;

import fijos.*;

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
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pilaPosicones = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(this.posicion)){
			return pilaPosicones.peekFirst();
		}
		else {
			Punto movimiento1 = pilaPosicones.pop();
			try{
				Punto movimiento2 = pilaPosicones.pop();
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
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pilaPosiciones = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(this.posicion)){
			return pilaPosiciones.peekLast();
		}
		else {
			Punto movimiento1 = pilaPosiciones.removeLast();
			try{
				Punto movimiento2 = pilaPosiciones.removeLast();
				return movimiento2;
			}
			catch(NoSuchElementException error){
				return movimiento1;
			}
		}
	}
	
}
