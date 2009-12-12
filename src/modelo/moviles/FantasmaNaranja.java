package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class FantasmaNaranja extends Fantasma implements ObjetoVivo, Posicionable {
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
								
	}
	

	public void vivir () {
		this.mover();
	}
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas cercano al pacman, devulve el adjacente mas ceracno al pacman.
		 * En cambio si no es el mas cercano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		if (fantasmaMasCercano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().getPosicion();
			
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesOrdenadasPacman.peekFirst();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasCercano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.peekFirst();
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si este fantasma es el mas lejano al pacman, devulve el adjacente mas lejano al pacman.
		 * En cambio si no es el mas lejano, devuelve el adjacente mas cercano al fantasma mas cercano. 
		 */
		LinkedList<Punto> fantasmasOrdenados = this.getFantasmasOrdenadosPorDistancia(); 
		
		Punto fantasmaMasLejano = fantasmasOrdenados.peekLast();
		
		if (fantasmaMasLejano.equals(super.getPosicion())){
			
			Punto posicionPacman = getTablero().getPacman().getPosicion();
			
			LinkedList<Punto> posicionesAPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAPacman.peekLast();
		}
		else {
			
			LinkedList<Punto> posicionesAFantasmaCercano = fantasmaMasLejano.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesAFantasmaCercano.peekFirst();
		}
			
	}
	
	
	//Metodos provisorios utilizados para la visibilidad.
	
	public int getX() {
		
		return 25 * super.getPosicion().getPuntoX();
	}


	public int getY() {
		
		return 25 * super.getPosicion().getPuntoY();
	}
}
