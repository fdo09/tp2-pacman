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
	/*
	 * FEDE TENE EN CUENTA QUE LA CLASE POINT YA TE PROVEE DE UN METODO QUE CALCULA LA DISTANCIA.
	 * O LA RAIZ CUADRADA DE LA DISTANCIA.
	 * Point unaPosicion = new Point();
	 * Point otraPosicion = new Point();
	 * double distancia = unaPosicion.distance(otraPosicion);
	 * double raizDeLaDistancia = unaPosicion.distanceSq(otraPosicion);
	 * 
	 * Te devuelve un double
	 * 
	 */
	private double calcularDistancia (Point destino){
		double distanciaX = (this.posicion.getX() - destino.getX());
		double distanciaY = (this.posicion.getY() - destino.getY());
		double distancia = Math.hypot(distanciaX, distanciaY);
		return distancia;
	}
	
	
	/*
	 * FEDE TENE EN CUENTA QUE LA CLASE POINT TAMBIEN VIENE CON UN METODO TRANSLATE.
	 * Point unaPosicion = new Point();
	 * 
	 * unaPosicion.translate(int arg1,int arg2); LO PODES USAR CON NUMEROS NEGATIVOS.
	 * 
	 * 
	 * 
	 */
	private Collection<Point> calcAdjacentes() {
		ArrayList<Point> listaAdjacentes = new ArrayList<Point>();
		
		Point ptoAuxArriba = new Point();
		ptoAuxArriba.translate(0,1);
		listaAdjacentes.add(ptoAuxArriba);
		
		Point ptoAuxAbajo = new Point();
		ptoAuxAbajo.translate(0,-1);
		listaAdjacentes.add(ptoAuxAbajo);

		Point ptoAuxDerecha = new Point();
		ptoAuxAbajo.translate(1,0);
		listaAdjacentes.add(ptoAuxDerecha);
		
		Point ptoAuxIzquierda = new Point();
		ptoAuxAbajo.translate(-1,0);
		listaAdjacentes.add(ptoAuxIzquierda);
		
		return listaAdjacentes;
	}
	
}
