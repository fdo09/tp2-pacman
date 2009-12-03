package fijos;

public class Casa extends Casillero {

	public Casa(Punto ubicacion, Tablero tablero) {
		super(ubicacion, tablero);
	}

	@Override
	public boolean transitable() {
		return true;
	}
	
	public void accionar(){
		
	}

}
