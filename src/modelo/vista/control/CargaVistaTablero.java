package modelo.vista.control;

import modelo.fijos.*;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class CargaVistaTablero {

	private Punto puntoDimension;
	
	
	public CargaVistaTablero(){
		
	}
	
	public void cargaVista(Tablero tablero, ControladorJuego controlador){
		puntoDimension = new Punto();
		puntoDimension = tablero.getDimension();
		int maxX = puntoDimension.getPuntoX();
		int maxY = puntoDimension.getPuntoY();
		
		for ( int i = 0; i < maxY; i++){
			
			for ( int s = 0; s < maxX; s++){
				Punto nuevo_punto = new Punto(s,i);
				Casillero casillaAEvaluar = tablero.getCasillero(nuevo_punto);
				if (casillaAEvaluar.transitable()){
					
				}else{
					
				}
				
				
			}
			
			
		}
		
		
	}
			

}
