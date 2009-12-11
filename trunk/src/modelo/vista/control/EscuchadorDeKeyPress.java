package modelo.vista.control;
import modelo.moviles.*;
import java.awt.event.*;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
enum Direccion{IZQUIERDA, ARRIBA, DERECHA, ABAJO};
public class EscuchadorDeKeyPress implements KeyPressedObservador {
	
	private Pacman pacman;
	

	
	public EscuchadorDeKeyPress(Pacman pacman){
		this.pacman = pacman;
	}
	
	public void keyPressed (KeyEvent event){
				switch(event.getKeyCode()){
				case KeyEvent.VK_DOWN:
					String dw = "DOWN";
					pacman.setMovimiento(dw);
					// pacman.mover();
					break;
				case KeyEvent.VK_UP:
					String up = "UP";
					pacman.setMovimiento(up);
					// pacman.mover();
					break;
				case KeyEvent.VK_LEFT:
					String izq = "IZQ";
					pacman.setMovimiento(izq);
					// pacman.mover();
					break;
				case KeyEvent.VK_RIGHT:
					String der = "DER";
					pacman.setMovimiento(der);
					// pacman.mover();
					break;
				default:
					  // pacman.mover();
					break;
				}
				
				
				}
		
	}
	