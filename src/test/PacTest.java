package test;

import junit.framework.TestCase;
import modelo.Pacman;
import fijos.Punto;
import fijos.Tablero;

public class PacTest extends TestCase {

	public void testMoverIzquierda(){
		
		Tablero unTablero = new Tablero(0, 0, null);
		
		Punto posicionActual = new Punto(1,1);
		
		Pacman unPacman = new Pacman(unTablero,posicionActual);
				
		unPacman.mover();
		
		Punto posicionEsperada = new Punto(1,1);
		
		
		assertEquals(posicionEsperada, posicionActual);
		
		
	}
	
	
}
