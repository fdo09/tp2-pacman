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
import modelo.vista.control.CargaVistaTablero;
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
		controlador.detenerJuego();
		
		
		// Carga del juego
		Juego nuevoJuego = Juego.getInstancia();
		Tablero tablero = nuevoJuego.getTablero();
		Jugador jugador = nuevoJuego.getJugador();
		
		
		//Carga de las vistas/controles
		CargaVistaTablero.cargaVistas(controlador, tablero);
		
		AdministradorJuego administrador = new AdministradorJuego(controlador);
		controlador.agregarObjetoVivo(administrador);
		
		controlador.setIntervaloSimulacion(250);
		//controlador.comenzarJuego();
		
	}
	
	


}
