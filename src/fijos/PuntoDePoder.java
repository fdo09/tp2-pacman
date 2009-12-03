package fijos;

import java.util.ArrayList;

import modelo.Fantasma;


public class PuntoDePoder extends Casillero implements IAccionable{

	private static final int PUNTOS = 500;
	private boolean fuePisado;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
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
				Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
		
				this.fuePisado = true;
		}

	}
	
}
