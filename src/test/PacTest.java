package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.Pacman;

public class PacTest extends TestCase {


	private Tablero tab;
	
	private Fantasma fantasmaAmarillo;
	
	private Pacman pacman;

	protected void setUp() throws Exception {
				
		 
		
		   CargaTablero cargador = new CargaTablero();
		   
		   tab = cargador.cargar("xml/miniTablero.xml");
		 
		   
		   //Agrego FantasmaAmarillo al tablero
		   
		   Punto ubicacionAmarillo = new Punto(4,2);
		 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		   
		 
		   //Agrego Pacman al tablero.
		   
		   Punto puntoPacman = new Punto(6,2);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   
		   super.setUp();
			
		}
	

	public void testMover(){
		
			
		pacman.mover();
		
		Punto posicionEsperada = new Punto(5,2);

		assertEquals(posicionEsperada, pacman.getPosicion());
						
	}
	
	public void testSerComido(){
		
		pacman.serComido();
		
		Punto posicionEsperada = new Punto(8,8);
		
		boolean puntosIguales = (posicionEsperada.equals(pacman.obtenerPosicion()));
		
		assertTrue(puntosIguales);
		
		
		
	}
	
		
}
