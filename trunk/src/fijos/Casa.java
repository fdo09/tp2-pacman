package fijos;

public class Casa extends Casillero {

	public Casa(Punto ubicacion, Tablero tablero) {
		super(ubicacion, tablero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean transitable() {
		// TODO Auto-generated method stub
		return true;
	}

}
