package modelo.vista.control;

import java.util.ArrayList;

import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;
import modelo.vista.moviles.VistaFantasmaAmarillo;
import modelo.vista.moviles.VistaFantasmaAzul;
import modelo.vista.moviles.VistaFantasmaInmune;
import modelo.vista.moviles.VistaFantasmaNaranja;
import modelo.vista.moviles.VistaFantasmaRojo;
import modelo.vista.moviles.VistaPacman;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class CargaVistaPersonajes {

	public static void cargaVistas(ControladorJuego controlador, Tablero tablero){
		generarVistaPacman(controlador, tablero);
		generarVistaFantasmas(controlador, tablero);
		
	}

	private static void generarVistaFantasmas(ControladorJuego controlador,
			Tablero tablero) {
		ArrayList<Fantasma> fantasmas = tablero.getFantasmas();
		for(Fantasma f : fantasmas){
			if(f instanceof FantasmaRojo){
				VistaFantasmaRojo vistaRojo = new VistaFantasmaRojo(f);
				vistaRojo.setPosicionable(f);
				controlador.agregarDibujable(vistaRojo);
			}
			else if(f instanceof FantasmaAmarillo){
				VistaFantasmaAmarillo vistaAmarillo = new VistaFantasmaAmarillo(f);
			    vistaAmarillo.setPosicionable(f);
			    controlador.agregarDibujable(vistaAmarillo);
			}
			else if(f instanceof FantasmaInmune){
				VistaFantasmaInmune vistaInmune = new VistaFantasmaInmune(f);
			    vistaInmune.setPosicionable(f);
			    controlador.agregarDibujable(vistaInmune);
			}
			else if(f instanceof FantasmaNaranja){
				VistaFantasmaNaranja vistaNaranja = new VistaFantasmaNaranja(f);
				vistaNaranja.setPosicionable(f);
				controlador.agregarDibujable(vistaNaranja);
			}
			else if(f instanceof FantasmaAzul){
				VistaFantasmaAzul vistaAzul = new VistaFantasmaAzul(f);
				vistaAzul.setPosicionable(f);
				controlador.agregarDibujable(vistaAzul);
			}
			controlador.agregarObjetoVivo(f);
		
		}
		
	}



	private static void generarVistaPacman(ControladorJuego controlador,
			Tablero tablero) {
		
		Pacman pacman = tablero.getPacman();
		VistaPacman vistaPacman = new VistaPacman(pacman);
		vistaPacman.setPosicionable(pacman);;
		
		controlador.agregarObjetoVivo(pacman);
		controlador.agregarDibujable(vistaPacman);
		
	}
}
