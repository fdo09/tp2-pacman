package modelo;

import java.awt.Point;

enum Direcciones{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pac implements Personaje{


	private Tablero tablero;
	private Point posicion;
	private Direcciones estado;
	
	public Pac (Tablero tablero, Point posicion){
		
		
		
		this.tablero = tablero;
		this.posicion = posicion;
		this.estado = Direcciones.DERECHA;
	}
	
	
	public void vivir(){
		
		//Depende que tecla se presione el estado cambiará
		//por lo tanto el mover pac irá en la direccion correcta.
		this.mover();
		
	}

	public void mover() {
		
		switch (this.estado){
		
				case IZQUIERDA:
					this.desplazarseEnX(-1);
					break;
				case ARRIBA:
					this.desplazarseEnY(1);
					break;
				case DERECHA:
					this.desplazarseEnX(1);
					break;
				case ABAJO:
					this.desplazarseEnY(-1);
					break;
				}
		
		}

	private void desplazarseEnX(int unValor){
		
		boolean posicionValidaEnX;
		posicionValidaEnX = this.validarPosicionEnX(unValor);
		
		if(posicionValidaEnX){
					
			this.posicion.setLocation(this.posicion.getX()+ unValor, (this.posicion.getY()));
		}
	}
	
	private void desplazarseEnY(int unValor){
		boolean posicionValidaEnY;
		
		posicionValidaEnY = this.validarPosicionEnY(unValor);
		
		if(posicionValidaEnY)
			{
			this.posicion.setLocation(this.posicion.getX(), (this.posicion.getY() + unValor));
			}
		
	}

	private boolean validarPosicionEnX(int unValor) {

		Point unaPosicion = new Point(unValor,(int) this.posicion.getY());
		
		unaPosicion.setLocation(this.posicion.getX()+ unValor, (this.posicion.getY()));
		
		return hayObstaculo(unaPosicion);
		
	}
	
	private boolean validarPosicionEnY(int unValor) {

		Point unaPosicion = new Point();
		
		unaPosicion.setLocation(this.posicion.getX(), (this.posicion.getY()+ unValor));
		
		return hayObstaculo(unaPosicion);
	}


	private boolean hayObstaculo(Point unaPosicion) {
		if(tablero.hayObstaculo(unaPosicion)){
			return false;
		}return true;
	}
	
	
	public int getX() {
		// TODO Auto-generated method stub
		return (int) posicion.getX();
	}


	public int getY() {
		// TODO Auto-generated method stub
		return (int) posicion.getY();
	}
	
}