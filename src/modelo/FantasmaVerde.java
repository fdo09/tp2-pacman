package modelo;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FantasmaVerde extends Fantasma implements Iterable<Point>  {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	private Collection<Point> posicionesAdyacentes;
			
	public FantasmaVerde(Tablero tablero, Point posicion){
		
		super(tablero, posicion);
		this.estado = Estados.ATRAPAR;
		this.posicionesAdyacentes = new ArrayList<Point>();
	}
			
	public void huir() {
		
		this.desplazarse();
		
	}

	public void atrapar() {
		
		this.desplazarse();
		
	}

	private void desplazarse() {
		Collection<Point> posicionesVecinas = this.obtenerPosicionesAdyacentes();
		Point posicionOptima = this.getMovimientoOptimo(posicionesVecinas);
		if(tablero.esValida(posicionOptima)){
			
			this.posicion.setLocation(posicionOptima);
			
		}
		else{
			this.posicionesAdyacentes.remove(posicionOptima);
			this.desplazarse();
		}
	}

	public void regresar() {
		// TODO Auto-generated method stub
		
	}
	
	private double calcularDistanciaAPac (Point unaPosicion){
		
		Point posicionPac = tablero.posicionPac();
		
		double distancia = posicionPac.distance(unaPosicion);
		
		return distancia;
	}
	
	
	
	
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
	
	
	public Iterator<Point> iterator() {
		return this.posicionesAdyacentes.iterator();
	}
	
}
