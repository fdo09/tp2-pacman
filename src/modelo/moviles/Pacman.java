package modelo.moviles;

import java.util.Collection;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

import modelo.fijos.Casillero;
import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;

enum Direccion{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class Pacman extends Personaje implements Posicionable, ObjetoVivo{

	private Direccion direccion;
	
	public Pacman (Tablero tablero ,Punto posicion){
		super(tablero, posicion);
		this.direccion = Direccion.IZQUIERDA;
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
	
	public void setMovimiento(String direccion){
		if ( direccion == "IZQ"){
			this.direccion = Direccion.IZQUIERDA;
		}else if ( direccion == "DOWN"){
			this.direccion = Direccion.ABAJO;
		}else if ( direccion == "UP"){
			this.direccion = Direccion.ARRIBA;
		}else if ( direccion == "DER"){
			this.direccion = Direccion.DERECHA;
		}
		
	}

	private void moverIzquierda() {
		
		Punto vecino = this.getPosicion().getVecinoIzquierdo();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaIzquierda();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverArriba() {
		
		Punto vecino = this.getPosicion().getVecinoDeArriba();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaArriba();
			this.comer();
			this.accionarCasillero();
		}
	}
	
	private void moverDerecha() {
		
		Punto vecino = this.getPosicion().getVecinoDerecho();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaDerecha();
			this.comer();
			this.accionarCasillero();
		}
	}

	private void moverAbajo() {
		
		Punto vecino = this.getPosicion().getVecinoDeAbajo();
		
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
		
		Collection<Fantasma> fantasmas = super.getTablero().getFantasmas();
		for(Fantasma unFantasma : fantasmas){
			
			boolean posicionesIguales = (this.getPosicion().equals(unFantasma.getPosicion()));
			if(!posicionesIguales){
				return;
			}
			if(unFantasma.esComible()){
				unFantasma.serComido();					
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

	
	//Metodos provisorios utilizados para la visibilidad.

	public int getX() {
		return 25 * super.getPosicion().getPuntoX();
	}


	public int getY() {
		return 25 * super.getPosicion().getPuntoY();
	}


	public void vivir() {
		// this.moverIzquierda();
		this.mover();
	}

	
}