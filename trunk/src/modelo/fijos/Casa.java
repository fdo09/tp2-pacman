package modelo.fijos;

public class Casa extends Casillero {

	boolean ocupada;
	
	public Casa(Punto ubicacion, Tablero tablero) {
		super(ubicacion, tablero);
		this.ocupada = false;
	}

	public boolean isOcupada(){
		return this.ocupada;
	}
	
	public boolean transitable() {
		return false;
	}
	
	public void accionar(){
		
	}

}
