package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.NoSuchElementException;

import fijos.*;

public class FantasmaAzul extends Fantasma {

	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
	public FantasmaAzul(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
						
	}
	
	
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		ArrayDeque<Punto> fantasmasOrdenados = this.obtenerFantasmasOrdenadosPorDistancia(); 
		Punto fantasmaMasCercano = fantasmasOrdenados.peekFirst();
		
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);

		if(fantasmaMasCercano.equals(this.posicion)){
			return pila.peekFirst();
		}
		else {
			Punto movimiento1 = pila.pop();
			try{
				Punto movimiento2 = pila.pop();
				return movimiento2;
			}
			catch(NoSuchElementException error){
				return movimiento1;
			}
		}
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
