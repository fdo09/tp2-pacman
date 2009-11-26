package modelo;

import java.awt.Point;
import fijos.*;

enum Direcciones{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pac implements Personaje{


	private Tablero tablero;
	private Point posicion;
	private Direcciones direccion;
	
	public Pac (Tablero tablero, Point posicion){

		this.tablero = tablero;
		this.posicion = posicion;
		this.direccion = Direcciones.DERECHA;
	}
	
	
	public void vivir(){
		
		//Depende que tecla se presione el estado cambiará
		//por lo tanto el mover pac irá en la direccion correcta.
		this.mover();
		
	}

	public void mover() {
		
		switch (this.direccion){
		
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
	
}