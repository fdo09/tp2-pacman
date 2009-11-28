package modelo;

import java.util.Collection;

import fijos.*;

public class FantasmaRojo extends Fantasma {

	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
	
	public FantasmaRojo(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estados.INMUNE;			
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
