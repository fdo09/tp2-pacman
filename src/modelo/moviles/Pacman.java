package modelo.moviles;

import java.util.Collection;

import modelo.fijos.Casillero;
import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;


public class Pacman extends Personaje implements Posicionable, ObjetoVivo{

	private Direccion direccionA;
	private Direccion direccionB;
	
	
	public Pacman (Tablero tablero ,Punto posicion){
		super(tablero, posicion);
		this.direccionA = Direccion.izquierda();
		this.direccionB = Direccion.derecha();
	}
	
	
	public void mover() {
		
		if (super.getEstado().equals(Estado.comido())){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			super.setEstado(Estado.vivo());
		}
		
		if(this.direccionA.equals(Direccion.izquierda()))
			this.moverIzquierda();
		else if(this.direccionA.equals(Direccion.arriba()))
			this.moverArriba();
		else if(this.direccionA.equals(Direccion.derecha()))
			this.moverDerecha();
		else if(this.direccionA.equals(Direccion.abajo()))
			this.moverAbajo();
	}
	
	public void setMovimiento(String direccion){
		if ( direccion == "IZQ"){
			if (!this.direccionA.equals(Direccion.izquierda())){
				this.direccionB = this.direccionA;
				this.direccionA = Direccion.izquierda();
			}
		}else if ( direccion == "DOWN"){
			if (!this.direccionA.equals(Direccion.abajo())){
				this.direccionB = this.direccionA;
				this.direccionA = Direccion.abajo();
			  }
		}else if ( direccion == "UP"){
			if (!this.direccionA.equals(Direccion.arriba())){
				this.direccionB = this.direccionA;
				this.direccionA = Direccion.arriba();
			  }
		}else if ( direccion == "DER"){
			if (!this.direccionA.equals(Direccion.derecha())){
				this.direccionB = this.direccionA;
				this.direccionA = Direccion.derecha();
			}
		}
		
	}

	private void moverIzquierda() {
		
		Punto vecino = this.getPosicion().getVecinoIzquierdo();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaIzquierda();
			this.comer();
			this.accionarCasillero();
		}else if(this.direccionB.equals(Direccion.derecha())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverDerecha();
			
		}else if(this.direccionB.equals(Direccion.arriba())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverArriba();
		}else if(this.direccionB.equals(Direccion.abajo())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverAbajo();
			
		}
	
	
	}
	
	private void moverArriba() {
		
		Punto vecino = this.getPosicion().getVecinoDeArriba();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaArriba();
			this.comer();
			this.accionarCasillero();
		}else if(this.direccionB.equals(Direccion.derecha())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverDerecha();
			
		}else if(this.direccionB.equals(Direccion.izquierda())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverIzquierda();
		
		}else if(this.direccionB.equals(Direccion.abajo())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverAbajo();
			
		}
	}
	
	private void moverDerecha() {
		
		Punto vecino = this.getPosicion().getVecinoDerecho();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaDerecha();
			this.comer();
			this.accionarCasillero();
		}else if(this.direccionB.equals(Direccion.izquierda())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverIzquierda();
			
		}else if(this.direccionB.equals(Direccion.arriba())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverArriba();
			
		}else if(this.direccionB.equals(Direccion.abajo())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverAbajo();

		}
	}

	private void moverAbajo() {
		
		Punto vecino = this.getPosicion().getVecinoDeAbajo();
		
		if(super.getTablero().esTransitable(vecino)){
			
			this.getPosicion().moverHaciaAbajo();
			this.comer();
			this.accionarCasillero();
		}else if(this.direccionB.equals(Direccion.derecha())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverDerecha();
			
		}else if(this.direccionB.equals(Direccion.arriba())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverArriba();
			
		}else if(this.direccionB.equals(Direccion.izquierda())){
			// Prueba
			this.direccionA = this.direccionB;
			this.moverIzquierda();
			
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
				continue;
			}
			if(unFantasma.esComible()){
				unFantasma.serComido();					
			}
			else{
				for(Fantasma fantasma : fantasmas){
					
					fantasma.volverACasa();
				}
				this.serComido();
				
			}
			
		}
	}

	public void serComido(){
		
		Juego.getInstancia().getJugador().restarVida();
		this.regresarAPosicionOriginal();
		super.setEstado(Estado.comido());

	}
	
	private void regresarAPosicionOriginal(){
		
		this.setPosicion(super.getPosicionInicial());
	}

	
	public Direccion getDireccionA() {
		return direccionA;
	}
	
	//Metodos provisorios utilizados para la visibilidad.

	public int getX() {
		return 25 * super.getPosicion().getPuntoX();
	}


	public int getY() {
		return 25 * super.getPosicion().getPuntoY();
	}


	public void vivir() {
		
			this.mover();
		
	}

	
}