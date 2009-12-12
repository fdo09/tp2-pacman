package modelo.vista.control;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Regla extends Dialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Regla(Frame unaVentana, String titulo){
		super(unaVentana, titulo);
		
		setVisible(true);
		this.setSize(700,400);
		this.setLocation(200,100);
		this.escribirTexto();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				
			}
		});
		
	}
	public void escribirTexto(){
		
	
		TextArea area = new TextArea();
	
			
		area.setBackground(Color.WHITE);
		
		String reglas = "Reglas\n";
		
		
		String parrafo1;
		String parrafo2;
		String parrafo3;
		
		parrafo1 = 
				
				"\n --El juego consta de un Pacman y cinco Fantasmas.\n " +
				"\n --Usted tendrá tres vidas durante el juego y la única forma de perder una es siendo atrapado por un Fantasma.\n";
				
		parrafo2=
				"\n --Los Fantasmas intentarán atraparlo salvo que el Pacman coma un Punto de Poder,\n" +
				
				"en ese caso huirán de él.\n" +
				
				"\n --Usted posee los controles sobre el Pacman," +
				
				"podrá moverlo en las direcciones izquierda, arriba, deracha y abajo,\n " +
				
				"y deberá comer todas las semillas" +
				
				"que aparescan en pantalla para ganar el juego y pasar de nivel. \n" +
				
				"\n --Por cada Semilla comida sumará puntos. Además se encontrará con Puntos de Poder los cuales \n" +
				
				"le permitirán comer a los Fantasmas " +
				
				"que también les dará más puntos,pero usted también debe saber \n" +
				"que hay un Fantasma Inmune el cual nunca podrá ser comido,por lo que tendrá que huir de él.\n";
				
		parrafo3=
			 	"\n --Los Fantasma al ser comidos vuelven a sus casas e intentarán nuevamente atraparlo.\n" +
			 	"\n --El pacman también podrá sumar mas puntos comiendo los premios que aparecerán en pantalla.\n" +
			 	"\n --Estos pueden aparecer en cualquier momento del juego.\n";
		
		
	   
		reglas += parrafo1 + parrafo2 + parrafo3;
		
		area.setText(reglas);
		area.setEditable(false);
		
		
		this.add(area);
	
	}
	

	
}
