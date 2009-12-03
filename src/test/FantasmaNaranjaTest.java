package test;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Casillero;
import modelo.fijos.Juego;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;
import modelo.moviles.Pacman;

public class FantasmaNaranjaTest extends TestCase {
	private Tablero tab;
	private Fantasma fantasmaAzul;
	private Fantasma fantasmaRojo;
	private Fantasma fantasmaNaranja;
	// private Fantasma fantasmaAmarillo;
	// private Fantasma fantasmaInmune;
	private Pacman pacman;

	protected void setUp() throws Exception {
		
			
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/miniTablero.xml");
		   // Punto puntoAzul = new Punto(15,12);
		   // Punto puntoRojo = new Punto(15,13);
		   // Punto puntoNaranja = new Punto(15,14);
		   Punto puntoAzul = new Punto(4,2);
		   Punto puntoRojo = new Punto(4,3);
		   Punto puntoNaranja = new Punto(4,4);
		   // Punto puntoAmarillo = new Punto(15,15);
		   // Punto puntoInmune = new Punto(13,12);
		   fantasmaAzul = new FantasmaAzul(tab, puntoAzul);
		   fantasmaRojo = new FantasmaRojo(tab, puntoRojo);
		   fantasmaNaranja = new FantasmaNaranja(tab, puntoNaranja);
		   // fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo);
		   ///fantasmaInmune = new FantasmaInmune(tab, puntoInmune);
		   tab.addFantasma(fantasmaAzul);
		   tab.addFantasma(fantasmaRojo);
		   tab.addFantasma(fantasmaNaranja);
		   // tab.addFantasma(fantasmaAmarillo);
		   // tab.addFantasma(fantasmaInmune);
		   // Punto puntoPacman = new Punto(29,10);
		   Punto puntoPacman = new Punto(6,2);
		   pacman = new Pacman(tab, puntoPacman);
		   tab.addPacman(pacman);
		   super.setUp();
			
		}
	
	public void testAtrapar(){
		assertFalse(fantasmaNaranja.esComible());
		
	}	
	
	
	public void testHuir(){
		   	Casillero nuevoPunto;
		   	Punto nuevo = new Punto(1,4);
		   	nuevoPunto = tab.getCasillero(nuevo);
		   	nuevoPunto.accionar();
		   	assertTrue(fantasmaNaranja.esComible());
		   	
	}
	
	public void testregresar() {
		
	}
	
	public void testnuevaPosicion(){
		fantasmaNaranja.mover();
		// Punto nuevo = new Punto(14,14);
		Punto nuevo = new Punto(3,4);
		Punto prueba = fantasmaNaranja.getPosicion();
		// assertEquals(nuevo, fantasmaNaranja.getPosicion());
		assertEquals(nuevo, prueba);
	}
	
	
}
