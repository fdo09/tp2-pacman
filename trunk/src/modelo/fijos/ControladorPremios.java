package modelo.fijos;

import modelo.vista.fijos.VistaPremio;
import modelo.vista.fijos.VistaPremioVida;
import modelo.vista.fijos.VistaPremioRojo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

enum Premios{ROJO, AZUL}

public class ControladorPremios {
	
	
	public static final int DURACION_PREMIO = 20;
	public static final int ESPERA_PREMIO = 60;
	private ControladorJuego controlador;
	private Casillero premioActual;
	private Premios ultimoPremio;
	private Punto posicionPremio;
	private int tiempoPremio;
	private VistaPremio vista;
	
	public ControladorPremios(ControladorJuego controlador){
		this.controlador = controlador;
		this.tiempoPremio = DURACION_PREMIO + ESPERA_PREMIO;
		this.ultimoPremio = Premios.AZUL;
		this.premioActual = null;
		this.vista = null;
		this.posicionPremio = Juego.getInstancia().getTablero().getPacman().getPosicionInicial().getVecinoIzquierdo();
	}
	
	
	public void controlar(){
		// Sin premio en el tablero
		if (this.tiempoPremio > DURACION_PREMIO)
			this.removerPremioActual();
		
		// Con el premio en el tablero
		else
			this.agregarPremio();
		
		if (tiempoPremio == 0)
			this.tiempoPremio = DURACION_PREMIO + ESPERA_PREMIO;
		
		this.tiempoPremio--;
	}
	

	private void agregarPremio() {
		
		Tablero tablero = Juego.getInstancia().getTablero();
		if (this.premioActual != null){
			return;
		}
		
		if (this.ultimoPremio == Premios.AZUL){
			Premio premioRojo = new PremioRojo(this.posicionPremio, tablero);
			tablero.addCasillero(this.posicionPremio, premioRojo);
			this.premioActual = premioRojo;
			this.ultimoPremio = Premios.ROJO;
			this.agregarVistaPremioRojo();
		}
		else if (this.ultimoPremio == Premios.ROJO){
			Premio premioVida = new PremioVida(this.posicionPremio, tablero);
			tablero.addCasillero(this.posicionPremio, premioVida);
			this.premioActual = premioVida;
			this.ultimoPremio = Premios.AZUL;
			this.agregarVistaPremioVida();
		}
		
		
	}

	private void agregarVistaPremioVida() {
		Punto posicionVista = new Punto ( this.posicionPremio.getPuntoX() * 25, this.posicionPremio.getPuntoY() *25 );
		this.vista = new VistaPremioVida(this.premioActual, posicionVista);
		this.controlador.agregarDibujable(vista);
		
	}


	private void agregarVistaPremioRojo() {
		Punto posicionVista = new Punto ( this.posicionPremio.getPuntoX() * 25, this.posicionPremio.getPuntoY() *25 );
		this.vista = new VistaPremioRojo(this.premioActual, posicionVista);
		this.controlador.agregarDibujable(vista);
		
	}


	private void removerPremioActual() {
		// Premio ya esta removido
		if (premioActual == null){
			return;
		}
		
		this.premioActual = null;
		this.removerVista();
	}


	private void removerVista() {
		this.controlador.removerDibujable(this.vista);
		
	}
	
}
