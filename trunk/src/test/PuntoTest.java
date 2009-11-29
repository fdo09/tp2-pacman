package test;

import java.util.ArrayDeque;
import java.util.ArrayList;

import junit.framework.TestCase;
import fijos.Punto;

public class PuntoTest extends TestCase {

		private Punto punto1;
		private Punto punto2;
		private Punto punto3;
		private Punto punto4;
	
		
	protected void setUp() throws Exception {
		
		punto1 = new Punto(1,1);
		punto2 = new Punto(1,2);
		punto3 = new Punto(1,3);
		punto4 = new Punto(4,4);
	
		
		super.setUp();
		
	}
	public void testDistancia(){
		
		double distanciaEsperada = 1.0;
		
		/*
		 * punto1 = (1,1)
		 * punto2 = (1,2)
		 */
		double distancia1 = punto1.distancia(punto2);
		
		assertEquals(distanciaEsperada,distancia1);
		
		
		// punto3 = (1,3)
		
		double distancia2 = punto1.distancia(punto3);
		
		distanciaEsperada = 2.0;
		
		assertEquals(distanciaEsperada,distancia2);
		
				
		//punto4 = (4,4)
		
		
		double distancia3 = punto1.distancia(punto4);
		
		distanciaEsperada = 4.242640687119285;
		
		assertEquals(distanciaEsperada,distancia3);
		
	}
	
	public void testObtenerVecinosAdyacentes(){
		
				
		ArrayList<Punto> vecinosDePunto3 = new ArrayList<Punto>();
		
		vecinosDePunto3 = (ArrayList<Punto>) punto3.obtenerPuntosAdyacentes();
		
		//punto3 = (1,3)
		
		Punto vecinoIzquierdo = new Punto(0,3);
		Punto vecinoDeArriba = new Punto(1,4);
		Punto vecinoDerecho = new Punto(2,3);
		Punto vecinoDeAbajo = new Punto(1,2);
		
		boolean contieneVecino;
		
		contieneVecino = vecinosDePunto3.get(0).equals(vecinoIzquierdo);
		
		assertTrue(contieneVecino);
		
		contieneVecino = vecinosDePunto3.get(1).equals((vecinoDeArriba));
		
		assertTrue(contieneVecino);
		
		contieneVecino = vecinosDePunto3.get(2).equals((vecinoDerecho));
		
		assertTrue(contieneVecino);
		
		contieneVecino = vecinosDePunto3.get(3).equals((vecinoDeAbajo));
		
		assertTrue(contieneVecino);
	
	}
	
	public void testObtenerVecinosAdyacentes2(){
		
		int tamanioListaVecinos = 4;
		
		//punto3 = (1,3)
		
		ArrayList<Punto> vecinosDePunto3 = new ArrayList<Punto>();
		
		vecinosDePunto3 = (ArrayList<Punto>) punto3.obtenerPuntosAdyacentes();
		
		assertEquals(tamanioListaVecinos, vecinosDePunto3.size());
				
	}
	
	public void testMoverHaciaIzquierda(){
		
		//punto1 = (1,1)
		
		punto1.moverHaciaIzquierda();
		
		//punto1 = (0,1)
		
		Punto posicionEsperada = new Punto(0,1);
		
		boolean puntosIguales = (posicionEsperada.equals(punto1));
		
		assertTrue(puntosIguales);
				
	}
	
	public void testMoverHaciaArriba(){
		
		//punto1 = (1,1)
		
		punto1.moverHaciaArriba();
		
		//punto1 = (1,2)
		
		Punto posicionEsperada = new Punto(1,2);
		
		boolean puntosIguales = (posicionEsperada.equals(punto1));
		
		assertTrue(puntosIguales);
		
		
	}

	public void testMoverHaciaDerecha(){
	
		//punto1 = (1,1)
	
		punto1.moverHaciaDerecha();
	
		//punto1 = (2,1)
	
		Punto posicionEsperada = new Punto(2,1);
	
		boolean puntosIguales = (posicionEsperada.equals(punto1));
		
		assertTrue(puntosIguales);
		
	
	}

	public void testMoverHaciaAbajo(){
	
		//punto1 = (1,1)
	
		punto1.moverHaciaAbajo();
	
		//punto1 = (1,0)
	
		Punto posicionEsperada = new Punto(1,0);
	
		boolean puntosIguales = (posicionEsperada.equals(punto1));
		
		assertTrue(puntosIguales);
		
	
	}
	
	public void testEquals(){
		
		//punto1 = (1,1)
		
		Punto unPunto = new Punto (1,1);
		
		boolean puntosIguales = (unPunto.equals(punto1));
		
		assertTrue(puntosIguales);
		
	}
	
	public void testOrdenarPosicionesPorDistancia(){
		
		ArrayList<Punto> listaDePuntos = new ArrayList<Punto>();
		
		//Agregamos a la lista en forma desordenada.
		
		listaDePuntos.add(punto4);
		listaDePuntos.add(punto2);
		listaDePuntos.add(punto3);
		
		
		
		ArrayDeque<Punto> listaOrdenada = punto1.obtenerPosicionesOrdenadas(listaDePuntos);
		
		Punto elementoEsperado = listaOrdenada.pop();
		
		//El elemento a menor distancia es el punto2.
		
		assertEquals(elementoEsperado,punto2);
		
		
		//Le sigue el punto3
		elementoEsperado = listaOrdenada.pop();
		
		assertEquals(elementoEsperado,punto3);
		
		//Por �ltimo el punto4.
		elementoEsperado = listaOrdenada.pop();
		
		assertEquals(elementoEsperado,punto4);
		
		
	}

}
