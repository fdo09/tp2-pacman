package test;

import java.io.File;

import moviles.*;
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
			
		   
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/tablero.xml");
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
		   
		   
		   super.setUp();
			
		}
	
	public void testUbicacionFantasma(){
		Punto puntoPrueba = new Punto (15,12);
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
/*
	public void testUbicarFantasmaTipo(){
		Collection <Fantasma> cantFantasmas;
		cantFantasmas = tab.obtenerFantasmas();
		Iterator <Fantasma> itera = cantFantasmas.iterator();
		Fantasma nuevoFantasma;
		while (itera.hasNext()){
			nuevoFantasma = itera.next();
			
			
		}
	}
*/
}
