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
		   
		   Punto ubicacionAmarillo = new Punto(4,5);//Lo ubico en su casa.
		 		  
		   fantasmaAmarillo = new FantasmaAmarillo(tab, ubicacionAmarillo);
		 
		   tab.addFantasma(fantasmaAmarillo);
		   
		 
		   //Agrego Pacman al tablero.
		   
		   Punto puntoPacman = new Punto(6,2);
		   
		   pacman = new Pacman(tab, puntoPacman);
		   
		   tab.addPacman(pacman);
		   
		   
		   super.setUp();
			
		}
	

	public void testMover(){
		
		//Ubico en la posicion (4,2) al fantasma para producir luego el choque con el Pacman.
		
		Punto nuevaUbicacionAmarillo = new Punto(4,2);
		
		fantasmaAmarillo.setPosicion(nuevaUbicacionAmarillo);
		
		//---------
		
		
		//El pacman por defecto se mueve a la izquierda.
		
		pacman.mover();
		
		assertTrue(fantasmaAmarillo.esComible());//Tiene que ser comible ya que no es el FantasmaInmune
		
		//---------
		
		
		pacman.mover();//Al no mover al fantasma, el Pacman se encuentra en el mismo casillero que FAmarillo.
		
		assertEquals(fantasmaAmarillo.getPosicionInicial(),fantasmaAmarillo.getPosicion()); //Debe volver a su casa que es la posición inicial.
		
		
						
	}
	
	public void testSerComido(){
		
		pacman.serComido();
		
		Punto posicionEsperada = new Punto(8,8);
		
		boolean puntosIguales = (posicionEsperada.equals(pacman.obtenerPosicion()));
		
		assertTrue(puntosIguales);
		
		
		
	}
	
		
}
