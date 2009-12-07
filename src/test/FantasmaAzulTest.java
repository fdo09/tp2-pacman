package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.Pacman;

public class FantasmaAzulTest extends TestCase {

	private Tablero tab;
	private Fantasma fantasmaAzul;
	
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		CargaTablero cargador = new CargaTablero();
		tab = cargador.cargar("xml/miniTablero.xml");
		
		Punto puntoAzul = new Punto(2,2);
		fantasmaAzul = new FantasmaAzul(tab, puntoAzul);
		tab.addFantasma(fantasmaAzul);
		
		Punto puntoPacman = new Punto(4,2);
		pacman = new Pacman(tab, puntoPacman);
		tab.addPacman(pacman);
		
		super.setUp();
	}
	
	public void testAtrapar(){
		fantasmaAzul.mover();
		
		Punto movimientoEsperado = new Punto(3,2);
		
		assertEquals(movimientoEsperado, fantasmaAzul.getPosicion());
		
	}	
	
	
	public void testHuir(){
		Casillero nuevoPunto;
		Punto nuevo = new Punto(5,2);
		nuevoPunto = tab.getCasillero(nuevo);
		nuevoPunto.accionar();
		assertTrue(fantasmaAzul.esComible());
		
		fantasmaAzul.mover();
		Punto posicionEsperada = new Punto(1,2);
		assertEquals(posicionEsperada, fantasmaAzul.getPosicion());
	}
	
	public void testregresar() {
		
	}
	
	public void testnuevaPosicion(){
		fantasmaAzul.mover();
		
		Punto nuevo = new Punto(3,2);
		Punto prueba = fantasmaAzul.getPosicion();
		
		assertEquals(nuevo, prueba);
	}
}
