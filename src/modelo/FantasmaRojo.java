package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.*;

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
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		if(this.intel == Inteligencias.INTELIGENTE)
			return pila.peekFirst();
		else
			return pila.peekLast();

	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		if(this.intel == Inteligencias.INTELIGENTE)
			return pila.peekLast();
		else
			return pila.peekFirst();
	}

}
