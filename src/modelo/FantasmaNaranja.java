package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.Punto;
import fijos.Tablero;

public class FantasmaNaranja extends Fantasma {


	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estados.ATRAPAR;
								
	}
	
	
	/*Realiza un movimiento segun la estrategia asignada, este fantasma es capar de realizar apoyo
	 * al fantasma que se encuentra mas cerca del Pacman, si el esta mas cerca que otro fantasma intentará
	 * atraparlo. A la hora de huir, se acercará al fantasma que se encuentra mas lejos, si el esta mas lejos, 
	 * seguirá huyendo.
	 */
	public void mover(){
		Punto nuevaPosicion;
		Collection<Punto> adjacentesValidos = this.tablero.obtenerAdjacentesValidos(this.posicion);
		
		switch (this.estado){
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			this.posicion = nuevaPosicion;
			this.comer();
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			this.posicion = nuevaPosicion;
			this.serComido();
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
			this.posicion = nuevaPosicion;
		}
	}
	
	
	@Override
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		if (fantasmaMasCercano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			ArrayDeque<Punto> posicionesAPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAPacman.peekFirst();
		}
		else {
			ArrayDeque<Punto> posicionesAFantasmaCercano = fantasmaMasCercano.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAFantasmaCercano.peekFirst();
		}
	}


	@Override
	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasLejano = fantasmasOrdenados.peekLast();
		if (fantasmaMasLejano.equals(this.posicion)){
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			ArrayDeque<Punto> posicionesAPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAPacman.peekLast();
		}
		else {
			ArrayDeque<Punto> posicionesAFantasmaCercano = fantasmaMasLejano.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesAFantasmaCercano.peekLast();
		}
			
	}

}
