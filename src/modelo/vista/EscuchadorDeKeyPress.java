package modelo.vista;
import modelo.moviles.*;
import java.awt.event.*;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class EscuchadorDeKeyPress implements KeyPressedObservador {
	
	private Pacman pacman;

	
	public EscuchadorDeKeyPress(Pacman pacman){
		this.pacman = pacman;
	}
	
	public void keyPressed (KeyEvent event){
				switch(event.getKeyCode()){
				case KeyEvent.VK_DOWN:
					pacman.moverAbajo();
					break;
				case KeyEvent.VK_UP:
					pacman.moverArriba();
					break;
				case KeyEvent.VK_LEFT:
					pacman.moverIzquierda();
					break;
				case KeyEvent.VK_RIGHT:
					pacman.moverDerecha();
					break;
				default:
					break;
				}
				
				
				}
		
	}
	