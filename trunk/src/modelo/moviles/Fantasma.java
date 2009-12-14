package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.vista.control.Integrante;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public abstract class Fantasma extends Personaje implements Integrante, ObjetoVivo{

	private Objetivo objetivo;
	private int puntos;
	private Punto casa;
	protected Punto posicionAnterior;
	public static final int PUNTOS = 200;
	private int tiempoPoder;
	private int tiempoEnCasa;
	
	public Fantasma(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.objetivo = Objetivo.atrapar();
		this.puntos = PUNTOS;
		this.casa = new Punto (posicion);
		this.posicionAnterior = new Punto (posicion);
		this.tiempoPoder = 0;
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
		
		if (super.getEstado().equals(Estado.comido())){
			this.salirDeCasa();
		}
		
		else if (this.objetivo.equals(Objetivo.atrapar()))
			this.atrapar(adjacentesValidos);
		
		else if (this.objetivo.equals(Objetivo.huir()))
			this.huir(adjacentesValidos);
	}


	protected void salirDeCasa() {
		this.tiempoEnCasa--;
		if ( this.tiempoEnCasa <= 0){
			this.objetivo = Objetivo.atrapar();
			super.setEstado(Estado.vivo());
		}
	}


	protected void atrapar(Collection<Punto> adjacentesValidos) {
		Punto nuevaPosicion;
		nuevaPosicion = this.calcularAtrapada(adjacentesValidos);
		this.setPosicion(nuevaPosicion);
		this.comer();
	}


	protected void huir(Collection<Punto> adjacentesValidos) {
		Punto nuevaPosicion;
		if (tiempoPoder>0){
			nuevaPosicion = this.calcularHuida(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
			this.serComido();
			this.restarTiempo();
		}else
			this.objetivo = Objetivo.atrapar();
		
	}
	
	
	private void restarTiempo() {
		this.tiempoPoder--;
		
	}


	protected void comer() {
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion())){
			pacman.serComido();
			Collection<Fantasma> fantasmas = super.getTablero().getFantasmas();
			for(Fantasma fantasma : fantasmas){
				// Cambio a estado comido para que se quede en su casa un tiempo.
				fantasma.setEstado(Estado.comido());
				fantasma.volverACasa();
			}
		}
	}
	
	
	protected void serComido(){
		
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion()))
		{
			Juego.getInstancia().getJugador().ganarPuntos(Fantasma.PUNTOS);
			this.volverACasa();
			super.setEstado(Estado.comido());
		}
	}
	
	
	public boolean esComible(){
		return (this.objetivo.equals(Objetivo.huir()));
	}
	
	
	protected Punto getCasa(){
		return this.casa;
	}

	
	public Punto getPosicion(){
		return super.getPosicion();
	}


	public void cambiarEstado(int unTiempo) {
		
		this.tiempoPoder += unTiempo;
		
		if(this.getObjetivo().equals(Objetivo.atrapar())){
			this.objetivo = Objetivo.huir();
		}			
	}

	public void volverACasa(){
		this.tiempoPoder = 0;
		this.tiempoEnCasa = 10;
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

	
	public Tablero getTablero() {
		return super.getTablero();
	}

	
	public void setPosicion(Punto posicion) {
		super.setPosicion(posicion);
	}


	public Objetivo getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}


	

}
	