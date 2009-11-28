package test;

// import fijos.*;
import fijos.*;
import junit.framework.TestCase;
import java.io.File;





public class CargaTableroTest extends TestCase {
	private Tablero tablero1;
	
protected void setUp() throws Exception {
		
	   tablero1 = new Tablero(30,30);
	   
		
		super.setUp();
		
	}

	public void testTableroCargaManual(){
		Punto punto1 = new Punto(1,1);
		Punto punto2 = new Punto(2,1);
		Punto punto3 = new Punto(3,1);
		Casillero casilla1 = new Semilla(punto1, tablero1);
		Casillero casilla2 = new Pared(punto2, tablero1);
		Casillero casilla3 = new PuntoDePoder(punto3, tablero1);
		tablero1.addCasillero(punto1, casilla1);
		tablero1.addCasillero(punto2, casilla2);
		tablero1.addCasillero(punto3, casilla3);
		assertTrue(tablero1.esTransitable(punto1));
		assertFalse(tablero1.esTransitable(punto2));
		assertTrue(tablero1.esTransitable(punto3));
		Casillero casilla4 = tablero1.getCasillero(punto2);
		assertFalse(casilla4.transitable());
		
		
	}
	
	
	public void testCargarTablero(){
		CargaTablero cargador = new CargaTablero();
		File file = new File("xml/tablero.xml");
		cargador.Cargador(tablero1, file);
		Punto punto = new Punto(1,1);
		Casillero casilla1 = tablero1.getCasillero(punto);
		boolean ver = casilla1.transitable();
		assertTrue(ver);
	
		
		
		}
	
	
}
