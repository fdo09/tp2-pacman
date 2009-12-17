package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;

public class FantasmaRojoTest extends TestCase {

	private Tablero tab;

	private Fantasma fantasmaRojo;

	private Pacman pacman;

	protected void setUp() throws Exception {
		
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/miniTablero.xml");
		
		   Punto puntoRojo = new Punto(6,5);
		   fantasmaRojo = new FantasmaRojo(tab, puntoRojo,0);
		 
		   tab.addFantasma(fantasmaRojo);
		
		   Punto puntoPacman = new Punto(6,2);
		   pacman = new Pacman(tab, puntoPacman);
		   tab.addPacman(pacman);
		  
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		assertFalse(fantasmaRojo.esComible());
		
	}	
	
	public void testPosicionEsperada(){
		
		fantasmaRojo.mover();
		
		Punto posicionEsperada = new Punto(6,4);
		
		assertEquals(posicionEsperada, fantasmaRojo.getPosicion());
	}
	
	
	public void testHuir(){
		  
		Casillero nuevoPunto;
		   
		   	Punto nuevo = new Punto(5,2);
		   
		   	nuevoPunto = tab.getCasillero(nuevo);
		   	
		   	nuevoPunto.accionar();
		   	
		   	assertTrue(fantasmaRojo.esComible());
		   	
	}
	
	
	
	public void testnuevaPosicion(){
		fantasmaRojo.mover();
	
		Punto nuevo = new Punto(6,4);
		
		assertEquals(nuevo, fantasmaRojo.getPosicion());
		
		fantasmaRojo.mover();
		
		Punto esperado = new Punto(6,3);
		
		assertEquals(esperado, fantasmaRojo.getPosicion());
	}
	
	/*
	public void testComerPacman(){
		for ( int i = 0; i < 3 ; i++) fantasmaRojo.mover();
		
		
		assertEquals(pacman.getPosicion(), fantasmaRojo.getPosicion());
		assertEquals(pacman.getPosicionInicial(), fantasmaRojo.getPosicion());
		
	}
	*/
	public void testPacmanComeFantasma(){
		
		Casillero nuevoPunto;
	  
		Punto nuevo = new Punto(5,2);
	   	
		nuevoPunto = tab.getCasillero(nuevo);
	   	
		nuevoPunto.accionar();
	   	
		fantasmaRojo.mover();
	   	
		fantasmaRojo.mover();
	   
		Punto posicion = new Punto(6,7);
	   	
		pacman.setPosicion(posicion);
	   	
		
		assertTrue(fantasmaRojo.esComible());
	   	
		assertEquals(pacman.getPosicion(), fantasmaRojo.getPosicion());
	   	
		
		
	}
	
}
