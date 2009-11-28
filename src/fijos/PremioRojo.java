package fijos;


public class PremioRojo extends Premio {

	
	private int puntos;
	private boolean fuePisado;
	
	public PremioRojo(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.puntos = 5000;
		this.fuePisado = false;
		
	}
	
}


