package modelo.fijos;


public abstract class Casillero {
	
	
	private Punto ubicacion;
	protected Tablero tablero;
		
	public Casillero(Punto ubicacion, Tablero tablero){
		
		this.ubicacion = ubicacion;
		this.tablero = tablero;
	}
		
	public abstract boolean transitable();
	
	public abstract void accionar();
	

}
