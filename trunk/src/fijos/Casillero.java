package fijos;
import java.awt.Point;


public abstract class Casillero {
	
	
	private Punto ubicacion;
	private Tablero tablero;
		
	public Casillero(Punto ubicacion, Tablero tablero){
		
		this.ubicacion = ubicacion;
		this.tablero = tablero;
	}
		
	public abstract boolean transitable();
	

}
