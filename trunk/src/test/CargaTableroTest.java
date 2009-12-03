package test;

// import fijos.*;
import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;





public class CargaTableroTest extends TestCase {
	private Tablero tab;
	
protected void setUp() throws Exception {
		
	   CargaTablero cargador = new CargaTablero();
	   tab = cargador.cargar("xml/tablero.xml");
	   super.setUp();
		
	}

		
	
	public void testCargarTablero(){
		assertFalse(tab.estaVacio());		
		}
	
	public void testPruebaDeCarga(){
		Punto nuevo = new Punto(5,5);
		Casillero casillaver = tab.getCasillero(nuevo);
		assertTrue(casillaver.transitable());
	}
	
	
	
}
