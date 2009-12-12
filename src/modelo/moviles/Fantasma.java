package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.vista.control.Integrante;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

enum Estados{ATRAPAR, HUIR, COMIDO};

public abstract class Fantasma extends Personaje implements Integrante, ObjetoVivo{

	private Estados estado;
	private int puntos;
	private Punto casa;
	protected Punto posicionAnterior;
	public static final int PUNTOS = 200;
	private int tiempo;
	
	public Fantasma(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.setEstado(Estados.ATRAPAR);
		this.puntos = PUNTOS;
		this.casa = new Punto (posicion);
		this.posicionAnterior = new Punto (posicion);
		this.tiempo = 0;
	}
	
	
	protected abstract Punto calcularHuida(Collection<Punto> adjacentesValidos);

	protected abstract Punto calcularAtrapada(Collection<Punto> adjacentesValidos);
	
	
	public void mover(){
		/*
		 * Realiza el movimiento del fantasma de acuerdo a su estado y su estrategia. La estrategia esta implementada en 
		 * cada fantasma.
		 * Luego de moverse verifica si esta en la misma posicion que el pacman para comerselo o ser comido por �l.
		 */
		
		Collection<Punto> adjacentesValidos = this.getTablero().getAdjacentesValidos(this.getPosicion());
		adjacentesValidos.remove(this.posicionAnterior);
		posicionAnterior = new Punto (super.getPosicion());
		
		switch (this.getEstado()){
		case ATRAPAR:
			
			this.atrapar(adjacentesValidos);
			
			break;
		case HUIR:
			
			this.huir(adjacentesValidos);
			
			break;
		case COMIDO:
			this.volverACasa();
			this.setEstado(Estados.ATRAPAR);
		}
	}


	private void atrapar(Collection<Punto> adjacentesValidos) {
		Punto nuevaPosicion;
		nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
		this.setPosicion(nuevaPosicion);
		this.comer();
	}


	private void huir(Collection<Punto> adjacentesValidos) {
		Punto nuevaPosicion;
		if(tiempo>=0){
			nuevaPosicion = this.calcularHuida(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
			this.serComido();
		}else
			this.setEstado(Estados.ATRAPAR);
		this.restarTiempo();
	}
	
	
	private void restarTiempo() {
		this.tiempo--;
		
	}


	protected void comer() {
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion())){
			pacman.serComido();
		}
	}
	
	
	protected void serComido(){
		
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion()))
		{
			this.volverACasa();
			Juego.getInstancia().getJugador().ganarPuntos(Fantasma.PUNTOS);
			this.estado = Estados.ATRAPAR;
		}
	}
	
	
	public boolean esComible(){
		return (this.getEstado() == Estados.HUIR);
	}
	
	
	protected Punto getCasa(){
		return this.casa;
	}

	
	public Punto getPosicion(){
		return super.getPosicion();
	}


	public void cambiarEstado(int unTiempo) {
		
		tiempo = unTiempo;
		
		if(this.getEstado() == Estados.ATRAPAR){
			this.setEstado(Estados.HUIR);
		}
		else{
			this.setEstado(Estados.ATRAPAR);
		}
					
	}

	public void volverACasa(){
		
		this.setPosicion(super.getPosicionInicial());
		}
		
	
	
	protected LinkedList<Punto> getFantasmasOrdenadosPorDistancia() {
		
		LinkedList<Punto> posicionesDeFantasmas = getTablero().getPosicionesDeFantasmas();
		
		Punto posicionDelPacman = getTablero().getPacman().getPosicion();
		
		LinkedList<Punto> posicionesDeFantasmasOrdenadas;
		
		posicionesDeFantasmasOrdenadas = posicionDelPacman.getPosicionesOrdenadas(posicionesDeFantasmas);
		
		return posicionesDeFantasmasOrdenadas;
	}
	

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	

	public int getPuntos() {
		return puntos;
	}
	

	public void setTablero(Tablero tablero) {
		super.setTablero(tablero);
	}

	
	public Tablero getTablero() {
		return super.getTablero();
	}
	

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	
	public Estados getEstado() {
		return estado;
	}

	
	public void setPosicion(Punto posicion) {
		super.setPosicion(posicion);
	}


	

}
	