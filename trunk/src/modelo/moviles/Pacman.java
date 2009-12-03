package modelo.moviles;

import java.util.Collection;

import modelo.fijos.*;

enum Direccion{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pacman extends Personaje{


	private Tablero tablero;
	private Punto posicion;
	private Direccion direccion;
	private Punto posicionInicial;
	
	public Pacman (Tablero tablero ,Punto posicion){
		this.tablero = tablero;
		this.posicion = posicion;
		this.posicionInicial = posicion;
		this.direccion = Direccion.DERECHA;
	}
	
	public Punto obtenerPosicion(){
		
		return this.posicion;
		
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
		
		Punto vecino = this.posicion.obtenerVecinoIzquierdo();
		
		if(tablero.esTransitable(vecino)){
			
			this.posicion.moverHaciaIzquierda();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverArriba() {
		
		Punto vecino = this.posicion.obtenerVecinoDeArriba();
		
		if(tablero.esTransitable(vecino)){
			
			this.posicion.moverHaciaArriba();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverDerecha() {
		
		Punto vecino = this.posicion.obtenerVecinoDerecho();
		
		if(tablero.esTransitable(vecino)){
			
			this.posicion.moverHaciaDerecha();
			this.comer();
			this.accionarCasillero();
		}
	}

	private void moverAbajo() {
		
		Punto vecino = this.posicion.obtenerVecinoDeAbajo();
		
		if(tablero.esTransitable(vecino)){
			
			this.posicion.moverHaciaAbajo();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void accionarCasillero(){
		
		Casillero unCasillero = tablero.getCasillero(this.posicion);
		unCasillero.accionar();
		
	}
	
	private void comer(){
		
		Collection<Fantasma> fantasmas = tablero.obtenerFantasmas();
		for(Fantasma unFantasma : fantasmas){
			
			boolean posicionesIguales = (this.posicion.equals(unFantasma.getPosicion()));
			if(posicionesIguales && unFantasma.esComible()){
				
				unFantasma.serComido();
				Juego.getInstancia().getJugador().ganarPuntos(unFantasma.PUNTOS);
																
			}
		}
	}

	public void serComido(){
		
		Juego.getInstancia().getJugador().restarVida();
		this.regresarAPosicionOriginal();
	}
	
	private void regresarAPosicionOriginal(){
		
		this.posicion = this.posicionInicial;
	}

	
}