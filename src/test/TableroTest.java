package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Semilla;
import modelo.fijos.Tablero;

public class TableroTest extends TestCase {

	
	private Tablero tab;
	
	protected void setUp() throws Exception {
			
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/miniTablero.xml");
		   super.setUp();
			
		}

	  public void testEsTransitable(){
		  Punto nuevo = new Punto(2,2);
		  assertTrue(tab.esTransitable(nuevo));
	  }
	  
	  public void testEstaVacio(){
		  assertFalse(tab.estaVacio());
	  }
	  
	  public void testAddCasillero(){
		  Punto nuevo = new Punto(31,31);
		  Casillero casilla1 = new Semilla(nuevo,tab);
		  tab.addCasillero(nuevo, casilla1);
		  assertTrue(tab.esTransitable(nuevo));
	  }
	
	
	
	
}

