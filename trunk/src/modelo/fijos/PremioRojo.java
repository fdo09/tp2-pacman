package modelo.fijos;


public class PremioRojo extends Premio {

	private static final int PUNTOS = 5000;
	
	public PremioRojo(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		
		
	}
	
	public void accionar(){
		if(!super.fuePisado()){
			Juego.getInstancia().getJugador().ganarPuntos(PUNTOS);
			super.setFuePisado(true);
		}
	}
	
}


