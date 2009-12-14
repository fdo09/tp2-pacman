package modelo.fijos;

import java.util.ArrayList;

import modelo.moviles.Fantasma;


public class PuntoDePoder extends Casillero{

	private static final int PUNTOS = 500;
	private int tiempoDeDuracion = 30;
	
	public int getTiempo() {
		return this.tiempoDeDuracion;
	}


	public void setTiempo(int tiempo) {
		this.tiempoDeDuracion = tiempo;
	}


	public PuntoDePoder(Punto ubicacion, Tablero tablero) {
		super(ubicacion,tablero);		
		
	}

	
	public boolean transitable(){
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado()){
			
			
			
			this.setFuePisado(true);
			
			this.cambiarEstadoDeFantasmas(this.tiempoDeDuracion);
				
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
		}

	}


	private void cambiarEstadoDeFantasmas(int tiempo) {
		ArrayList<Fantasma> fantasmas = super.getTablero().getFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			unFantasma.cambiarEstado(tiempo);
		}
	}
	
		


}
