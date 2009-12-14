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
		 		  
		fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo,0);
		 
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
		
		
		//Evaluamos la posicion final del FantasmaAmarillo, debe ir a su derecha hasta atrapar al Pacman.
		
		fantasmaAmarillo.mover();
		fantasmaAmarillo.mover();
		fantasmaAmarillo.mover();
		
		Punto encuentroConPacman = new Punto(6,4);
		
		assertEquals(encuentroConPacman,fantasmaAmarillo.getPosicion());
		assertEquals(pacman.getPosicion(),fantasmaAmarillo.getPosicion());
		
		//-----------
		
	}	
	
	
	public void testHuir(){
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	   	
	   	//Comienzan los movimientos.
	   	
		Punto posicionEsperada = new Punto (3,4);
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada,fantasmaAmarillo.getPosicion());
		
		//---------
		
		posicionEsperada.moverHaciaIzquierda();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada,fantasmaAmarillo.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaIzquierda();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada,fantasmaAmarillo.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaArriba();
		
		fantasmaAmarillo.mover();
		
		assertEquals(posicionEsperada,fantasmaAmarillo.getPosicion());
		
		//-----------
		
				   	
	}
	public void testHuir2(){
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	assertTrue(fantasmaAmarillo.esComible());
	}
	
	
	
	
	
	
}
