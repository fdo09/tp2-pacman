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
	public int distancia(Punto unPunto){
		
		int distanciaEnX = abs(this.X - unPunto.X);
		int distanciaEnY = abs(this.Y - unPunto.Y);
		
		int unaDistancia = (int)hypot(distanciaEnX,distanciaEnY);
		
		return unaDistancia;
		
	}
	
	/**Devuelve una colección de objetos de clase Punto adyacentes al pasado por parametro.
	 * @return Collection<Punto>
	 */
	public Collection<Punto> obtenerPuntosAdyacentes(Punto unPunto){
		
		Collection<Punto> vecinos = new ArrayList<Punto>();
		
		Punto vecinoIzquierdo = unPunto.obtenerVecinoIzquierdo();
				
		Punto vecinoDeArriba = unPunto.obtenerVecinoDeArriba();
		
		Punto vecinoDerecho = unPunto.obtenerVecinoDerecho();
		
		Punto vecinoDeAbajo = unPunto.obtenerVecinoDeAbajo();
		
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
	
	private Punto obtenerVecinoIzquierdo() {
		Punto puntoAux = new Punto (this.X - 1, this.Y);
		return puntoAux;
	}
	
	private Punto obtenerVecinoDeArriba() {
		Punto puntoAux = new Punto (this.X, this.Y + 1);
		return puntoAux;
	}

	private Punto obtenerVecinoDerecho() {
		Punto puntoAux = new Punto (this.X + 1, this.Y);
		return puntoAux;
	}
	
	private Punto obtenerVecinoDeAbajo() {
		Punto puntoAux = new Punto (this.X, this.Y - 1);
		return puntoAux;
	}

	

	/**
	 * Devuelve true o false si los puntos son iguales o no respectivamente.
	 * @param unPunto
	 * @param otroPunto
	 * @return
	 */
	
	public boolean equals(Punto unPunto){
		
		boolean valoresEnXIguales = (this.X == unPunto.X);
		boolean valoresEnYIguales = (this.Y == unPunto.Y);
		
		return (valoresEnXIguales & valoresEnYIguales);
	}

	
	
}
