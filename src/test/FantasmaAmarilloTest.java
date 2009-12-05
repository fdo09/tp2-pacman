package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.Pacman;

public class FantasmaAmarilloTest extends TestCase {

	private Tablero tab;
	
	private Fantasma fantasmaAmarillo;
	
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/tablero.xml");
		 
		   Punto puntoAmarillo = new Punto(4,3);
		 
		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		 
		   Punto puntoPacman = new Punto(7,3);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		
		
		Punto posicionEsperada = new Punto (4,2);
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//---------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		
	}	
	
	
	public void testHuir(){
		   	Casillero nuevoPunto;
		   	Punto nuevo = new Punto(1,4);
		   	nuevoPunto = tab.getCasillero(nuevo);
		   	nuevoPunto.accionar();
		   	assertTrue(fantasmaAmarillo.esComible());
		   	
	}
	
	public void testregresar() {
		
	}
	
	public void testnuevaPosicion(){
		fantasmaAmarillo.mover();
		Punto nuevo = new Punto(14,14);
		assertEquals(nuevo, fantasmaAmarillo.getPosicion());
	}
}
