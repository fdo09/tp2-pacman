package fijos;

public class Pared extends Casillero {

	
	
	public Pared(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
				
	}
	public boolean transitable(){
		
		return false;
	}
	
	public void accionar(){
		
	}
	
	
	
	
}
