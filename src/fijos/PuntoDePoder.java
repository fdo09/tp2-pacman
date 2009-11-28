package fijos;

import java.util.ArrayList;

import modelo.Fantasma;
import modelo.Pacman;


public class PuntoDePoder extends Casillero implements IAccionable{

	private Punto ubicacion;
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {

		this.ubicacion = ubicacion;
		this.puntos = 1000;
		this.tablero = tablero;
		this.fuePisado = false;
		
	}

	public boolean transitable(){
		
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado){
			ArrayList<Fantasma> fantasmas = tablero.obtenerFantasmas();
			
				for(Fantasma unFantasma : fantasmas){
			
					unFantasma.mover();
			
				}
				Pacman pacman = tablero.obtenerPacman();
				pacman.sumarPuntos(this.puntos);
		
				this.fuePisado = true;
		}

	}
	
}
