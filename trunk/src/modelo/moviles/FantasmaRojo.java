package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

import ar.uba.fi.algo3.titiritero.*;

enum Inteligencias{INTELIGENTE, TONTO};

public class FantasmaRojo extends Fantasma implements ObjetoVivo, Posicionable {

	private int contadorInteligencia;
	private Inteligencias intel;
	public static final int CAMBIO_INTELIGENCIA = 20;
	public static final int CICLO_INTELIGENCIA = 40;
	
	
	public FantasmaRojo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.intel = Inteligencias.INTELIGENTE;
	}
	
	public void vivir(){
		this.mover();
	}
		
	public void mover(){
		/*
		 * Este fantama redefine el metodo "comer" agergandole una llamada al metodo definirInteligencia.
		 * Esto es para llevar un contador que modifique el estado de inteligencia del fantasma. La estrategia para atrapar
		 * o huir depende de este estado de inteligencia		
		 */
		Punto nuevaPosicion;
		Collection<Punto> adjacentesValidos = super.getTablero().getAdjacentesValidos(super.getPosicion());
		adjacentesValidos.remove(this.posicionAnterior);
		posicionAnterior = super.getPosicion();
		this.definirInteligencia();
		
		switch (super.getEstado()){
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
			super.setPosicion(nuevaPosicion);
			this.comer();
			break;
		case HUIR:
			nuevaPosicion = this.calcularHuida(adjacentesValidos);	
			super.setPosicion(nuevaPosicion);
			this.serComido();
			break;
		case COMIDO:
			this.setPosicion(this.getPosicionInicial());
			this.setEstado(Estados.ATRAPAR);
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
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
		
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
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		
		LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
		
		if(this.intel == Inteligencias.INTELIGENTE)
			return posicionesOrdenadasPacman.peekLast();
		else
			return posicionesOrdenadasPacman.peekFirst();
	}
	
	//Metodos provisorios utilizados para la visibilidad.
	
	public int getX() {
		return 25 * super.getPosicion().getPuntoX();
	}

	
	public int getY() {
		return 25 * super.getPosicion().getPuntoY();
	}
}