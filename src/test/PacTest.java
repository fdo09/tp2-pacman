package test;

import java.awt.Point;

import modelo.*;
import fijos.*;

import junit.framework.TestCase;

public class PacTest extends TestCase {

	public void testMover(){
		
		Tablero unTablero = new Tablero(0, 0, null);
		
		Point posicionActual = new Point(1,1);
		
		Point posicionEsperada = new Point(2,1);
		
		Pacman unPacman = new Pacman(unTablero,posicionActual);
		
		unPacman.mover();
		
		
		assertEquals(posicionEsperada, posicionActual);
		
		
	}
	
	
}
