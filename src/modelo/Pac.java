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
					
			this.posicion.translate(unValor, 0);
		}
	}
	
	private void desplazarseEnY(int unValor){
		boolean posicionValidaEnY;
		
		posicionValidaEnY = this.validarPosicionEnY(unValor);
		
		if(posicionValidaEnY)
			{
			this.posicion.translate(0, unValor);
			}
		
	}

	private boolean validarPosicionEnX(int unValor) {

		Point unaPosicion = new Point(unValor,(int) this.posicion.getY());
		
		unaPosicion.translate(unValor, 0);
		
		return tablero.esValida(unaPosicion);
		
	}
	
	private boolean validarPosicionEnY(int unValor) {

		Point unaPosicion = new Point();
		
		unaPosicion.translate(0, unValor);
		
		return tablero.esValida(unaPosicion);
	}


	
	public int getX() {
		
		return (int) this.posicion.getX();
	}


	public int getY() {
		
		return (int) this.posicion.getY();
	}
	
}