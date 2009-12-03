package fijos;

public class Semilla extends Casillero {
	
	private static final int PUNTOS = 50;
	private boolean fuePisado; 
	
	public Semilla(Punto ubicacion, Tablero tablero) {
		
		super(ubicacion, tablero);
		this.fuePisado = false;
	}

	public boolean transitable(){
		
		return true;
	}
	
		
	public void accionar() {
		
		if (!fuePisado){
			
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
			fuePisado = true;
		}
	}

}
