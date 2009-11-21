package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

public class FantasmaAzul extends Fantasma {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
	public FantasmaAzul(Tablero tablero, Point posicion) {
		super(tablero, posicion);
						
	}
	/*
	 para calcular la menor o mayor distancia se puede armar una lista con las 4 posiciones posibles y luego ordenarla segun su distancia al pac.
	 luego intentar moverse en la menor distancia. Si no se puede (por una pared) tratar de moverse en la segunda menor distancia.... 
	 */

	public void huir() {
		Point posicionPac = tablero.posicionPac();
		double distanciaPac = this.calcularDistancia(posicionPac);
		Collection<Point> adjacentes = this.calcAdjacentes();
	}

	public void atrapar() {
		Point posicionPac = tablero.posicionPac();
		double distanciaPac = this.calcularDistancia(posicionPac);
		Collection<Point> adjacentes = this.calcAdjacentes();
		
	}

	public void regresar() {
		// TODO Auto-generated method stub
		
	}
	
	private double calcularDistancia (Point destino){
		double distanciaX = (this.posicion.getX() - destino.getX());
		double distanciaY = (this.posicion.getY() - destino.getY());
		double distancia = Math.hypot(distanciaX, distanciaY);
		return distancia;
	}
	
	private Collection<Point> calcAdjacentes() {
		ArrayList<Point> listaAdjacentes = new ArrayList<Point>();
		
		Point ptoAuxArriba = new Point();
		ptoAuxArriba.setLocation(this.posicion.getX(), (this.posicion.getY() + 1));
		listaAdjacentes.add(ptoAuxArriba);
		
		Point ptoAuxAbajo = new Point();
		ptoAuxAbajo.setLocation(this.posicion.getX(), (this.posicion.getY() - 1));
		listaAdjacentes.add(ptoAuxAbajo);

		Point ptoAuxDerecha = new Point();
		ptoAuxAbajo.setLocation((this.posicion.getX() + 1), this.posicion.getY());
		listaAdjacentes.add(ptoAuxDerecha);
		
		Point ptoAuxIzquierda = new Point();
		ptoAuxAbajo.setLocation((this.posicion.getX() - 1), this.posicion.getY());
		listaAdjacentes.add(ptoAuxIzquierda);
		
		return listaAdjacentes;
	}
	
}
