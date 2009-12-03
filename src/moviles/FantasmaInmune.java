package moviles;



import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import fijos.Punto;
import fijos.Tablero;

public class FantasmaInmune extends Fantasma  {

    public static final int VISION = 10;
    Punto destino;
	private Tablero tablero;
	private Punto posicion;
	
	
			
	public FantasmaInmune(Tablero tablero, Punto posicion){
	
		super(tablero, posicion);
		
	}


	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, el fantasma tiene un rango de vision, en el que si el pacman se encuentra dentro de ese rango,
		 * devuelve el adjacente mas cercano al pacman
		 * En cambio si el pacman no esta en ese rango de vision, el fantasma se mueve hacia una posicion valida aleatoria del tableo
		 * Una vez que llega a esa posicion aleatoria, calcula otra y se dirige hacia ella. 
		 */
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			double distanciaPacman = this.posicion.distancia(posicionPacman);
			
			if(distanciaPacman < VISION){
				posicionPacman = tablero.obtenerPacman().obtenerPosicion();
				LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
				return posicionesOrdenadasPacman.peekFirst();
			}
			else{
				if(this.posicion.equals(destino))
					this.calcularPosicionDestino();
				
				LinkedList<Punto> posicionesOrdenadasDestino = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
				return posicionesOrdenadasDestino.peekFirst();
			}
	}


	private void calcularPosicionDestino() {
		Punto dimension = tablero.obtenerDimension();
		Random generadorX = new Random(dimension.getPuntoX());
		Random generadorY = new Random(dimension.getPuntoY());
		Punto posicionAux;
		do{
			int numAzarX = generadorX.nextInt();
			int numAzarY = generadorY.nextInt();
			posicionAux = new Punto(numAzarX, numAzarY);
		} while (!tablero.esTransitable(posicionAux) || posicionAux == this.posicion);
		
		this.posicion = posicionAux;
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, el fantasma tiene un rango de vision, en el que si el pacman se encuentra dentro de ese rango,
		 * devuelve el adjacente mas lejano al pacman
		 * En cambio si el pacman no esta en ese rango de vision, el fantasma se mueve hacia una posicion valida aleatoria del tableo
		 * Una vez que llega a esa posicion aleatoria, calcula otra y se dirige hacia ella. 
		 */
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		double distanciaPacman = this.posicion.distancia(posicionPacman);
		
		if(distanciaPacman < VISION){
			posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesOrdenadasPacman.peekLast();
		}
		else{
			if(this.posicion.equals(destino))
				this.calcularPosicionDestino();
			
			LinkedList<Punto> posicionesOrdenadasDestino = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
			return posicionesOrdenadasDestino.peekLast();
		}
	}
	
	
	public boolean esComible(){
		//EL fantasmaInmune nunca puede ser comido
		return false;
	}
	
}