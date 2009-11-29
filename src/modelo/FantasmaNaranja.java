package modelo;

import java.util.ArrayList;
import java.util.Collection;

import fijos.*;

public class FantasmaNaranja extends Fantasma {


	private Tablero tablero;
	private Punto posicion;
	
	public FantasmaNaranja(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
						
	}

	public void mover(){
		
		ArrayList<Punto> posicionesDeFantasmas = (ArrayList<Punto>) obtenerDistanciasDeFantasmas();
		
		ArrayList<Punto> vecinosValidos = (ArrayList<Punto>) tablero.obtenerAdjacentesValidos(this.posicion);
		
		for(Punto unVecinoValido: vecinosValidos){
			
			int distanciaMinima = 99999;
			
			int distancia = unVecinoValido.distancia(posicionesDeFantasmas.get(0));
			
			if(distancia<distanciaMinima){
				
				if(!this.posicion.equals(posicionesDeFantasmas.get(0))){
					
					this.posicion.nuevaPosicion(unVecinoValido);
				}
				//Lo tengo que revisar, falta.
			}
			
		}
		
		
		
		
		
		
		
	}

	private Collection<Punto> obtenerDistanciasDeFantasmas() {
		
		ArrayList<Punto> posicionesDeFantasmas = tablero.obtenerPosicionesDeFantasmas();
		
		Punto posicionDelPacman = tablero.obtenerPosicionDelPacman();
		
		ArrayList<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.ordenarPosicionesPorDistancia(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
	}
	@Override
	Punto calcularAtrapada(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	Punto calcularHuida(Collection<Punto> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}

}
