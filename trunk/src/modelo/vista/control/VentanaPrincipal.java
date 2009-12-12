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
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends Frame {

	private Menu menuArchivo;
	private Menu menuAyuda;
	private MenuItem nuevo;
	
	private MenuItem salir;
	private MenuItem ayuda;
	private MenuItem acercaDe;
	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
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
		
		menuArchivo = new Menu( "Archivo" );
		
		nuevo = new MenuItem("Nuevo");
	
		salir = new MenuItem("Salir");
		
		menuArchivo.add(nuevo);

		menuArchivo.add(salir);
		
		mbarra.add(menuArchivo);
	 
		menuAyuda = new Menu( "Ayuda" );
		ayuda = new MenuItem("Reglas");
		acercaDe = new MenuItem("Acerca de..");
		
		mbarra.add(menuAyuda);
		
		menuAyuda.add(ayuda);
		menuAyuda.add(acercaDe);
		
		setMenuBar(mbarra);
	
		/*nuevo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				controladorJuego.comenzarJuego();
				
				
				}
			});*/
			
		ayuda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Frame unaVentana = new Frame();
				
				String titulo = "Reglas";
				@SuppressWarnings("unused")
				Regla reglas = new Regla(unaVentana,titulo);
				
				}
			});
		
		acercaDe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Frame unaVentana = new Frame();
			
				String titulo = "Acerca de...";
				@SuppressWarnings("unused")
				AcercaDe acercaDe = new AcercaDe(unaVentana,titulo);
				
				}
			});
		
		salir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				dispose();
				System.exit(0);
			}
		
		});
		
		
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

	
	
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
		
	}
	

	
}
