package fijos;

import modelo.Pacman;


public abstract class Premio extends Casillero implements IAccionable{


	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public Premio(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 3000;
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
