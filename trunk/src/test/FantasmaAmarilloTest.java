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
		 
		   
		   //Agrego FantasmaAmarillo al tablero, sale desde su casa.
		   
		   Punto ubicacionAmarillo = new Punto(3,5);
		 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		   
		 
		   //Agrego Pacman al tablero.
		   
		   Punto puntoPacman = new Punto(6,4);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   
		   super.setUp();
			
		}
	
	
	
	public void testAtrapar(){
		
		
		Punto posicionEsperada = new Punto (3,4);
		
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
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaAmarillo.mover();
		
		
		assertTrue(pacman.obtenerPosicion().equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
	}	
	
	
	
	
	
	public void testHuir(){
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	assertTrue(fantasmaAmarillo.esComible());
	   	
	   	
	   	
	   	//Comienzan los movimientos.
	   	
		Punto posicionEsperada = new Punto (3,4);
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//---------
		
		posicionEsperada.moverHaciaIzquierda();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		posicionEsperada.moverHaciaIzquierda();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		posicionEsperada.moverHaciaArriba();
		
		fantasmaAmarillo.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAmarillo.getPosicion()));
		
		//-----------
		
		
		   	
	}
	
	public void testRegresar() {
		
		fantasmaAmarillo.cambiarEstado();//Ahora huye
		
		Punto puntoDeChoque = new Punto(5,4);
		
		fantasmaAmarillo.setPosicion(puntoDeChoque);
		
		pacman.mover(); // se mueve a la izquierda y se choca con el fantasma.
		
		assertEquals(fantasmaAmarillo.getPosicionInicial(), fantasmaAmarillo.getPosicion());
		
	}
	
	
	
	
}
