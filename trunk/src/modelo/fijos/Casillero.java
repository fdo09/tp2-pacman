package modelo.fijos;

import ar.uba.fi.algo3.titiritero.Posicionable;


public abstract class Casillero implements Posicionable{
	
	
	private Punto ubicacion;
	private Tablero tablero;
	private boolean fuePisado;
		
	public Casillero(Punto ubicacion, Tablero tablero){
		
		this.ubicacion = ubicacion;
		this.tablero = tablero;
		this.fuePisado = false;
	}
		
	public abstract boolean transitable();
	
	public abstract void accionar();

	
	public void setFuePisado(boolean fuePisado) {
		this.fuePisado = fuePisado;
	}


	public Tablero getTablero() {
		return tablero;
	}
	
	
	public boolean fuePisado() {
		return fuePisado;
	}
	
	public int getX() {
		
		return 25 * this.ubicacion.getPuntoX();
	}


	public int getY() {
		
		return 25 * this.ubicacion.getPuntoY();
	}

}
