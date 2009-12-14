package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.Pacman;

public class FantasmaInmuneTest extends TestCase {

	private Tablero tab;
	private Fantasma fantasmaAmarillo;
	private Fantasma fantasmaInmune;
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/miniTablero.xml");
		  
		   Punto puntoAmarillo = new Punto(5,5);
		   Punto puntoInmune = new Punto(6,5);
		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo,0);
		   fantasmaInmune = new FantasmaInmune(tab, puntoInmune,0);
		  
		   tab.addFantasma(fantasmaAmarillo);
		   tab.addFantasma(fantasmaInmune);
		  
		   Punto puntoPacman = new Punto(6,2);
		   pacman = new Pacman(tab, puntoPacman);
		   tab.addPacman(pacman);
		   super.setUp();
			
		}
	
	
	public void testAtrapar(){
		assertFalse(fantasmaInmune.esComible());
		
	}	
	
	
	public void testHuir(){
		   	Casillero nuevoPunto;
		   	Punto nuevo = new Punto(5,2);
		   	nuevoPunto = tab.getCasillero(nuevo);
		   	nuevoPunto.accionar();
		   	assertTrue(fantasmaAmarillo.esComible());
		   	assertFalse(fantasmaInmune.esComible());
		   	
	}
	
	
	
	public void testnuevaPosicion(){
		fantasmaInmune.mover();
		Punto nuevo = new Punto(6,4);
		assertEquals(nuevo, fantasmaInmune.getPosicion());
	}
}
