package modelo.vista.control;

import java.awt.Component;

import javax.swing.JOptionPane;

public abstract class Mensaje {
	
	public Mensaje (Component ventana){
		
		JOptionPane.showMessageDialog(ventana, this.getTexto(), this.getTitulo(), JOptionPane.INFORMATION_MESSAGE);
	}

	protected abstract String getTitulo();

	protected abstract String getTexto();
	
	

}
