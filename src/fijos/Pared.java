package fijos;

public class Pared extends Casillero {

	private Punto ubicacion;
	private Tablero tablero;
	
	public Pared(Punto ubicacion, Tablero tablero) {

		this.ubicacion = ubicacion;
		this.tablero = tablero;
				
	}
	public boolean transitable(){
		
		return false;
	}
	
	
	
	
}
