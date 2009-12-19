package modelo.fijos;

import java.util.ArrayList;

import modelo.moviles.Fantasma;


public class PuntoDePoder extends Casillero{

	private static final int PUNTOS = 500;
	private static int tiempoDeDuracion = 30;
	
	


	public PuntoDePoder(Punto ubicacion, Tablero tablero) {
		super(ubicacion,tablero);		
		
	}

	public int getTiempo() {
		return tiempoDeDuracion;
	}


	public void setTiempo(int tiempo) {
		tiempoDeDuracion = tiempo;
	}
	
	public boolean transitable(){
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado()){
			
			
			
			this.setFuePisado(true);
			
			this.cambiarObjetivoDeFantasmas(tiempoDeDuracion);
				
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
		}

	}


	private void cambiarObjetivoDeFantasmas(int tiempo) {
		ArrayList<Fantasma> fantasmas = super.getTablero().getFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			unFantasma.cambiarObjetivo(tiempo);
		}
	}
	
	public static void cambiarDuracion(){
		
		int tiempo = 5;
		tiempoDeDuracion -= tiempo;
	}


}
