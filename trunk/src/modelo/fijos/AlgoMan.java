package modelo.fijos;

import modelo.vista.control.CargaVistaTablero;
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
		Jugador jugador = nuevoJuego.getJugador();
		
		
		//Carga de las vistas/controles
		CargaVistaTablero.cargaVistas(controlador, tablero);
		
		AdministradorJuego administrador = new AdministradorJuego(controlador);
		controlador.agregarObjetoVivo(administrador);
		
		controlador.setIntervaloSimulacion(250);
		//controlador.comenzarJuego();
		
	}
	
	


}
