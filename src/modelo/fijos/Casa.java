package modelo.fijos;

public class Casa extends Casillero {
	
	public Casa(Punto ubicacion, Tablero tablero) {
		super(ubicacion, tablero);
	}
	
	
	public boolean transitable() {
		return false;
	}
	
	
	public void accionar(){
		
	}

}
