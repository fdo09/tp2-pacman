package test;

import junit.framework.TestCase;
import fijos.Casillero;
import fijos.Punto;
import fijos.Semilla;
import fijos.Tablero;

public class TableroTest extends TestCase{

	
	public void testTablero(){
		
		
		Tablero unTablero = new Tablero();
		Punto unPunto = new Punto(1,1);
		Punto otroPunto = new Punto(1,1);
		Casillero unCasillero = new Semilla(unPunto, unTablero);
		
		unTablero.addCasillero(unPunto, unCasillero);
		
		boolean transitable = unTablero.esTransitable(otroPunto);
		
		assertTrue(transitable);
		
	}
	
	
	
	
	
}
