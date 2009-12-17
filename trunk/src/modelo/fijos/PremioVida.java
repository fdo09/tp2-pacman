package modelo.fijos;


public class PremioVida extends Premio {

	
	
	public PremioVida(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);	
		
	}


	public void accionar() {
		
		if(!fuePisado()){
			Juego.getInstancia().getJugador().sumarVida();
			super.setFuePisado(true);
		}
	}
	
	
	
		
	

}




