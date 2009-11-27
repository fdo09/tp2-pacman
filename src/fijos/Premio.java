package fijos;

import java.awt.Point;

public abstract class Premio extends Casillero {

	public Premio() {
		// TODO Auto-generated constructor stub
	}

	public Premio(Punto unaUbicacion) {
		super(unaUbicacion);
		// TODO Auto-generated constructor stub
	}

	public boolean transitable(){
		
		return true;
	}
	
	protected void darPremio(){
		
		//Dar un premio.(Ver que tipo de premio dar si vida o puntaje.)
		
	}

}
