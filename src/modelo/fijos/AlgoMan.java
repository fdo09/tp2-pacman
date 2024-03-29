package modelo.fijos;

import modelo.moviles.Pacman;
import modelo.vista.control.CargaVistaPersonajes;
import modelo.vista.control.CargaVistaTablero;
import modelo.vista.control.EscuchadorDeKeyPress;
import modelo.vista.control.VentanaPrincipal;
import modelo.vista.control.VistaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

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
		
		
		
		//Carga de las vistas/controles
		
		Pacman pacman = tablero.getPacman();
		controlador.agregarKeyPressObservador(new EscuchadorDeKeyPress(pacman));
		
		CargaVistaTablero.cargaVistas(controlador, tablero);
		CargaVistaPersonajes.cargaVistas(controlador, tablero);
		
		
		AdministradorJuego administrador = new AdministradorJuego(controlador, ventana);
		controlador.agregarObjetoVivo(administrador);
		
		controlador.setIntervaloSimulacion(250);
		
		
	}
	
	


}
