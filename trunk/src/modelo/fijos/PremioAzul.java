package modelo.fijos;


public class PremioAzul extends Premio {

	
	
	public PremioAzul(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);	
		
	}


	public void accionar() {
		
		if(!fuePisado()){
			Juego.getInstancia().getJugador().sumarVida();
			super.setFuePisado(true);
		}
	}
	
	
	
		
	

}




