package modelo.vista.control;

import java.awt.Component;

import modelo.fijos.Juego;
import modelo.vista.control.VistaMensaje;

public class VistaJuegoGanado extends VistaMensaje {

	public VistaJuegoGanado(Component ventana){
		super(ventana);
	}


	
	protected String getTexto() {
		String mensaje = "Felicitaciones ha ganado el juego con " 
			+ Juego.getInstancia().getJugador().getPuntos() + " puntos";
		
		return mensaje;
	}


	protected String getTitulo() {
		return "Mensaje";
	}

}
