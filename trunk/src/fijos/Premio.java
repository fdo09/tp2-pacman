package fijos;


public abstract class Premio extends Casillero implements IAccionable{

	private Punto ubicacion;
	private int puntos;
	private Tablero tablero;
	private boolean fuePisado;
	
	public Premio(Punto ubicacion, Tablero tablero) {

		this.ubicacion = ubicacion;
		this.puntos = 3000;
		this.tablero = tablero;
		this.fuePisado = false;
		
	}
	

	public boolean transitable(){
		
		return true;
	}
	
	public void accionar(){}

}
