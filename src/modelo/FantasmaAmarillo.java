package modelo;

import java.util.Collection;

import fijos.*;

public class FantasmaAmarillo extends Fantasma {
	
	private Tablero tablero;
	private Punto posicion;
	private Estados estado;

	public FantasmaAmarillo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
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
