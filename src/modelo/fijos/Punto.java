package modelo.fijos;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import ar.uba.fi.algo3.titiritero.Posicionable;




/**
 * @author Juli�n D'Ambrosio
 *
 */

public class Punto implements Posicionable {
	
	private int X;
	private int Y;
	private int hashCode;
	
	public Punto(){
		this.X = 0;
		this.Y = 0;
		this.hashCode = 0;
	}
	
	public Punto(int X, int Y) {
		this.X = X;
		this.Y = Y;
		this.hashCode = this.hashCode();
	}
	
	public Punto(Punto posicion) {
		this.X = posicion.X;
		this.Y = posicion.Y;
		this.hashCode = this.hashCode();
	}

	public int hashCode(){
		this.hashCode = this.X;
		this.hashCode += this.Y;
		return this.hashCode;
	}
	
	public int getPuntoX(){
	
		return this.X;
	}
	
	public int getPuntoY(){
		return this.Y;
	}
	
	/**
	 * Calcula la distancia entre dos puntos y devuelve un int.
	 * @param  
	 * @param  
	 * @return int
	 */
	public double distancia(Punto unPunto){
		
		double distanciaEnX = abs(this.X - unPunto.X);
		double distanciaEnY = abs(this.Y - unPunto.Y);
		
		double unaDistancia = hypot(distanciaEnX,distanciaEnY);
		
		return unaDistancia;
		
	}
	
	/**Devuelve una colecci�n de objetos de clase Punto adyacentes al pasado por parametro.
	 * @return Collection<Punto>
	 */
	public Collection<Punto> getPuntosAdyacentes(){
		
		Collection<Punto> vecinos = new ArrayList<Punto>();
		
		Punto vecinoIzquierdo = this.getVecinoIzquierdo();
				
		Punto vecinoDeArriba = this.getVecinoDeArriba();
				
		Punto vecinoDerecho = this.getVecinoDerecho();
		
		Punto vecinoDeAbajo = this.getVecinoDeAbajo();
		
		vecinos.add(vecinoIzquierdo);
		
		vecinos.add(vecinoDeArriba);
		
		vecinos.add(vecinoDerecho);
		
		vecinos.add(vecinoDeAbajo);
		
		return vecinos;
				
	}
	
	// Aqu� tenemos los cuatro posibles desplazamientos de un punto.
	
	public void moverHaciaIzquierda() {
		this.X--;
		this.hashCode = this.hashCode();
	}
	public void moverHaciaArriba() {
		this.Y--;
		this.hashCode = this.hashCode();
	}

	public void moverHaciaDerecha() {
		this.X++;
		this.hashCode = this.hashCode();
	}
	
	public void moverHaciaAbajo() {
		this.Y++;
		this.hashCode = this.hashCode();
	}
	
	//Obtenemos los puntos vecinos a un punto.
	
	public Punto getVecinoIzquierdo() {
		Punto puntoAux = new Punto (this.X - 1, this.Y);
		return puntoAux;
	}
	
	public Punto getVecinoDeArriba() {
		Punto puntoAux = new Punto (this.X, this.Y - 1);
		return puntoAux;
	}

	public Punto getVecinoDerecho() {
		Punto puntoAux = new Punto (this.X + 1, this.Y);
		return puntoAux;
	}
	
	public Punto getVecinoDeAbajo() {
		Punto puntoAux = new Punto (this.X, this.Y + 1);
		return puntoAux;
	}

	

	/**
	 * Devuelve true o false si los puntos son iguales o no respectivamente.
	 * @param unObjeto
	 * @param otroPunto
	 * @return
	 */
	
	public boolean equals(Object unObjeto){
		
		if (!(unObjeto instanceof Punto))
			return false;
		
		Punto unPunto = (Punto) unObjeto;

		boolean valoresEnXIguales = (this.X == unPunto.X);
	
		boolean valoresEnYIguales = (this.Y == unPunto.Y);
	
		return (valoresEnXIguales && valoresEnYIguales);
	}

	public void nuevaPosicion(Punto posicionOriginal) {
		
		this.X = posicionOriginal.X;
		this.Y = posicionOriginal.Y;
		this.hashCode = this.hashCode();
	}
	
	public LinkedList<Punto> getPosicionesOrdenadas(Collection<Punto> listaDeUbicaciones){
		
		LinkedList<Punto> pilaPosiciones = new LinkedList<Punto>();
		
		while(!listaDeUbicaciones.isEmpty()){
			
			Punto puntoAux;
			
			puntoAux = this.calcularPosicionLejana(listaDeUbicaciones);
			
			pilaPosiciones.addFirst(puntoAux);
			
			listaDeUbicaciones.remove(puntoAux);
		}
		return pilaPosiciones;
	}
		
	private Punto calcularPosicionLejana(Collection<Punto> vecinos){
		
		double mayorDistancia = 0;
		double distanciaAux;
		
		Punto ptoMasLejano = this;
		
		for (Punto punto : vecinos){
			
			distanciaAux = punto.distancia(this);
			
			if (distanciaAux > mayorDistancia){
				
				mayorDistancia = distanciaAux;
				
				ptoMasLejano = punto;
			}
		}
		return ptoMasLejano;
	}

	public Punto getPosicion() {
		Punto posicion = new Punto(this);
		return posicion;
	}

	public int getX() {
		return this.X;
	}

	public int getY() {
		return this.Y;
	}
	

	
	
}
