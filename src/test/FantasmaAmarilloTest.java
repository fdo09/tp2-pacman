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
		   tab = cargador.cargar("xml/miniTablero.xml");
		 
		   Punto puntoAmarillo = new Punto(4,4);
		 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		 
		   Punto puntoPacman = new Punto(7,3);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		
		
		Punto posicionEsperada = new Punto (4,3);
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//---------
		
		
		posicionEsperada.moverHaciaIzquierda();
		
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
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(2,5);
		
	   	unCasillero = tab.getCasillero(unPunto);
	   	
	   	unCasillero.accionar();
	   	
	   	assertTrue(fantasmaAmarillo.esComible());
	   	
	   	
		Punto posicionEsperada = new Punto (5,4);
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//---------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaArriba();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		
		posicionEsperada.moverHaciaArriba();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada, fantasmaAmarillo.getPosicion());
		
		//-----------
		
		
		
		   	
	}
	
	public void testregresar() {
		
		fantasmaAmarillo.cambiarEstado();//Ahora huye
		
		Punto casa = new Punto (5,4);
		
		Punto puntoDeChoque = new Punto(7,2);
		
		fantasmaAmarillo.setPosicion(puntoDeChoque);
		
		pacman.mover(); // se mueve a la izquierda y se choca con el fantasma.
		
		assertEquals(casa, fantasmaAmarillo.getPosicion());
		
		
		
		
	}
	
	
}
