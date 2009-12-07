package modelo.moviles;



import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class FantasmaInmune extends Fantasma  {

    public static final int VISION = 10;
    Punto destino;	
	
			
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
			Punto posicionPacman = super.getTablero().getPacman().getPosicion();
			double distanciaPacman = super.getPosicion().distancia(posicionPacman);
			
			if(distanciaPacman < VISION){
				
				posicionPacman = super.getTablero().getPacman().getPosicion();
				
				LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
				
				return posicionesOrdenadasPacman.peekFirst();
			}
			else{
				if(super.getPosicion().equals(destino))
					this.calcularPosicionDestino();
				
				LinkedList<Punto> posicionesOrdenadasDestino = destino.getPosicionesOrdenadas(adjacentesValidos);
				
				return posicionesOrdenadasDestino.peekFirst();
			}
	}


	private void calcularPosicionDestino() {
		Punto dimension = super.getTablero().getDimension();
		Random generadorX = new Random(dimension.getPuntoX());
		Random generadorY = new Random(dimension.getPuntoY());
		Punto posicionAux;
		
		do{
			
			int numAzarX = generadorX.nextInt();
			
			int numAzarY = generadorY.nextInt();
			
			posicionAux = new Punto(numAzarX, numAzarY);
		
		} while (!super.getTablero().esTransitable(posicionAux) || posicionAux == super.getPosicion());
		
		super.setPosicion(posicionAux);
	}


	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		/*
		 * Elige entre todos los adjacentes validos cual es el mejor para moverse.
		 * En esta estrategia, el fantasma tiene un rango de vision, en el que si el pacman se encuentra dentro de ese rango,
		 * devuelve el adjacente mas lejano al pacman
		 * En cambio si el pacman no esta en ese rango de vision, el fantasma se mueve hacia una posicion valida aleatoria del tableo
		 * Una vez que llega a esa posicion aleatoria, calcula otra y se dirige hacia ella. 
		 */
		Punto posicionPacman = super.getTablero().getPacman().getPosicion();
		double distanciaPacman = super.getPosicion().distancia(posicionPacman);
		
		if(distanciaPacman < VISION){
			
			posicionPacman = super.getTablero().getPacman().getPosicion();
			
			LinkedList<Punto> posicionesOrdenadasPacman = posicionPacman.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesOrdenadasPacman.peekLast();
		}
		else{
			if(super.getPosicion().equals(destino))
				this.calcularPosicionDestino();
			
			LinkedList<Punto> posicionesOrdenadasDestino = destino.getPosicionesOrdenadas(adjacentesValidos);
			
			return posicionesOrdenadasDestino.peekLast();
		}
	}
	
	
	public boolean esComible(){
		//EL fantasmaInmune nunca puede ser comido
		return false;
	}
	

	
}