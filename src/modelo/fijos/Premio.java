package modelo.fijos;



public abstract class Premio extends Casillero{
	
	public Premio(Punto ubicacion, Tablero tablero) {
		super(ubicacion,tablero);
		setFuePisado(true);
	}
	

	public boolean transitable(){
		return true;
	}
	
	abstract public void accionar();

}
