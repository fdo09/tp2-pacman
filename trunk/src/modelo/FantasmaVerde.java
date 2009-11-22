package modelo;


import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

public class FantasmaVerde extends Fantasma  {

	private Tablero tablero;
	private Point posicion;
	private Estados estado;
	
			
	public FantasmaVerde(Tablero tablero, Point posicion){
		
		super(tablero, posicion);
		
	}
			
	public void huir() {
		Collection<Point>posicionesAdyacentes = this.obtenerPosicionesAdyacentes();
		this.desplazarse(posicionesAdyacentes);
		
	}

	public void atrapar() {
		Collection<Point>posicionesAdyacentes = this.obtenerPosicionesAdyacentes();
		this.desplazarse(posicionesAdyacentes);
		
	}

	private void desplazarse(Collection<Point> listaDePosiciones) {
		
		Point posicionOptima = this.getMovimientoOptimo(listaDePosiciones);
		if(tablero.esValida(posicionOptima)){
			
			this.posicion.setLocation(posicionOptima);
			
		}
		else{
			listaDePosiciones.remove(posicionOptima);
			this.desplazarse(listaDePosiciones);
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
	
	
	
}
