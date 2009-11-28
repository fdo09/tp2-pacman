package fijos;

import java.util.ArrayList;

import modelo.Fantasma;


public class PuntoDePoder extends Casillero {

	private Punto ubicacion;
	private int puntos;
	private Tablero tablero;
	
	public PuntoDePoder(Punto unaUbicacion, Tablero tablero) {
		super(unaUbicacion);
		this.puntos = 1000;
		this.tablero = tablero;
		
	}

	public boolean transitable(){
		
		return true;
	}

	
	public void accionar() {
		
		ArrayList<Fantasma> fantasmas = tablero.obtenerFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			
			unFantasma.mover();
			
		}
		
		
	}

	
}
