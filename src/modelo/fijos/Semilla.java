package modelo.fijos;

public class Semilla extends Casillero {
	
	private static final int PUNTOS = 50;
	
	public Semilla(Punto ubicacion, Tablero tablero) {
		
		super(ubicacion, tablero);
	}

	public boolean transitable(){
		
		return true;
	}
	
		
	public void accionar() {
		
		if (!fuePisado()){
			
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
			setFuePisado(true);
			
			Juego.getInstancia().getTablero().restarSemilla();;
		}
	}

}
