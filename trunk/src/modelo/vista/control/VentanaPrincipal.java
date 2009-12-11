package modelo.vista.control;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.*;

public class VentanaPrincipal extends Frame {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO3 - MAN");
		// this.setSize(300, 300);
		this.setSize(705,655);
		this.setResizable(false);
		// panel = new Panel(222,242,controladorJuego);
		panel = new Panel(666,726,controladorJuego);
		
		this.add(panel);
		
		
		//Creamos la barra de menus.
		
		MenuBar mbarra = new MenuBar();
		Menu m = new Menu( "Archivo" );
		m.add( new MenuItem( "Nuevo") );
		m.add( new MenuItem( "Salir") );
		mbarra.add( m );
	 
		m = new Menu( "Ayuda" );
		m.add( new MenuItem( "Ayuda!" ) );
		m.addSeparator();
		m.add( new MenuItem( "Acerca de..." ) );
		mbarra.add( m );
	 
		setMenuBar( mbarra );
	
	 
		
		
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
