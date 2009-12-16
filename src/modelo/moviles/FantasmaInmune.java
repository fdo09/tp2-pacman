package modelo.moviles;



import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public class FantasmaInmune extends Fantasma implements ObjetoVivo  {

    public static final int VISION = 200;
    Punto destino;	
		
	public FantasmaInmune(Tablero tablero, Punto posicion, int velocidad) {
		super(tablero, posicion, velocidad);
		
		
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
				if(super.getPosicion().equals(this.destino) || this.destino == null)
					this.calcularPosicionDestino();
				
				LinkedList<Punto> posicionesOrdenadasDestino = this.destino.getPosicionesOrdenadas(adjacentesValidos);
				
				return posicionesOrdenadasDestino.peekFirst();
			}
	}


	private void calcularPosicionDestino() {
		Punto dimension = super.getTablero().getDimension();
		Punto posicionAux = null;
		int maxX = dimension.getPuntoX();
		int maxY = dimension.getPuntoY();
		int valorEnteroX = 0;
		int valorEnteroY = 0;
	try{
		do{
			valorEnteroX = (int) Math.floor(Math.random() * (maxX));
			valorEnteroY = (int) Math.floor(Math.random() * (maxY));
			posicionAux = new Punto(valorEnteroX, valorEnteroY);
	
		} while (!super.getTablero().esTransitable(posicionAux));
	}
	catch (NullPointerException e){
		System.out.println(valorEnteroX);
		System.out.println("-");
		System.out.println(valorEnteroY);
		throw new NullPointerException();
	}
		this.destino = posicionAux;
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