package test;

import java.io.File;

import modelo.fijos.*;
import junit.framework.TestCase;

public class TableroTest extends TestCase {

	
	private Tablero tab;
	
	protected void setUp() throws Exception {
			
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/tablero.xml");
		   super.setUp();
			
		}

	  public void testEsTransitable(){
		  Punto nuevo = new Punto(1,1);
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

