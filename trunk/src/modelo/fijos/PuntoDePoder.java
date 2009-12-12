package modelo.fijos;

import java.util.ArrayList;

import modelo.moviles.Fantasma;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;


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
			
			this.setFuePisado(true);
			
			this.cambiarEstadoDeFantasmas();
				
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
		}this.cambiarEstadoDeFantasmas();

	}


	private void cambiarEstadoDeFantasmas() {
		ArrayList<Fantasma> fantasmas = super.getTablero().getFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			unFantasma.cambiarEstado();

		}
	}
	
		


}
