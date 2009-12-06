package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Juego;
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
		 
		   
		   //Agrego FantasmaAmarillo al tablero.
		   
		   Punto ubicacionAmarillo = new Punto(3,2);
		 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		   
		 
		   //Agrego Pacman al tablero.
		   
		   Punto puntoPacman = new Punto(6,2);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		
		
		Punto posicionEsperada = new Punto (4,2);
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//---------
		
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		
	}	
	
	
	
	
	
	public void testHuir(){
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(2,5);
		
	   	unCasillero = tab.getCasillero(unPunto); // punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	assertTrue(fantasmaAmarillo.esComible());
	   	
	   	
		Punto posicionEsperada = new Punto (2,2);
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//---------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------		
		
		   	
	}
	
	public void testRegresar() {
		
		fantasmaAmarillo.cambiarEstado();//Ahora huye
		
		Punto puntoDeChoque = new Punto(5,2);
		
		fantasmaAmarillo.setPosicion(puntoDeChoque);
		
		pacman.mover(); // se mueve a la izquierda y se choca con el fantasma.
		
		assertEquals(fantasmaAmarillo.getPosicionInicial(), fantasmaAmarillo.getPosicion());
		
	
		
	}
	
	
	
	
}
