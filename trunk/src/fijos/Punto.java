package fijos;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Collection;



/**
 * @author Julián D'Ambrosio
 *
 */
public class Punto  {
	private int X;
	private int Y;
	
	public Punto(int X, int Y) {
		this.X = X;
		this.Y = Y;
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
	public int distancia(Punto unPunto, Punto otroPunto){
		
		int distanciaEnX = abs(unPunto.X - otroPunto.X);
		int distanciaEnY = abs(unPunto.Y - otroPunto.Y);
		
		int unaDistancia = (int)hypot(distanciaEnX,distanciaEnY);
		
		return unaDistancia;
		
	}
	
	/**Devuelve una colección de objetos de clase Punto adyacentes al pasado por parametro.
	 * @return Collection<Punto>
	 */
	public Collection<Punto> obtenerPuntosAdyacentes(Punto unPunto){
		
		Collection<Punto> vecinos = new ArrayList<Punto>();
		
		Punto puntoAuxiliar = unPunto;
		
		Punto vecinoIzquierdo = puntoAuxiliar.obtenerVecinoIzquierdo();
				
		Punto vecinoDeArriba = puntoAuxiliar.obtenerVecinoDeArriba();
		
		Punto vecinoDerecho = puntoAuxiliar.obtenerVecinoDerecho();
		
		Punto vecinoDeAbajo = puntoAuxiliar.obtenerVecinoDeAbajo();
		
		vecinos.add(vecinoIzquierdo);
		
		vecinos.add(vecinoDerecho);
		
		vecinos.add(vecinoDeArriba);
		
		vecinos.add(vecinoDeAbajo);
		
		return vecinos;
				
	}
	
	// Aquí tenemos los cuatro posibles desplazamientos de un punto.
	
	private void moverHaciaIzquierda() {
		this.X--;
	}
	private void moverHaciaArriba() {
		this.Y++;
	}

	private void moverHaciaDerecha() {
		this.X++;
	}
	
	private void moverHaciaAbajo() {
		this.Y--;
	}
	
	//Obtenemos los puntos vecinos a un punto.
	
	private int obtenerVecinoIzquierdo() {
		
		return (this.X) + 1;
	}
	
	private Punto obtenerVecinoDeArriba() {
		this.moverHaciaArriba();
		return this;
	}

	private Punto obtenerVecinoDerecho() {
		this.moverHaciaDerecha();
		return this;
	}
	
	private Punto obtenerVecinoDeAbajo() {
		this.moverHaciaAbajo();
		return this;
	}

	

	/**
	 * Devuelve true o false si los puntos son iguales o no respectivamente.
	 * @param unPunto
	 * @param otroPunto
	 * @return
	 */
	
	public boolean equals(Punto unPunto, Punto otroPunto){
		
		boolean valoresEnXIguales = (unPunto.X == otroPunto.X);
		boolean valoresEnYIguales = (unPunto.Y == otroPunto.Y);
		
		return (valoresEnXIguales & valoresEnYIguales);
	}

	
	
}
