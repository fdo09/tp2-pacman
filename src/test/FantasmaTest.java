package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.Pacman;

public class FantasmaTest extends TestCase {


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

	public void testRegresar() {
		int tiempo = 20;
		fantasmaAmarillo.cambiarEstado(tiempo);//Ahora huye
		
		Punto puntoDeChoque = new Punto(5,4);
		fantasmaAmarillo.setPosicion(puntoDeChoque);
		pacman.mover(); // se mueve a la izquierda y se choca con el fantasma.
		
		assertEquals(pacman.getPosicion(), fantasmaAmarillo.getPosicion());
		
		//Regresa a su casa
		fantasmaAmarillo.mover();
		
		assertEquals(fantasmaAmarillo.getPosicion(), fantasmaAmarillo.getPosicionInicial());
		
	}
}
