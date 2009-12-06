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
		
		//Evaluamos la posicion del fantasma a mitad de camino, no hay otro posible movimiento mas que hacia la derecha.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto mitadDeCamino = new Punto(6,4);
		
		assertEquals(mitadDeCamino, fantasmaNaranja.getPosicion());
		
		//---------
		
		//Evaluamos la posicion final del fantasma, no hay otro posible movimiento mas que para abajo.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto finalDelCamino = new Punto(6,7);
		
		assertEquals(finalDelCamino, fantasmaNaranja.getPosicion());
		assertEquals(pacman.getPosicion(), fantasmaNaranja.getPosicion());
		
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
		
	
		//Evaluamos la posición del FantasmaNaranaja, tiene que estar en la misma que el FantasmaAmarillo.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto encuentro = new Punto (4,7);
		
		assertEquals(encuentro, fantasmaNaranja.getPosicion());
		assertEquals(fantasmaAmarillo.getPosicion(),fantasmaNaranja.getPosicion());
				
		//-----------
		
		
		//Luego de moverse dos veces debe encontrarse con el Pacman.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto posicionFinal = new Punto(6,7);
		
		assertEquals(posicionFinal, fantasmaNaranja.getPosicion());
		assertEquals(pacman.obtenerPosicion(), fantasmaNaranja.getPosicion());
		
		//-----------
		
	}	
	
	
	public void testHuir(){
		
		
		//Reubicamos a los fantasmas.	
	   	
	   	Punto nuevaUbicacionNaranja = new Punto(6,4);
		
		fantasmaNaranja.setPosicion(nuevaUbicacionNaranja);
		
		Punto nuevaUbicacionAmarillo = new Punto(6,6);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		//---------
		
		
		//Activamos el casillero Punto de Poder para que los Fantasmas huyan.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto);
	   	
	   	unCasillero.accionar();
	   	
	   	
		
		//Comienzan los movimientos.
	 	
		Punto posicionEsperada = new Punto (6,3);
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//---------
		
		//Sube hasta la esquina superior izquierda.
		
		Punto mitadDeCamino = new Punto (6,2);
		
		fantasmaNaranja.mover();
		
		
		assertEquals(mitadDeCamino, fantasmaNaranja.getPosicion());
		
		//---------
		
		//Termina en la esquina superior derecha.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto ultimoCasillero = new Punto (1,2);
		
		assertEquals(ultimoCasillero, fantasmaNaranja.getPosicion());
		
		//-----------
		
	}
	
	public void testHuir2(){
		
		
		//Reubicamos a los fantasmas.	
	   	
	   	Punto nuevaUbicacionNaranja = new Punto(6,4);
		
		fantasmaNaranja.setPosicion(nuevaUbicacionNaranja);
		
		Punto nuevaUbicacionAmarillo = new Punto(3,4);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		
		//Activamos el casillero Punto de Poder para que los Fantasmas huyan.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto);
	   	
	   	unCasillero.accionar();
	   	
	   			
		//---------
	   		   	
		
		//Comienzan los movimientos.
	 	
		Punto posicionEsperada = new Punto (5,4);
		
		fantasmaNaranja.mover();
		
		assertEquals(posicionEsperada, fantasmaNaranja.getPosicion());
		
		//---------
		
		//Se mueve en unica dirección hasta llegar al FantasmaAmarillo.
		
		fantasmaNaranja.mover();
		fantasmaNaranja.mover();
		
		Punto ultimoCasillero = new Punto (3,4);
		
		assertEquals(ultimoCasillero, fantasmaNaranja.getPosicion());
		assertEquals(fantasmaAmarillo.getPosicion(), fantasmaNaranja.getPosicion());
		
		fantasmaNaranja.mover();
		
		ultimoCasillero.moverHaciaIzquierda();
		
		assertEquals(ultimoCasillero, fantasmaNaranja.getPosicion());
		
		//-----------
		
		
		   	
	}
	public void testHuirEstado(){
		
		//Activamos el casillero Punto de Poder para que los Fantasmas huyan.
		
		Casillero unCasillero; 
		
	   	Punto unPunto = new Punto(5,2);
		
	   	unCasillero = tab.getCasillero(unPunto);
	   	
	   	unCasillero.accionar();
	   	
	   	
	   	//Ambos fantasmas ahora deben ser comibles.
	   	
	   	assertTrue(fantasmaNaranja.esComible());
	   	
	 	assertTrue(fantasmaAmarillo.esComible());
	
	
	}
}
