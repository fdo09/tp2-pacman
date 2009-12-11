package modelo.vista.control;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipalMini extends Frame {

	public VentanaPrincipalMini(ControladorJuego unControladorJuego) {
		
		this.controladorJuego = unControladorJuego;
		this.setTitle("ALGO3 - MAN");
		
		this.setSize(205,280);
		this.setResizable(false);
		
		panel = new Panel(200,200,controladorJuego);
		
		this.add(panel);
		
		
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
