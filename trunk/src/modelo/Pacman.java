package modelo;

import java.util.ArrayList;

import fijos.Casillero;
import fijos.Jugador;
import fijos.Punto;
import fijos.Tablero;

enum Direccion{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pacman extends Personaje{


	private Tablero tablero;
	private Punto posicion;
	private Direccion direccion;
	private Jugador jugador;
	
	public Pacman (Tablero tablero, Punto posicion){

		this.tablero = tablero;
		this.posicion = posicion;
		this.direccion = Direccion.DERECHA;
	}
	
	
	public void mover() {
		
		switch (this.direccion){
		
				case IZQUIERDA:
					this.moverIzquierda();
					break;
				case ARRIBA:
					this.moverArriba();
					break;
				case DERECHA:
					this.moverDerecha();
					break;
				case ABAJO:
					this.moverAbajo();
					break;
				}
		
		}

	private void moverIzquierda() {
		this.posicion.moverHaciaIzquierda();
		this.accionarCasillero();
	}
	
	private void moverArriba() {
		this.posicion.moverHaciaArriba();
		this.accionarCasillero();
	}
	
	private void moverDerecha() {
		this.posicion.moverHaciaDerecha();
		this.accionarCasillero();
	}

	private void moverAbajo() {
		this.posicion.moverHaciaAbajo();
		this.accionarCasillero();
	}
	
	private void accionarCasillero(){
		
		Casillero unCasillero = tablero.getCasillero(this.posicion);
		unCasillero.accionar();
		
	}
	
	private void comer(){
		
		ArrayList<Fantasma> fantasmas = tablero.obtenerFantasmas();
		
		for(Fantasma unFantasma : fantasmas){
			
			boolean posicionesIguales = (unFantasma.getPosicion().equals(unaPosicion));
			
			if(posicionesIguales & unFantasma.esComible()){
				
				unFantasma.serComido();
				
				jugador.sumarPuntos();
												
			}
			
		}
		
	}

	public void serComido(){
		
		jugador.restarVida();
		this.regresarAPosicionOriginal();
	}
	
	private void regresarAPosicionOriginal(){
		
		Punto posicionOriginal = new Punto(8,8);
		this.posicion.nuevaPosicion(posicionOriginal);
	}

	


	


	
	
	
}