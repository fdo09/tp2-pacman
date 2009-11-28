package fijos;

import modelo.Pacman;

public class Semilla extends Casillero implements IAccionable {
	
	
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado; 
	
	public Semilla(Punto ubicacion, Tablero tablero) {
		
		super(ubicacion, tablero);
		this.puntos = 200;
		this.fuePisado = false;
	}

	public boolean transitable(){
		
		return true;
	}
	
		
	public void accionar() {
		
		if (!fuePisado){
			
			Pacman pacman = tablero.obtenerPacman();
			pacman.sumarPuntos(this.puntos);
			
			fuePisado = true;
		}
	}

}
