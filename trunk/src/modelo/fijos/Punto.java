package modelo.fijos;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;




/**
 * @author Julián D'Ambrosio
 *
 */

public class Punto  {
	
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
		this.hashCode = 0;
	}
	
	public int hashCode(){
		if (this.hashCode == 0) {
			this.hashCode += this.X;
			this.hashCode += this.Y;
		}
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
	
	/**Devuelve una colección de objetos de clase Punto adyacentes al pasado por parametro.
	 * @return Collection<Punto>
	 */
	public Collection<Punto> obtenerPuntosAdyacentes(){
		
		Collection<Punto> vecinos = new ArrayList<Punto>();
		
		Punto vecinoIzquierdo = this.obtenerVecinoIzquierdo();
				
		Punto vecinoDeArriba = this.obtenerVecinoDeArriba();
				
		Punto vecinoDerecho = this.obtenerVecinoDerecho();
		
		Punto vecinoDeAbajo = this.obtenerVecinoDeAbajo();
		
		vecinos.add(vecinoIzquierdo);
		
		vecinos.add(vecinoDeArriba);
		
		vecinos.add(vecinoDerecho);
		
		vecinos.add(vecinoDeAbajo);
		
		return vecinos;
				
	}
	
	// Aquí tenemos los cuatro posibles desplazamientos de un punto.
	
	public void moverHaciaIzquierda() {
		this.X--;
	}
	public void moverHaciaArriba() {
		this.Y++;
	}

	public void moverHaciaDerecha() {
		this.X++;
	}
	
	public void moverHaciaAbajo() {
		this.Y--;
	}
	
	//Obtenemos los puntos vecinos a un punto.
	
	public Punto obtenerVecinoIzquierdo() {
		Punto puntoAux = new Punto (this.X - 1, this.Y);
		return puntoAux;
	}
	
	public Punto obtenerVecinoDeArriba() {
		Punto puntoAux = new Punto (this.X, this.Y + 1);
		return puntoAux;
	}

	public Punto obtenerVecinoDerecho() {
		Punto puntoAux = new Punto (this.X + 1, this.Y);
		return puntoAux;
	}
	
	public Punto obtenerVecinoDeAbajo() {
		Punto puntoAux = new Punto (this.X, this.Y - 1);
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
	}
	
	public LinkedList<Punto> obtenerPosicionesOrdenadas(Collection<Punto> listaDeUbicaciones){
		LinkedList<Punto> pilaPosiciones = new LinkedList<Punto>();
		while(!listaDeUbicaciones.isEmpty()){
			Punto puntoAux;
			puntoAux = this.calcularPosicionLejana(listaDeUbicaciones);
			pilaPosiciones.push(puntoAux);
			listaDeUbicaciones.remove(puntoAux);
		}
		return pilaPosiciones;
	}
		
	private Punto calcularPosicionLejana(Collection<Punto> vecinos){
		double mayorDistancia = 0;
		double distanciaAux;
		Punto ptoMasCercano = this;
		for (Punto punto : vecinos){
			distanciaAux = punto.distancia(this);
			if (distanciaAux > mayorDistancia){
				mayorDistancia = distanciaAux;
				ptoMasCercano = punto;
			}
		}
		return ptoMasCercano;
	}
	

	
	
}
