package test;

import java.io.File;

import modelo.*;
import modelo.FantasmaAmarillo;
import modelo.FantasmaAzul;
import modelo.FantasmaInmune;
import modelo.FantasmaNaranja;
import modelo.FantasmaRojo;
import modelo.Pacman;
import fijos.*;
import fijos.CargaTablero;
import fijos.Punto;
import fijos.Tablero;
import junit.framework.TestCase;

public class FantasmaNaranjaTest extends TestCase {
	private Tablero tab;
	private Fantasma fantasmaAzul;
	private Fantasma fantasmaRojo;
	private Fantasma fantasmaNaranja;
	private Fantasma fantasmaAmarillo;
	private Fantasma fantasmaInmune;
	private Pacman pacman;

	protected void setUp() throws Exception {
		
		   CargaTablero cargador = new CargaTablero();
		   File file = new File("xml/tablero.xml");
		   tab = cargador.Cargador(file);
		   Punto puntoAzul = new Punto(15,12);
		   Punto puntoRojo = new Punto(15,13);
		   Punto puntoNaranja = new Punto(15,14);
		   Punto puntoAmarillo = new Punto(15,15);
		   Punto puntoInmune = new Punto(13,12);
		   fantasmaAzul = new FantasmaAzul(tab, puntoAzul);
		   fantasmaRojo = new FantasmaRojo(tab, puntoRojo);
		   fantasmaNaranja = new FantasmaNaranja(tab, puntoNaranja);
		   fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo);
		   fantasmaInmune = new FantasmaInmune(tab, puntoInmune);
		   tab.addFantasma(fantasmaAzul);
		   tab.addFantasma(fantasmaRojo);
		   tab.addFantasma(fantasmaNaranja);
		   tab.addFantasma(fantasmaAmarillo);
		   tab.addFantasma(fantasmaInmune);
		   Punto puntoPacman = new Punto(29,10);
		   pacman = new Pacman(tab, puntoPacman);
		   tab.addPacman(pacman);
		   super.setUp();
			
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
	
	public void testAtrapar(){
		
	}	
}
