package fijos;
import java.awt.Point;


public abstract class Casillero {
	
	
	private Punto ubicacion;
	
	
	public Casillero(){
			
			
	}
	public Casillero(Punto unaUbicacion){
		
		this.ubicacion = unaUbicacion;
	}
		
	public abstract boolean transitable();
	
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
}
