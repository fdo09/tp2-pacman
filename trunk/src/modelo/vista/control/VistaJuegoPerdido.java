package modelo.vista.control;

import java.awt.Component;


public class VistaJuegoPerdido extends VistaMensaje{
	
	public VistaJuegoPerdido(Component ventana){
		super(ventana);
	}


	
	protected String getTexto() {
		String mensaje = "---------Game Over---------";
		
		return mensaje;
	}


	protected String getTitulo() {
		return "Mensaje";
	}
	
}
