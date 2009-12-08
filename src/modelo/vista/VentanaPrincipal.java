package modelo.vista;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends Frame {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
		this.setTitle("Tablero PACMAN");
		// this.setSize(300, 300);
		this.setSize(705,680);
		this.setResizable(false);
		// panel = new Panel(222,242,controladorJuego);
		panel = new Panel(666,726,controladorJuego);
		
		this.add(panel);
		
		
		/*Button boton = new Button();
		boton.setLabel("Boton");
		this.add(boton);*/
		
		this.setBackground(Color.black);
		panel.setBackground(Color.black);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}
}
