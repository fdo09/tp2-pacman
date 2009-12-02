package fijos;

import java.util.ArrayList;
import java.util.Collection;

import modelo.Fantasma;
import modelo.Pacman;


public class PuntoDePoder extends Casillero implements IAccionable{

	
	private int puntos;
	// private Tablero tablero;
	private boolean fuePisado;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 1000;
		this.fuePisado = false;
		
	}

	public boolean transitable(){
		
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado){
			ArrayList<Fantasma> fantasmas = super.tablero.obtenerFantasmas();
			
				for(Fantasma unFantasma : fantasmas){
			
					unFantasma.cambiarEstado();
			
				}
				Pacman pacman = super.tablero.obtenerPacman();
				pacman.sumarPuntos(this.puntos);
		
				this.fuePisado = true;
		}

	}
	
}
