package fijos;



public abstract class Premio extends Casillero implements IAccionable{

	private boolean fuePisado;
	
	public Premio(Punto ubicacion, Tablero tablero) {

		super(ubicacion,tablero);
		this.fuePisado = false;
		
	}
	

	public boolean transitable(){
		
		return true;
	}
	
	abstract public void accionar();


}
