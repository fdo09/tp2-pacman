package modelo.fijos;


public class PremioAzul extends Premio {

	private static final int PUNTOS = 3000;
	private boolean fuePisado;
	
	public PremioAzul(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.fuePisado = false;
		
	}


	public void accionar() {
		if(!fuePisado){
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
		}
	}
	
	
	
		
	

}




