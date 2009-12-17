package modelo.vista.control;

import java.awt.Component;

import javax.swing.JOptionPane;

public abstract class VistaMensaje {
	
	public VistaMensaje (Component ventana){
		
		JOptionPane.showMessageDialog(ventana, this.getTexto(), this.getTitulo(), JOptionPane.INFORMATION_MESSAGE);
	}

	protected abstract String getTitulo();

	protected abstract String getTexto();
	
	

}
