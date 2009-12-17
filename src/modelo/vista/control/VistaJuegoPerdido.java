package modelo.vista.control;

import java.awt.Component;

import javax.swing.JOptionPane;


public class VistaJuegoPerdido extends Mensaje{
	
	public VistaJuegoPerdido(Component ventana){
		super(ventana);
	}


	@Override
	protected String getTexto() {
		String mensaje = "---------Game Over---------";
		
		return mensaje;
	}


	@Override
	protected String getTitulo() {
		return "Mensaje";
	}
	
}
