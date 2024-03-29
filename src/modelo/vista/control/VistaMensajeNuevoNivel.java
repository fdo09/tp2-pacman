package modelo.vista.control;

import java.awt.Component;

import modelo.fijos.Juego;
import modelo.vista.control.VistaMensaje;

public class VistaMensajeNuevoNivel extends VistaMensaje {

	public VistaMensajeNuevoNivel(Component ventana){
		super(ventana);
	}


	
	protected String getTexto() {
		int nivelSiguiente =  Juego.getInstancia().getNivel() ;
		
		String mensaje = "Enhorabuena haz comido todas las semillas... pasas al nivel " +  nivelSiguiente; 
					
		return mensaje;
	}


	protected String getTitulo() {
		return "Mensaje";
	}

}
