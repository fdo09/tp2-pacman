package modelo.fijos;

import java.util.ArrayList;

import modelo.moviles.Fantasma;


public class PuntoDePoder extends Casillero{

	private static final int PUNTOS = 500;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);		
	}

	public boolean transitable(){
		
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado()){
			ArrayList<Fantasma> fantasmas = super.getTablero().getFantasmas();
			
				for(Fantasma unFantasma : fantasmas){
			
					unFantasma.cambiarEstado();
			
				}
				Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
		
				this.setFuePisado(true);
		}

	}
	
}
