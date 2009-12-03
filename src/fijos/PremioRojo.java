package fijos;


public class PremioRojo extends Premio {

	private static final int PUNTOS = 5000;
	private boolean fuePisado;
	
	public PremioRojo(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.fuePisado = false;
		
	}
	
	public void accionar(){
		if(!fuePisado){
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
		}
	}
	
}


