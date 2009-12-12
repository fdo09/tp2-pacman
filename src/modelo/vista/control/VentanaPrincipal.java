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
	private MenuItem pausa;
	private MenuItem salir;
	private MenuItem reglas;
	private MenuItem acercaDe;
	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		
		this.controladorJuego = unControladorJuego;
		
		this.addKeyListener(new KeyPressedController(controladorJuego));
		
		this.setTitle("ALGO3 - MAN");
		
		this.setSize(705,655);
		
		this.setResizable(false);
		
		panel = new Panel(666,726,controladorJuego);
		
		this.add(panel);
		
		
		//Creamos la barra de menus.
		
		MenuBar mbarra = new MenuBar();
		
		
		//Añadimos un menu Archivo que contiene Nuevo y Salir.
		
		menuArchivo = new Menu( "Archivo" );
		
		nuevo = new MenuItem("Nuevo");
		
		pausa = new MenuItem ("Pausar");
	
		salir = new MenuItem("Salir");
		
		menuArchivo.add(nuevo);

		menuArchivo.add(pausa);
		
		menuArchivo.add(salir);
		
		mbarra.add(menuArchivo);
	 
		//Añadimos un menu Ayuda que contiene Reglas y AcercaDe.
		
		menuAyuda = new Menu( "Ayuda" );
		
		reglas = new MenuItem("Reglas");
		
		acercaDe = new MenuItem("Acerca de..");
		
		mbarra.add(menuAyuda);
		
		menuAyuda.add(reglas);
		menuAyuda.add(acercaDe);
		
		setMenuBar(mbarra);
	
		
		
		//Asignamos las acciones de nuestros items del menu Archivo y Ayuda.
		
		
		/*nuevo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
			
				controladorJuego.comenzarJuego();
				
				
				}
		});*/
		
		pausa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				controladorJuego.detenerJuego();
				
				}
		});
			
		reglas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Frame unaVentana = new Frame();
				
				String titulo = "Reglas";
				@SuppressWarnings("unused")// Solo necesitamos generar una nueva ventana.
				Regla reglas = new Regla(unaVentana,titulo);
				
				}
			});
		
		acercaDe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Frame unaVentana = new Frame();
			
				String titulo = "Acerca de...";
				@SuppressWarnings("unused") // Solo necesitamos generar una nueva ventana.
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
