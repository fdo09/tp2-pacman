package modelo.vista.control;

import java.awt.Component;

public class VistaRegla extends VistaMensaje{


	public VistaRegla(Component ventana){
		super(ventana);
	}

	
	public String getTexto(){
			
		String reglas = "Reglas\n";
		
		String parrafo1;
		String parrafo2;
		String parrafo3;
		
		parrafo1 = 
				
				"\n --El juego consta de un Pacman y cinco Fantasmas.\n " +
				"\n --Usted tendra tres vidas durante el juego y la unica forma de perder una es siendo atrapado por un Fantasma.\n";
				
		parrafo2=
				"\n --Los Fantasmas intentaran atraparlo salvo que el Pacman coma un Punto de Poder,\n" +
				
				"en ese caso huiran de el.\n" +
				
				"\n --Usted posee los controles sobre el Pacman," +
				
				"podra moverlo en las direcciones izquierda, arriba, deracha y abajo,\n " +
				
				"y deberia comer todas las semillas " +
				
				"que aparescan en pantalla para ganar el juego y pasar de nivel. \n" +
				
				"\n --Por cada Semilla comida sumara puntos. Ademas se encontrara con Puntos de Poder los cuales \n" +
				
				" cambiara el estado de los fantasmas dando la posibilidad de comerlos. \n " +
				
				" \n --Ellos tambien les dara mas puntos, pero usted tambien debe saber que hay un Fantasma Inmune \n" +
				"el cual nunca podra ser comido,por lo que tendrá que huir de el.\n";
				
		parrafo3=
			 	"\n --Los Fantasma al ser comidos vuelven a sus casas e intentaran nuevamente atraparlo.\n" +
			 	"\n --El pacman tambien podra sumar mas puntos comiendo los premios que apareceran en pantalla.\n" +
			 	"\n --Estos pueden aparecer en cualquier momento del juego.\n";
		
		
	   
		return reglas += parrafo1 + parrafo2 + parrafo3;
	
	}

	protected String getTitulo() {
		return "Reglas";
	}
	

	
}
