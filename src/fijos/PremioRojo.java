package fijos;


public class PremioRojo extends Premio {

	private Punto ubicacion;
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public PremioRojo(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.ubicacion = ubicacion;
		this.puntos = 5000;
		this.tablero = tablero;
		this.fuePisado = false;
		
	}
	
	public void accionar() {
		
		
	}

	
	


}
