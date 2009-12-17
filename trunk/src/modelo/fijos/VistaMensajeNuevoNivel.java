package modelo.fijos;

import java.awt.Component;

import modelo.vista.control.VistaMensaje;

public class VistaMensajeNuevoNivel extends VistaMensaje {

	public VistaMensajeNuevoNivel(Component ventana){
		super(ventana);
	}


	
	protected String getTexto() {
		int nivelSiguiente =  Juego.getInstancia().getNivel() + 1;
		
		String mensaje = "Enhorabuena haz comido todas las semillas... pasas al nivel " +  nivelSiguiente; 
					
		return mensaje;
	}


	protected String getTitulo() {
		return "Mensaje";
	}

}
