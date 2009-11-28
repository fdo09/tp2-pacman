package fijos;

import java.util.Collection;

import modelo.Fantasma;
import modelo.Pacman;


public class PuntoDePoder extends Casillero implements IAccionable{

	
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 1000;
		this.tablero = tablero;
		this.fuePisado = false;
		
	}

	public boolean transitable(){
		
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado){
			Collection<Fantasma> fantasmas = tablero.obtenerFantasmas();
			
				for(Fantasma unFantasma : fantasmas){
			
					unFantasma.mover();
			
				}
				Pacman pacman = tablero.obtenerPacman();
				pacman.sumarPuntos(this.puntos);
		
				this.fuePisado = true;
		}

	}
	
}
