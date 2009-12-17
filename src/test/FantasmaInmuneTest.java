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
	
	
	
	public void testnuevaPosicion(){
		fantasmaInmune.mover();
		Punto nuevo = new Punto(6,4);
		assertEquals(nuevo, fantasmaInmune.getPosicion());
	}
	
			
	public void testAtrapar(){		
			
		Punto posicionEsperada = new Punto (6,4);
		fantasmaInmune.mover();
		assertTrue(posicionEsperada.equals(fantasmaInmune.getPosicion()));
			
			
		//Evaluamos la posicion final del FantasmaAzul.
			
		int movimientos = 2;
		for(int i = 0; i<movimientos;i++){	
			fantasmaInmune.mover();
		}
		
		Punto encuentroConPacman = new Punto(6,2);		
		assertEquals(encuentroConPacman,fantasmaInmune.getPosicion());
	
		//-----------
			
	}	
		
	public void testAtrapar2(){
			
		//Reubico el fantasma Amarillo
		Punto nuevaUbicacionAmarillo = new Punto(6,4);
			
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
			
		//Comienzan los movimientos.
			
		Punto posicionEsperada = new Punto (6,4);	
		fantasmaInmune.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaInmune.getPosicion()));
			
		//----------
			
		//Se come al pacman y regresa a su posicion original
		posicionEsperada = new Punto (6,5);
		int movimientos = 3;
			
		for(int i = 1; i<=movimientos;i++){
			fantasmaInmune.mover();
		}
		assertTrue(posicionEsperada.equals(fantasmaInmune.getPosicion()));
				
	}
		
	public void testHuir(){

		//Reubico los fantasmas y el pacman.
			
		Punto nuevaUbicacionAmarillo = new Punto(4,4);
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		Punto nuevaUbicacionAzul = new Punto(6,4);
		fantasmaInmune.setPosicion(nuevaUbicacionAzul);
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
			fantasmaInmune.mover();
		}
		assertTrue(posicionEsperada.equals(fantasmaInmune.getPosicion()));
			
					   	
	}
	
	public void testHuirEstado(){
			
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		Casillero unCasillero; 
			
	   	Punto unPunto = new Punto(5,2);
	  	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	  	unCasillero.accionar();
	  	// Nunca es comible porque es inmune
	   	assertFalse(fantasmaInmune.esComible());
	}
	
	public void testHuir2(){
		//Reubico los fantasmas y el pacman.		
		Punto nuevaUbicacionAmarillo = new Punto(6,2);
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		Punto nuevaUbicacionAzul = new Punto(6,4);
		fantasmaInmune.setPosicion(nuevaUbicacionAzul);
		Punto nuevaUbicacionPacman = new Punto(4,7);
		pacman.setPosicion(nuevaUbicacionPacman);
					
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		Casillero unCasillero; 
		Punto unPunto = new Punto(5,2);
		unCasillero = tab.getCasillero(unPunto); // Punto de poder
		unCasillero.accionar();
		 	
		   	   	
		//Comienzan los movimientos.
		Punto posicionEsperada = new Punto (5,2);
		fantasmaInmune.mover();
		fantasmaInmune.mover();
		   	
		assertTrue(fantasmaAmarillo.getPosicion().equals(fantasmaInmune.getPosicion()));
		fantasmaInmune.mover();
		assertTrue(posicionEsperada.equals(fantasmaInmune.getPosicion()));
			
	}
		
}

