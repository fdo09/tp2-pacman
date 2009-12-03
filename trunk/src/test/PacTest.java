package test;

import junit.framework.TestCase;
import modelo.moviles.Pacman;
// import fijos.Jugador;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;

public class PacTest extends TestCase {

	private Tablero unTablero;
	// private Jugador unJugador;
	private Punto posicionActual;
	private Pacman unPacman;

	
	protected void setUp() throws Exception {
	
		unTablero = new Tablero(0, 0);
		
		// unJugador = new Jugador();
		
		posicionActual = new Punto(1,1);
		
		// unPacman = new Pacman(unTablero,unJugador, posicionActual);
		unPacman = new Pacman(unTablero, posicionActual);
	
	super.setUp();
	
	}

	public void testMover(){
		
			
		unPacman.mover();
		
		Punto posicionEsperada = new Punto(2,1);
		
		boolean puntosIguales = (posicionEsperada.equals(unPacman.obtenerPosicion()));
		
		assertTrue(puntosIguales);
						
	}
	
	public void testSerComido(){
		
		unPacman.serComido();
		
		Punto posicionEsperada = new Punto(8,8);
		
		boolean puntosIguales = (posicionEsperada.equals(unPacman.obtenerPosicion()));
		
		assertTrue(puntosIguales);
		
		
		
	}
	
		
}
