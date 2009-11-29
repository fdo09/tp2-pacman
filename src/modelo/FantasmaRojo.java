package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import fijos.*;

public class FantasmaRojo extends Fantasma {

	private Tablero tablero;
	private Estados estado;
	private Punto posicion;
	
	
	public FantasmaRojo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estados.ATRAPAR;
	}

	
	public void mover(){
		
		Collection<Punto> adjacentesValidos = this.tablero.obtenerAdjacentesValidos(this.posicion);
		
		int contador = 0;
		int tiempoCambioDeEstado = 20;
		
		if(contador <= tiempoCambioDeEstado){
			
			this.estrategiaMiedosa(adjacentesValidos, contador);
			
		}
		
		else{
			
			this.estrategiaValiente(adjacentesValidos, contador);

			int tiempoDeUnNuevoCambio = 40;
			
			if (contador == tiempoDeUnNuevoCambio){
				
				contador = 0;
			}
		}
		
	}


	private void estrategiaValiente(Collection<Punto> adjacentesValidos,int contador) {
		
		Punto nuevaPosicion;
		
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
		contador++;
		
	}


	private void estrategiaMiedosa(Collection<Punto> adjacentesValidos,int contador) {
	
		Punto nuevaPosicion;
		
		switch (this.estado)
		{
		case ATRAPAR:
			nuevaPosicion = this.calcularAtrapadaConMiedo(adjacentesValidos);
			this.posicion = nuevaPosicion;
			this.comer();
		case HUIR:
			nuevaPosicion = this.calcularHuidaConMiedo(adjacentesValidos);	
			this.posicion = nuevaPosicion;
			this.serComido();
		case COMIDO:
			nuevaPosicion = this.calcularRegreso(adjacentesValidos);
			this.posicion = nuevaPosicion;
		}
		contador++;
	}
	
	private Punto calcularAtrapadaConMiedo(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekLast();
	}


	private Punto calcularHuidaConMiedo(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekFirst();
	} 
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekFirst();
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
		return pila.peekLast();
	}

}
