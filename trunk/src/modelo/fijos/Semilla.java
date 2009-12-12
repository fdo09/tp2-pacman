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
			setFuePisado(true);
			
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			
			Juego.getInstancia().getTablero().restarSemilla();;
		}
	}

}
