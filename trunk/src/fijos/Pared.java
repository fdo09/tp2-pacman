package fijos;

public class Pared extends Casillero {

	
	public Pared(Punto unaUbicacion){
		super(unaUbicacion);
			
	}
	
	public boolean transitable(){
		
		return false;
	}
	
}
