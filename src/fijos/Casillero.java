package fijos;
import java.awt.Point;


public abstract class Casillero {
	
	
	private Point ubicacion;
	
	
	public Casillero(){
			
			
	}
	public Casillero(Point unaUbicacion){
		
		this.ubicacion = unaUbicacion;
	}
		
	protected abstract boolean transitable();
}
