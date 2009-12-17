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
		
		Punto posicionEsperada = new Punto (6,4);
		fantasmaRojo.mover();
		assertTrue(posicionEsperada.equals(fantasmaRojo.getPosicion()));
			
			
		//Evaluamos la posicion final del FantasmaAzul.
			
		int movimientos = 2;
		for(int i = 0; i<movimientos;i++){	
			fantasmaRojo.mover();
		}
		
		Punto encuentroConPacman = new Punto(6,2);		
		assertEquals(encuentroConPacman,fantasmaRojo.getPosicion());
	
		//-----------
			
	}		
	
	
	
	public void testHuir(){

		//Reubico al fantasmas y el pacman.
			

		
		Punto nuevaUbicacionRojo = new Punto(6,4);
		fantasmaRojo.setPosicion(nuevaUbicacionRojo);
		
		Punto nuevaUbicacionPacman = new Punto(4,7);
		pacman.setPosicion(nuevaUbicacionPacman);
			
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 	
		Punto unPunto = new Punto(5,2);
		unCasillero = tab.getCasillero(unPunto); // Punto de poder
		unCasillero.accionar();
		   	
		//Comienzan los movimientos.
		   	
	   	Punto posicionEsperada = new Punto (5,2);
			
		int movimientos = 3;
			
		for(int i = 1; i<=movimientos;i++){
			fantasmaRojo.mover();
		}
		assertTrue(posicionEsperada.equals(fantasmaRojo.getPosicion()));
			
					   	
	}
	
	public void testHuirEstado(){
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		Casillero unCasillero; 
			
	   	Punto unPunto = new Punto(5,2);
	  	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	  	unCasillero.accionar();

	   	assertTrue(fantasmaRojo.esComible());
	}
	
	
	
	
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
