package modelo.moviles;

import java.util.Collection;

import modelo.fijos.Casillero;
import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;

enum Direccion{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pacman extends Personaje{

	private Direccion direccion;
	
	public Pacman (Tablero tablero ,Punto posicion){
		super(tablero, posicion);
		this.direccion = Direccion.IZQUIERDA;
	}
	
	public Punto obtenerPosicion(){
		
		return super.getPosicion();
		
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
		
		Punto vecino = this.getPosicion().obtenerVecinoIzquierdo();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaIzquierda();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverArriba() {
		
		Punto vecino = this.getPosicion().obtenerVecinoDeArriba();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaArriba();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverDerecha() {
		
		Punto vecino = this.getPosicion().obtenerVecinoDerecho();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaDerecha();
			this.comer();
			this.accionarCasillero();
		}
	}

	private void moverAbajo() {
		
		Punto vecino = this.getPosicion().obtenerVecinoDeAbajo();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaAbajo();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void accionarCasillero(){
		
		Casillero unCasillero = super.getTablero().getCasillero(this.getPosicion());
		unCasillero.accionar();
		
	}
	
	private void comer(){
		
		Collection<Fantasma> fantasmas = super.getTablero().obtenerFantasmas();
		for(Fantasma unFantasma : fantasmas){
			
			boolean posicionesIguales = (this.getPosicion().equals(unFantasma.getPosicion()));
			if(!posicionesIguales){
				return;
			}
			if(unFantasma.esComible()){
				unFantasma.serComido();
				Juego.getInstancia().getJugador().ganarPuntos(unFantasma.obtenerPuntos());							
			}if(!unFantasma.esComible()){
				
				this.serComido();
			}
			else{
				this.serComido();
			}
		}
	}

	public void serComido(){
		
		Juego.getInstancia().getJugador().restarVida();
		this.regresarAPosicionOriginal();
	}
	
	private void regresarAPosicionOriginal(){
		
		this.setPosicion(super.getPosicionInicial());
	}

	
}