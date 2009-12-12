package modelo.moviles;

import java.util.Collection;
import java.util.LinkedList;

import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.vista.control.Integrante;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public abstract class Fantasma extends Personaje implements Integrante, ObjetoVivo{

	private Estado estado;
	private int puntos;
	private Punto casa;
	protected Punto posicionAnterior;
	public static final int PUNTOS = 200;
	private int tiempo;
	
	public Fantasma(Tablero tablero, Punto posicion) {
		super(tablero, posicion);
		this.estado = Estado.atrapar();
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
		
		if (this.estado.equals(Estado.atrapar()))
			this.atrapar(adjacentesValidos);
		
		else if (this.estado.equals(Estado.huir()))
			this.huir(adjacentesValidos);
		
		else if (this.estado.equals(Estado.comido())){
			this.volverACasa();
			this.setEstado(Estado.atrapar());
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
		if (tiempo>0){
			nuevaPosicion = this.calcularHuida(adjacentesValidos);
			this.setPosicion(nuevaPosicion);
			this.serComido();
			this.restarTiempo();
		}else
			this.setEstado(Estado.atrapar());
		
	}
	
	
	private void restarTiempo() {
		this.tiempo--;
		
	}


	protected void comer() {
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion())){
			pacman.serComido();
			Collection<Fantasma> fantasmas = super.getTablero().getFantasmas();
			for(Fantasma fantasma : fantasmas){
				
				fantasma.volverACasa();
			}
		}
	}
	
	
	protected void serComido(){
		
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion()))
		{
			this.volverACasa();
			Juego.getInstancia().getJugador().ganarPuntos(Fantasma.PUNTOS);
			this.estado = Estado.atrapar();
		}
	}
	
	
	public boolean esComible(){
		return (this.getEstado().equals(Estado.huir()));
	}
	
	
	protected Punto getCasa(){
		return this.casa;
	}

	
	public Punto getPosicion(){
		return super.getPosicion();
	}


	public void cambiarEstado(int unTiempo) {
		
		this.tiempo += unTiempo;
		
		if(this.getEstado().equals(Estado.atrapar())){
			this.setEstado(Estado.huir());
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
	

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	public Estado getEstado() {
		return estado;
	}

	
	public void setPosicion(Punto posicion) {
		super.setPosicion(posicion);
	}


	

}
	