package modelo.moviles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import modelo.excepciones.VelocInvalidaFantasException;
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
	private int velocidad;
	private int velocidadActual;
	
	public Fantasma(Tablero tablero, Punto posicion, int velocidad) {
		super(tablero, posicion);
		this.objetivo = Objetivo.atrapar();
		this.puntos = PUNTOS;
		this.casa = new Punto (posicion);
		this.posicionAnterior = new Punto (posicion);
		this.tiempoPoder = 0;
		this.velocidadActual = 0;
		this.setVelocidad(velocidad);
	}
	
	public void vivir () {
		
		this.aumentarVelocidadActual();
		if(this.velocidadActual == this.velocidad){
			
			this.mover();
			this.velocidadActual = 0;
		}
		
	}
	
	public void aumentarVelocidad(){
		
		this.velocidad--;
		
	}
	
	protected void aumentarVelocidadActual() {
		this.velocidadActual++;
		
	}
	
	

	public void setVelocidad(int velocidad) {
		int velocidadMinima = 3;
		
		int velocidadMaxima = 1;
		
		try{
			if(velocidad> velocidadMinima)
				throw new VelocInvalidaFantasException();
		
			else if(velocidad == 0){
				this.velocidad = velocidadMaxima;
			}
			else{
				this.velocidad = velocidad;
			}
		}
		catch(VelocInvalidaFantasException e){
			
			this.velocidad = velocidadMinima;
		}
			
			
	}

	public int getVelocidad() {
		return this.velocidad;
	}
	
	public int getVelocidadActual() {
		return this.velocidadActual;
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
		
		else if (this.objetivo.equals(Objetivo.aCasa())){
			this.volverACasa();
			super.setEstado(Estado.comido());
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
				fantasma.setObjetivo(Objetivo.aCasa());
			}
		}
	}
	
	
	protected void serComido(){
		
		Pacman pacman = this.getTablero().getPacman();
		if(this.getPosicion().equals(pacman.getPosicion()))
		{
			Juego.getInstancia().getJugador().ganarPuntos(Fantasma.PUNTOS);
			this.setObjetivo(Objetivo.aCasa());
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
		this.setEstado(Estado.comido());
		this.setPosicion(super.getPosicionInicial());
		}
		
	
	
	protected LinkedList<Punto> getFantasmasOrdenadosPorDistancia() {
		
		ArrayList<Fantasma> fantasmas = getTablero().getFantasmas();
		LinkedList<Punto> posicionesFantasmas = new LinkedList();
		Punto posicionDelPacman = getTablero().getPacman().getPosicion();
		
		for (Fantasma fant : fantasmas){
			posicionesFantasmas.push(fant.getPosicion());
		}
		
		LinkedList<Punto> posicionesDeFantasmasOrdenadas;
		posicionesDeFantasmasOrdenadas = posicionDelPacman.getPosicionesOrdenadas(posicionesFantasmas);
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
	