package fijos;


public class PremioAzul extends Premio {

	
	private int puntos;
	private boolean fuePisado;
	
	public PremioAzul(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 3000;
		this.fuePisado = false;
		
	}
	
		
	

}




