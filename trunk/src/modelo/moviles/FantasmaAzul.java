package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaAzul extends Fantasma implements ObjetoVivo {	
	
	public FantasmaAzul(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		super.setPuntos(PUNTOS);
						
	}
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas cercano al pacman.
		 * En cambio si no es el mas cercano, devuelve el segundo adjacente mas cercano al pacman. En caso de que no haya 
		 * una segunda posicion valida, devuelve la primera. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(super.getPosicion())){
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
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(super.getPosicion())){
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
	public int getX() {
		
		return 25 * super.getPosicion().getPuntoX();
		
	}


	public int getY() {
		
		return 25 * super.getPosicion().getPuntoY();
	}
	
	public void vivir(){
		
		super.mover();
	}
}
