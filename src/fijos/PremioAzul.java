package fijos;


public class PremioAzul extends Premio {

	private Punto ubicacion;
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public PremioAzul(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.ubicacion = ubicacion;
		this.puntos = 3000;
		this.tablero = tablero;
		this.fuePisado = false;
		
	}
	
	public void accionar() {
		
		
	}
	
	

	

	
}
