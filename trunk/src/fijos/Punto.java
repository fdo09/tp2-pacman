package fijos;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;




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
	public int distancia(Punto unPunto){
		
		int distanciaEnX = abs(this.X - unPunto.X);
		int distanciaEnY = abs(this.Y - unPunto.Y);
		
		int unaDistancia = (int)hypot(distanciaEnX,distanciaEnY);
		
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
		System.out.println("#######EQUALS#########");
		boolean valoresEnXIguales = (this.X == unPunto.X);
		System.out.println(valoresEnXIguales);
		boolean valoresEnYIguales = (this.Y == unPunto.Y);
		System.out.println(valoresEnYIguales);
		return (valoresEnXIguales && valoresEnYIguales);
	}

	public void nuevaPosicion(Punto posicionOriginal) {
		
		this.X = posicionOriginal.X;
		this.Y = posicionOriginal.Y;
	}

	
	
}
