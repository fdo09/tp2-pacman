package modelo;



import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Random;

import fijos.*;

public class FantasmaInmune extends Fantasma  {

    public static final int VISION = 10;
    Punto destino;
	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
			
	public FantasmaInmune(Tablero tablero, Punto posicion){
	
		super(tablero, posicion);
		
	}


	@Override
	protected Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
			Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			double distanciaPacman = this.posicion.distancia(posicionPacman);
			
			if(distanciaPacman < VISION){
				posicionPacman = tablero.obtenerPacman().obtenerPosicion();
				ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
				return pila.peekFirst();
			}
			else{
				if(this.posicion.equals(destino))
					this.calcularPosicionDestino();
				
				ArrayDeque<Punto> pila = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
				return pila.peekFirst();
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


	@Override
	protected Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		Punto posicionPacman = tablero.obtenerPacman().obtenerPosicion();
		double distanciaPacman = this.posicion.distancia(posicionPacman);
		
		if(distanciaPacman < VISION){
			posicionPacman = tablero.obtenerPacman().obtenerPosicion();
			ArrayDeque<Punto> pila = posicionPacman.obtenerPosicionesOrdenadas(adjacentesValidos);
			return pila.peekLast();
		}
		else{
			if(this.posicion.equals(destino))
				this.calcularPosicionDestino();
			
			ArrayDeque<Punto> pila = destino.obtenerPosicionesOrdenadas(adjacentesValidos);
			return pila.peekLast();
		}
	}
	
	
	public boolean esComible(){
		//EL fantasmaInmune nunca puede ser comido
		return false;
	}
	
}