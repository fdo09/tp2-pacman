package moviles;

import java.util.Collection;
import java.util.LinkedList;

import fijos.Punto;
import fijos.Tablero;

enum Inteligencias{INTELIGENTE, TONTO};

public class FantasmaRojo extends Fantasma {

	private Tablero tablero;
	private Estados estado;
	private Punto posicion;
	private int contadorInteligencia;
	private Inteligencias intel;
	public static final int CAMBIO_INTELIGENCIA = 20;
	public static final int CICLO_INTELIGENCIA = 40;
	
	
	public FantasmaRojo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estados.ATRAPAR;
		this.intel = Inteligencias.INTELIGENTE;
	}

		
	public void mover(){
		/*
		 * Este fantama redefine el metodo "comer" agergandole una llamada al metodo definirInteligencia.
		 * Esto es para llevar un contador que modifique el estado de inteligencia del fantasma. La estrategia para atrapar
		 * o huir depende de este estado de inteligencia		
		 */
		Punto nuevaPosicion;
		Collection<Punto> adjacentesValidos = this.tablero.obtenerAdjacentesValidos(this.posicion);
		this.definirInteligencia();
		
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


	private void definirInteligencia() {
		this.contadorInteligencia++;
		
		if(this.contadorInteligencia == CICLO_INTELIGENCIA)
			this.contadorInteligencia = 0;
		
		else if(this.contadorInteligencia <= CAMBIO_INTELIGENCIA)
			this.intel = Inteligencias.INTELIGENTE;
			
		else
			this.intel = Inteligencias.TONTO;
	}

	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si el estado de intelgencia es "INTELIGENTE" 
		 * devuelve  el adjacente valido que esta a menor distancia del pacman.
		 * En cambio si el estado de inteligencia es "TONTO", 
		 * devuelve el adjacente valido que esta a mayor distancia del pacman.
		 */
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		if(this.intel == Inteligencias.INTELIGENTE)
			return posicionesOrdenadasPacman.peekFirst();
		else
			return posicionesOrdenadasPacman.peekLast();

	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, si el estado de intelgencia es "INTELIGENTE" 
		 * devuelve  el adjacente valido que esta a mayor distancia del pacman.
		 * En cambio si el estado de inteligencia es "TONTO", 
		 * devuelve el adjacente valido que esta a menor distancia del pacman.
		 */
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		if(this.intel == Inteligencias.INTELIGENTE)
			return posicionesOrdenadasPacman.peekLast();
		else
			return posicionesOrdenadasPacman.peekFirst();
	}

}
