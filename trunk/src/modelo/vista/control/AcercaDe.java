package modelo.vista.control;

import java.awt.Component;

public class AcercaDe extends Mensaje{

	
	public AcercaDe(Component ventana){
		super(ventana);
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
	@Override
	protected String getTitulo() {
		return "Acerca De";
	}
	
}
	


