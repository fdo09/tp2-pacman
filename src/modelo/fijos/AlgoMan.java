package modelo.fijos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;
import modelo.vista.control.EscuchadorDeKeyPress;
import modelo.vista.control.VentanaPrincipal;
import modelo.vista.control.VistaPrincipal;
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
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class AlgoMan {
	
	public static void main(String[] args){
		
		ControladorJuego controlador = new ControladorJuego();
		
		// Pantalla de bienvenida y menus
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
		VistaPrincipal principal = new VistaPrincipal();
		
		controlador.agregarDibujable(principal);
		controlador.comenzarJuego(1);
		
		
		// Carga del juego
		Juego nuevoJuego = Juego.getInstancia();
		Tablero tablero = nuevoJuego.getTablero();
		Jugador jugador = nuevoJuego.getJugador();
		
		
		//Carga de las vistas/controles
		cargarVistas(controlador, tablero);
		
		AdministradorJuego administrador = new AdministradorJuego(controlador);
		controlador.agregarObjetoVivo(administrador);
		
		controlador.setIntervaloSimulacion(100);
		//controlador.comenzarJuego();
		
	}
	
	private static void cargarVistas(ControladorJuego controlador, Tablero tablero){
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
				Punto posicionPantalla = new Punto (x*25, y*25);
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
