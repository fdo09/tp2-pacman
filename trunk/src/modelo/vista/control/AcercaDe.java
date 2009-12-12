package modelo.vista.control;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class AcercaDe {

	
	public AcercaDe(){
	
		String informacion = this.getTexto();
		JOptionPane.showMessageDialog(null,informacion, "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
	}
	public String getTexto(){
		
				
		String informacionDeCreacion;
		
		informacionDeCreacion = "NOMBRE DEL JUEGO: \n" +
								"\nAlgoIII - Man\n" +
			
								"\nAUTORES:\n"+
								"\nPalladoro Federico\n" + 
								"Marcelo Rodriguez \n" +
								"DAmbrosio Julian \n" + 
								
								"\nFECHA DE CREACION: \n" +
								"		\n12/2009";
			
				
		
		return informacionDeCreacion;
	}
	
}
	


