package modelo;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import fijos.*;

public class FantasmaVerde extends Fantasma  {

	private Tablero tablero;
	private Punto posicion;
	private Estados estado;
	
			
	public FantasmaVerde(Tablero tablero, Point posicion){
		
		super(tablero, posicion);
		
	}
		
	
	private void calcularMovimiento(ArrayList<Point> posicionesAdyacentes) {
		// TODO Auto-generated method stub
		
	}


	private void ordenarPosicionLejana(Collection<Point> posicionesAdyacentes) {
		// TODO Un metodo que ordene la lista segun que posicion es la mas lejana al pac
	}

	
	private void ordenarPosicionCercana(Collection<Point> posicionesAdyacentes) {
		// TODO Un metodo que ordene la lista segun que posicion es la mas cercana al pac
		
	}

	
	private double calcularDistanciaAPac (Point unaPosicion){
		
		Punto posicionPac = tablero.posicionPac();
		
		double distancia = posicionPac.distance(unaPosicion);
		
		return distancia;
	}

	
	Punto calcularAtrapada(ArrayList<Point> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}


	Punto calcularHuida(ArrayList<Point> adjacentesValidos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* Por el momento este codigo no sirve
	private void desplazarse(Collection<Point> listaDePosiciones) {
		
		Point posicionOptima = this.getMovimientoOptimo(listaDePosiciones);
		if(tablero.esValida(posicionOptima)){
			
			this.posicion.setLocation(posicionOptima);
			
		}
		else{
			listaDePosiciones.remove(posicionOptima);
			this.desplazarse(listaDePosiciones);
		}
		
		
		
		
		while (!listaDePosiciones.isEmpty()){
			Point posicionOptima = this.getMovimientoOptimo(listaDePosiciones);
			if(tablero.esValida(posicionOptima)){
				
				this.posicion.setLocation(posicionOptima);
				return;
				
			}
			else{
				listaDePosiciones.remove(posicionOptima);
				this.desplazarse(listaDePosiciones);
			}
		}
		
	}
	*/
	
	/*
	 * El metodo getMovimientoOptimo podria ir en clase Fantasma, ya que todos tendrían
	 * que recorrer la lista de vecinos y ver donde moverse,
	 * lo que tendríamos que hacer a mi gusto es un metodo deambular como habiamos dicho
	 * entonces de esa manera, al comienzo todos se van a encontrar en posiciones diferentes,
	 * y a la hora de atrapar van a ir por el camino mas corto, pero nadie va a ir por el mismo
	 * lugar que otro ya que parten de lugares diferentes, lo mismo a la hora de escapar.
	 * 
	 */
	
	/*Por el momento este codigo no sirve
	public Point getMovimientoOptimo(Collection<Point> listaDePosiciones){
		
				
		Iterator<Point> iteradorDePosiciones = listaDePosiciones.iterator();
		
		double distanciaMinima = 2000;//Aca debemos poner un numero muy grande.
		
		double distanciaMaxima = 0;
		
		Point puntoDeDistanciaMinima = new Point();
		
		while(iteradorDePosiciones.hasNext()){
			
			Point unaPosicion = iteradorDePosiciones.next();
			
			double distancia = (this.calcularDistanciaAPac(unaPosicion));
			
			if(this.estado.name() == "ATRAPAR"){//Verificar que this.estado.name() devuelva el estado correcto.
				if(distancia <= distanciaMinima){
					
					puntoDeDistanciaMinima = unaPosicion;
								
				}
			}
			else{
				if(distancia >= distanciaMaxima){
					
					puntoDeDistanciaMinima = unaPosicion;
								
				}
				
			}
			
		}
		return puntoDeDistanciaMinima;
		
	}
	*/
	
	
}
