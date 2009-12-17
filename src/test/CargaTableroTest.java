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
	   tab = cargador.cargar("xml/miniTablero.xml");
	   super.setUp();
		
	}

	
	public void testPruebaDeCarga(){
		Punto nuevo = new Punto(1,2);
		Casillero casillaver = tab.getCasillero(nuevo);
		assertTrue(casillaver.transitable());
	}
	
	public void testPruebaDeCargaCompleta(){
		for(int x = 0; x <= 7; x++){
			for(int y = 0; y <= 9; y++){
				assertTrue(tab.getCasillero(new Punto(x, y)) != null);
			}
		}
	}
	
	
	
}
