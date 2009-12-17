package modelo.vista.control;

import java.awt.Color;

import modelo.fijos.Casa;
import modelo.fijos.Casillero;
import modelo.fijos.Pared;
import modelo.fijos.Punto;
import modelo.fijos.PuntoDePoder;
import modelo.fijos.Semilla;
import modelo.fijos.Tablero;
import modelo.vista.fijos.VistaBarraDeDatos;
import modelo.vista.fijos.VistaCasillero;
import modelo.vista.fijos.VistaCasilleroCasa;
import modelo.vista.fijos.VistaCasilleroPared;
import modelo.vista.fijos.VistaCasilleroPuntoDePoder;
import modelo.vista.fijos.VistaCasilleroSemilla;
import modelo.vista.fijos.VistaPuntoDePoder;
import modelo.vista.fijos.VistaPuntos;
import modelo.vista.fijos.VistaSemilla;
import modelo.vista.fijos.VistaVidas;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class CargaVistaTablero {
	
	
	public CargaVistaTablero(ControladorJuego controlador, Tablero tablero){

	}
	public static void cargaVistas(ControladorJuego controlador, Tablero tablero){
		generarVistaDeCasilleros(controlador, tablero);
		generarVistaDeDatos(controlador, tablero);
	}
	
	
	private static void generarVistaDeDatos(ControladorJuego controlador,
			Tablero tablero) {
		
		VistaBarraDeDatos vDatos = new VistaBarraDeDatos();
		controlador.agregarDibujable(vDatos);
		
		VistaPuntos vPuntos = new VistaPuntos();
		controlador.agregarDibujable(vPuntos);
		
		VistaVidas vVidas = new VistaVidas();
		controlador.agregarDibujable(vVidas);
		
	}

		
	private static void generarVistaDeCasilleros(ControladorJuego controlador, Tablero tablero) {
		Punto dimension = tablero.getDimension();
		for ( int x = 0; x < dimension.getPuntoX(); x++ ){
			
			for (int y = 0; y < dimension.getPuntoY(); y++ ){
				
				Punto posicionCasillero = new Punto (x,y);
				Casillero unCasillero = tablero.getCasillero(posicionCasillero);
				Punto posicionPantalla = new Punto (unCasillero.getX(), unCasillero.getY());
				Casillero casilleroActual = tablero.getCasillero(posicionCasillero);
				
				
				if (casilleroActual instanceof Semilla){
					
					VistaCasilleroSemilla vCasilleroSemilla = new VistaCasilleroSemilla();
					serVisible(controlador, posicionPantalla, vCasilleroSemilla);
					
					VistaSemilla vSemilla = new VistaSemilla(casilleroActual);
					vSemilla.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vSemilla);
				}
				
				else if (casilleroActual instanceof Pared){
					
					VistaCasilleroPared vCasilleroPared = new VistaCasilleroPared();
					serVisible(controlador, posicionPantalla, vCasilleroPared);
				}
				
				else if (casilleroActual instanceof Casa){
					
					VistaCasilleroCasa vCasilleroCasa = new VistaCasilleroCasa();
					serVisible(controlador, posicionPantalla, vCasilleroCasa);
				}
				
				else if (casilleroActual instanceof PuntoDePoder){
					VistaCasilleroPuntoDePoder vCasilleroPuntoDePoder = new VistaCasilleroPuntoDePoder();
					serVisible(controlador, posicionPantalla, vCasilleroPuntoDePoder);
					
					VistaPuntoDePoder vistaPtoPoder = new VistaPuntoDePoder(casilleroActual);
					vistaPtoPoder.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vistaPtoPoder);
				}
			}
		}
		
	}
	
	private static void serVisible(ControladorJuego controlador,
			Punto casillero, VistaCasillero vista) {
		vista.setPosicionable(casillero);
		controlador.agregarDibujable(vista);
	}
			

}
