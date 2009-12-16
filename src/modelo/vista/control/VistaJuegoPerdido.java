package modelo.vista.control;

import javax.swing.JOptionPane;

public class VistaJuegoPerdido {
	
	public VistaJuegoPerdido(){
		String mensaje = this.getMensaje();
		JOptionPane.showMessageDialog(null,mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);

	}

		
	public String getMensaje(){
		
		String mensaje = "---------Game Over---------";
		
		return mensaje;
		
	
	}
	
}
