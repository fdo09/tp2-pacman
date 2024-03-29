package test;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;
import modelo.fijos.CargaTablero;
import modelo.fijos.Punto;
import modelo.fijos.Tablero;
import modelo.moviles.Fantasma;
import modelo.moviles.FantasmaAmarillo;
import modelo.moviles.FantasmaAzul;
import modelo.moviles.FantasmaInmune;
import modelo.moviles.FantasmaNaranja;
import modelo.moviles.FantasmaRojo;

public class CargaPersonajesTest extends TestCase {

	private Tablero tab;
	private Fantasma fantasmaAzul;
	private Fantasma fantasmaRojo;
	private Fantasma fantasmaNaranja;
	private Fantasma fantasmaAmarillo;
	private Fantasma fantasmaInmune;
	
	protected void setUp() throws Exception {
			
		   
		   CargaTablero cargador = new CargaTablero();
		   tab = cargador.cargar("xml/Tablero.xml");
		   
		   Punto puntoAzul = new Punto(15,12);
		   Punto puntoRojo = new Punto(15,13);
		   Punto puntoNaranja = new Punto(15,14);
		   Punto puntoAmarillo = new Punto(15,15);
		   Punto puntoInmune = new Punto(13,12);
		   
		   fantasmaAzul = new FantasmaAzul(tab, puntoAzul,0);
		   fantasmaRojo = new FantasmaRojo(tab, puntoRojo,0);
		   fantasmaNaranja = new FantasmaNaranja(tab, puntoNaranja,0);
		   fantasmaAmarillo = new FantasmaAmarillo(tab, puntoAmarillo,0);
		   fantasmaInmune = new FantasmaInmune(tab, puntoInmune,0);
		   
		   tab.addFantasma(fantasmaAzul);
		   tab.addFantasma(fantasmaRojo);
		   tab.addFantasma(fantasmaNaranja);
		   tab.addFantasma(fantasmaAmarillo);
		   tab.addFantasma(fantasmaInmune);
		   
		   super.setUp();
			
		}
	
	public void testUbicacionFantasma(){
		Punto puntoPrueba = new Punto (15,12);
		assertEquals(puntoPrueba, fantasmaAzul.getPosicion());
	}
	
	
	public void testCantidadDeFantasmas(){
		Collection <Fantasma> cantFantasmas;
		cantFantasmas = tab.getFantasmas();
		Iterator <Fantasma> itera = cantFantasmas.iterator();
		int r = 0;
		while (itera.hasNext()){
			itera.next();
			r++;
		}
		assertEquals(5,r);
			
 	}

}
