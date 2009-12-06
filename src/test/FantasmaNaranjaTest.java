package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.Pacman;

public class FantasmaNaranjaTest extends TestCase {
private Tablero tab;
	
	private Fantasma fantasmaNaranja;
	private Fantasma fantasmaAmarillo;
	
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		   CargaTablero cargador = new CargaTablero();
		   
		   tab = cargador.cargar("xml/miniTablero.xml");
		   
		   		 
		   //Agrego FantasmaNaranja a tablero.
		   
		   Punto ubicacionNaranja = new Punto(1,4);
		 		  
		   fantasmaNaranja = new FantasmaNaranja(tab, ubicacionNaranja);
		 
		   tab.addFantasma(fantasmaNaranja);
		   
		   
		   //Agrego FantasmaAmarillo a tablero.
		   
		   Punto ubicacionAmarillo = new Punto(1,2);
	 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		   
		   
		   
		   //Agrego Pacman a tablero.
		 
		   Punto puntoPacman = new Punto(6,7);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		
		
		/* El FantasmaAmarillo esta mas lejos del Pacman, por lo tanto el FantasmaNaranja
		   va directo en busca del mismo*/
		
		Punto posicionEsperada = new Punto (2,4);
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//---------
		
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		

		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		

		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(pacman.obtenerPosicion(), fantasmaNaranja.getPosicion());
		
		//-----------
		
		
	}	
	
	
	public void testAtrapar2(){
		
		
		/* Ubico al FantasmaAmarillo mas cerca del Pacman que el FantasmaNaranaja,
		 * por lo tanto primero tendrá que acercarse a el, y luego ir ambos en busca del Pacman.
		 * 
		 */
		
		Punto nuevaUbicacionAmarillo = new Punto(4,7);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		
		//Comienzan los movimientos.
		
		Punto posicionEsperada = new Punto (1,5);
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//---------
		
				
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
	
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		assertEquals(fantasmaAmarillo.getPosicion(),fantasmaNaranja.getPosicion());
				
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
				
		//-----------
		
		posicionEsperada.moverHaciaDerecha();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		assertEquals(pacman.obtenerPosicion(), fantasmaNaranja.getPosicion());
		
		//-----------
		
	}	
	
	
	public void testHuir(){
		
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(6,4);
		
	   	unCasillero = tab.getCasillero(unPunto);
	   	
	   	unCasillero.accionar();
	   	
	   	
	   	assertTrue(fantasmaNaranja.esComible());
	   	
	 	assertTrue(fantasmaAmarillo.esComible());
	   	
	 	
		Punto posicionEsperada = new Punto (4,1);
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//---------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
		
		posicionEsperada.moverHaciaAbajo();
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//-----------
	
		
		
		   	
	}
	
	
	
}
