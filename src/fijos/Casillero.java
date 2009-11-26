package fijos;
import java.awt.Point;


public abstract class Casillero {
	
	
	private Point ubicacion;
	
	
	public Casillero(){
			
			
	}
	public Casillero(Point unaUbicacion){
		
		this.ubicacion = unaUbicacion;
	}
		
	protected boolean transitable(){
			
		return false;
			
	}

}
