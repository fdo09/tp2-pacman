package modelo.fijos;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;

import modelo.moviles.Fantasma;


public class PuntoDePoder extends Casillero implements ObjetoVivo{

	private static final int PUNTOS = 500;
	private int tiempoCambioDeEstado;
	
	public PuntoDePoder(Punto ubicacion, Tablero tablero) {
		super(ubicacion,tablero);		
		this.tiempoCambioDeEstado = 10;
	}

	
	public boolean transitable(){
		return true;
	}

	
	public void accionar() {
		
		if(!fuePisado()){
			this.cambiarEstadoDeFantasmas();
				
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
			this.setFuePisado(true);
		}

	}


	private void cambiarEstadoDeFantasmas() {
		ArrayList<Fantasma> fantasmas = super.getTablero().getFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			unFantasma.cambiarEstado();

		}
	}
	public void vivir(){
		
		int tiempoRestante = this.disminuirTiempo();
		
		boolean quedaTiempo = this.tiempoCambioDeEstado>= tiempoRestante;
				
		if(!quedaTiempo){
			
			this.cambiarEstadoDeFantasmas();
			this.reiniciarCronometro();
						
		}
		
	}


	private void reiniciarCronometro() {
		this.tiempoCambioDeEstado = 10;
		
	}


	private int disminuirTiempo() {
		return this.tiempoCambioDeEstado -=1;
	}
	
}
