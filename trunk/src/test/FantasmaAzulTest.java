package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.Pacman;

public class FantasmaAzulTest extends TestCase {


	private Tablero tab;
	
	private Fantasma fantasmaAzul;
	
	private Fantasma fantasmaAmarillo;
	
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		
		CargaTablero cargador = new CargaTablero();
		   
		tab = cargador.cargar("xml/miniTablero.xml");
		 
		   
		//Agrego FantasmaAmarillo al tablero, sale desde su casa.
		
		Punto ubicacionAmarillo = new Punto(2,5);
		  
		fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo,0);
		 
		tab.addFantasma(fantasmaAmarillo);
		
		
		
		//Agrego FantasmaAzul al tablero, sale desde su casa.
		   
		Punto ubicacionAzul = new Punto(4,4);
		 		  
		fantasmaAzul = new FantasmaAzul(tab, ubicacionAzul,0);
		 
		tab.addFantasma(fantasmaAzul);
		   
		 
		//Agrego Pacman al tablero.
		   
		Punto puntoPacman = new Punto(6,7);
		   
		pacman = new Pacman(tab, puntoPacman);
		   
		tab.addPacman(pacman);
		   
		   
		super.setUp();
			
	}
	
	
	
	public void testAtrapar(){
		
		
		Punto posicionEsperada = new Punto (3,4);
		
		fantasmaAzul.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAzul.getPosicion()));
		
		//---------
		
		
		//Evaluamos la posicion final del FantasmaAzul.
		
		int movimientos = 10;
		
		for(int i = 0; i<movimientos;i++){
			
			fantasmaAzul.mover();
		}
		
		Punto encuentroConPacman = new Punto(6,7);
		
		assertEquals(encuentroConPacman,fantasmaAzul.getPosicion());
		
		
		//-----------
		
	}	
	
	public void testAtrapar2(){
		
		//Reubico el fantasma Amarillo
		
		Punto nuevaUbicacionAmarillo = new Punto(6,4);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		//Comienzan los movimientos.
		
		Punto posicionEsperada = new Punto (5,4);
		
		fantasmaAzul.mover();
		
		assertTrue(posicionEsperada.equals(fantasmaAzul.getPosicion()));
		
		//----------
		
		posicionEsperada = new Punto (6,2);
		
		int movimientos = 3;
		
		for(int i = 1; i<=movimientos;i++){
			fantasmaAzul.mover();
		}
		assertTrue(posicionEsperada.equals(fantasmaAzul.getPosicion()));
		
		
		
		
	}
	
	public void testHuir(){
		
		
		//Reubico los fantasmas y el pacman.
		
		Punto nuevaUbicacionAmarillo = new Punto(4,4);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		Punto nuevaUbicacionAzul = new Punto(6,4);
		
		fantasmaAzul.setPosicion(nuevaUbicacionAzul);
		
		Punto nuevaUbicacionPacman = new Punto(4,7);
		
		pacman.setPosicion(nuevaUbicacionPacman);
		
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	   	
	   	//Comienzan los movimientos.
	   	
	   	Punto posicionEsperada = new Punto (3,4);
		
		int movimientos = 3;
		
		for(int i = 1; i<=movimientos;i++){
			fantasmaAzul.mover();
		}
		assertTrue(posicionEsperada.equals(fantasmaAzul.getPosicion()));
		
				   	
	}
	public void testHuirEstado(){
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	assertTrue(fantasmaAzul.esComible());
	}
	
	public void testHuir2(){
		
		
		//Reubico los fantasmas y el pacman.
		
		Punto nuevaUbicacionAmarillo = new Punto(6,2);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		Punto nuevaUbicacionAzul = new Punto(6,4);
		
		fantasmaAzul.setPosicion(nuevaUbicacionAzul);
		
		Punto nuevaUbicacionPacman = new Punto(4,7);
		
		pacman.setPosicion(nuevaUbicacionPacman);
		
		
		//Acciono un punto de poder, para cambiar el estado del fantasma.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto); // Punto de poder
	   	
	   	unCasillero.accionar();
	   	
	   	   	
	   	//Comienzan los movimientos.
	   	
	   	Punto posicionEsperada = new Punto (5,2);
		
	   	fantasmaAzul.mover();
	   	fantasmaAzul.mover();
	   	
	   	assertTrue(fantasmaAmarillo.getPosicion().equals(fantasmaAzul.getPosicion()));
	   	
	   	fantasmaAzul.mover();
	   			
		assertTrue(posicionEsperada.equals(fantasmaAzul.getPosicion()));
		
				   	
	}
	
}
