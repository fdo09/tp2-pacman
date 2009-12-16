package modelo.vista.control;

import modelo.fijos.Punto;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class VistaMensaje extends TextoEstatico{
	
	public VistaMensaje(String mensaje){
		super(mensaje);
		setPosicionable(new Punto (10*25, 26*25));
	}
	

}
