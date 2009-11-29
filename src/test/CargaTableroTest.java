package test;

// import fijos.*;
import fijos.*;
import junit.framework.TestCase;
import java.io.File;





public class CargaTableroTest extends TestCase {
	private Tablero tab;
	
protected void setUp() throws Exception {
		
	   tab = new Tablero(32,32);
	   CargaTablero cargador = new CargaTablero();
	   File file = new File("xml/tablero.xml");
	   cargador.Cargador(tab, file);
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
