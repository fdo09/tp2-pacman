package fijos;

import modelo.Pacman;


public class PremioRojo extends Premio {

	
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public PremioRojo(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 5000;
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


