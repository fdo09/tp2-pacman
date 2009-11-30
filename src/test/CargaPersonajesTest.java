package test;

import java.io.File;

import modelo.*;
import fijos.*;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.TestCase;

public class CargaPersonajesTest extends TestCase {

	private Tablero tab;
	private Fantasma fantasmaAzul;
	private Fantasma fantasmaRojo;
	private Fantasma fantasmaNaranja;
	private Fantasma fantasmaAmarillo;
	private Fantasma fantasmaInmune;
	
	protected void setUp() throws Exception {
			
		   tab = new Tablero(32,32);
		   CargaTablero cargador = new CargaTablero();
		   File file = new File("xml/tablero.xml");
		   cargador.Cargador(tab, file);
		   Punto puntoAzul = new Punto(16,13);
		   Punto puntoRojo = new Punto(16,14);
		   Punto puntoNaranja = new Punto(16,15);
		   Punto puntoAmarillo = new Punto(16,16);
		   Punto puntoInmune = new Punto(14,14);
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
		   
		   
		   super.setUp();
			
		}
	
	public void testUbicacionFantasma(){
		Punto puntoPrueba = new Punto (16,13);
		assertEquals(puntoPrueba, tab.posicionFantasma(fantasmaAzul));
	}
	
	
	public void testCantidadDeFantasmas(){
		Collection <Fantasma> cantFantasmas;
		cantFantasmas = tab.obtenerFantasmas();
		Iterator <Fantasma> itera = cantFantasmas.iterator();
		int r = 0;
		while (itera.hasNext()){
			itera.next();
			r++;
		}
		assertEquals(5,r);
			
 	}
	
}
