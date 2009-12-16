package modelo.vista.control;

import java.awt.Color;
import java.util.ArrayList;

import modelo.fijos.Casa;
import modelo.fijos.Casillero;
import modelo.fijos.Pared;
import modelo.fijos.Punto;
import modelo.fijos.PuntoDePoder;
import modelo.fijos.Semilla;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;
import modelo.vista.fijos.VistaBarraDeDatos;
import modelo.vista.fijos.VistaCasillero;
import modelo.vista.fijos.VistaPuntoDePoder;
import modelo.vista.fijos.VistaPuntos;
import modelo.vista.fijos.VistaSemilla;
import modelo.vista.fijos.VistaVidas;
import modelo.vista.moviles.VistaFantasmaAmarillo;
import modelo.vista.moviles.VistaFantasmaAzul;
import modelo.vista.moviles.VistaFantasmaInmune;
import modelo.vista.moviles.VistaFantasmaNaranja;
import modelo.vista.moviles.VistaFantasmaRojo;
import modelo.vista.moviles.VistaPacman;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class CargaVistaTablero {
	
	
	public CargaVistaTablero(ControladorJuego controlador, Tablero tablero){

	}
	public static void cargaVistas(ControladorJuego controlador, Tablero tablero){
		Pacman pacman = tablero.getPacman();
		controlador.agregarKeyPressObservador(new EscuchadorDeKeyPress(pacman));
		generarVistaDeCasilleros(controlador, tablero);
		generarVistaDePersonajes(controlador, tablero);
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

	private static void generarVistaDePersonajes(ControladorJuego controlador,
			Tablero tablero) {
		ArrayList<Fantasma> fantasmas = tablero.getFantasmas();
		for(Fantasma f : fantasmas){
			if(f.getClass().equals(FantasmaRojo.class)){
				VistaFantasmaRojo vistaRojo = new VistaFantasmaRojo(f);
				vistaRojo.setPosicionable(f);
				controlador.agregarDibujable(vistaRojo);
			}
			else if(f.getClass().equals(FantasmaAmarillo.class)){
				VistaFantasmaAmarillo vistaAmarillo = new VistaFantasmaAmarillo(f);
			    vistaAmarillo.setPosicionable(f);
			    controlador.agregarDibujable(vistaAmarillo);
			}
			else if(f.getClass().equals(FantasmaInmune.class)){
				VistaFantasmaInmune vistaInmune = new VistaFantasmaInmune(f);
			    vistaInmune.setPosicionable(f);
			    controlador.agregarDibujable(vistaInmune);
			}
			else if(f.getClass().equals(FantasmaNaranja.class)){
				VistaFantasmaNaranja vistaNaranja = new VistaFantasmaNaranja(f);
				vistaNaranja.setPosicionable(f);
				controlador.agregarDibujable(vistaNaranja);
			}
			else if(f.getClass().equals(FantasmaAzul.class)){
				VistaFantasmaAzul vistaAzul = new VistaFantasmaAzul(f);
				vistaAzul.setPosicionable(f);
				controlador.agregarDibujable(vistaAzul);
			}
			controlador.agregarObjetoVivo(f);
		
		}
		
		Pacman pacman = tablero.getPacman();
		VistaPacman vistaPacman = new VistaPacman(pacman);
		vistaPacman.setPosicionable(pacman);;
		
		controlador.agregarObjetoVivo(pacman);
		controlador.agregarDibujable(vistaPacman);
		
	}
	
	private static void generarVistaDeCasilleros(ControladorJuego controlador, Tablero tablero) {
		Punto dimension = tablero.getDimension();
		for ( int x = 0; x < dimension.getPuntoX(); x++ ){
			
			for (int y = 0; y < dimension.getPuntoY(); y++ ){
				
				Punto posicionCasillero = new Punto (x,y);
				Casillero unCasillero = tablero.getCasillero(posicionCasillero);
				Punto posicionPantalla = new Punto (unCasillero.getX(), unCasillero.getY());
				Casillero casilleroActual = tablero.getCasillero(posicionCasillero);
				VistaCasillero vistaCasillero = new VistaCasillero();
				
				if (casilleroActual.getClass().equals(Semilla.class)){
					vistaCasillero.setColor(Color.BLACK);
					serVisible(controlador, posicionPantalla, vistaCasillero);
					
					VistaSemilla vistaSemilla = new VistaSemilla(casilleroActual);
					vistaSemilla.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vistaSemilla);
				}
				
				else if (casilleroActual.getClass().equals(Pared.class)){
					vistaCasillero.setColor(Color.BLUE);
					serVisible(controlador, posicionPantalla, vistaCasillero);
				}
				
				else if (casilleroActual.getClass().equals(Casa.class)){
					vistaCasillero.setColor(Color.GREEN);
					serVisible(controlador, posicionPantalla, vistaCasillero);
				}
				
				else if (casilleroActual.getClass().equals(PuntoDePoder.class)){
					vistaCasillero.setColor(Color.BLACK);
					serVisible(controlador, posicionPantalla, vistaCasillero);
					
					VistaPuntoDePoder vistaPtoPoder = new VistaPuntoDePoder(casilleroActual);
					vistaPtoPoder.setPosicionable(posicionPantalla);
					controlador.agregarDibujable(vistaPtoPoder);
				}
			}
		}
		
	}
	
	private static void serVisible(ControladorJuego controlador,
			Punto cas$i, VistaCasillero vis$i) {
		vis$i.setPosicionable(cas$i);
		controlador.agregarDibujable(vis$i);
	}
			

}
