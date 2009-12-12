package modelo.vista.control;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AcercaDe extends Dialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcercaDe(Frame unaVentana, String unString){
		
		super(unaVentana,unString);
		
		this.setVisible(true);
		this.setSize(220,220);
		this.setLocation(250,200);
		this.escribirTexto();
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				//System.exit(0);
			}
		
		});
		
		
	}
	public void escribirTexto(){
		
		
		TextArea area = new TextArea();
	
		area.setBackground(Color.WHITE);
		
				
		String informacionDeCreacion;
		
		informacionDeCreacion = "Nombre del Juego: \n\t AlgoIII - Man \n" +
			
								"\n Autores:\n\t" +
								"Palladoro Federico \n\t" + 
								"Marcelo Rodriguez \n\t" +
								"DAmbrosio Julian \n" + 
								
								"\n Fecha de creacion: \n\t 12/2009";
			
				
		
		
		area.setText(informacionDeCreacion);
		area.setEditable(false);
		
		
		this.add(area);
	
	}
	
}
	


