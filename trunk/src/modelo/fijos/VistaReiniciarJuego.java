package modelo.fijos;

import java.awt.Component;

import javax.swing.JOptionPane;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

import modelo.vista.control.VentanaPrincipal;

public class VistaReiniciarJuego{
	
	public VistaReiniciarJuego(VentanaPrincipal ventana, ControladorJuego controlador){
		
		String mensaje = "Desea iniciar un juego nuevo. Elija NO para salir del juego";
		int eleccion = JOptionPane.showConfirmDialog
			(ventana, mensaje, "Reiniciar Juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		// NO = 1 || SI = 0
		if (eleccion == 1){
			ventana.cerrarJuego();
		}
		else{
			Juego.getInstancia().reiniciarJuego();
			controlador.comenzarJuego();
		}
	}

}
