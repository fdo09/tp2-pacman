package modelo.fijos;

import modelo.vista.fijos.VistaPremio;
import modelo.vista.fijos.VistaPremioRojo;
import modelo.vista.fijos.VistaPremioVida;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

enum Premios{ROJO, VIDA}

public class ControladorPremios {
	
	
	public static final int DURACION_PREMIO = 20;
	public static final int ESPERA_PREMIO = 60;
	private Premios ultimoPremio;
	private int tiempoPremio;
	private Punto posicionPremioVida;
	private Punto posicionPremioRojo;
	
	public ControladorPremios(){
		this.tiempoPremio = DURACION_PREMIO + ESPERA_PREMIO;
		this.ultimoPremio = Premios.VIDA;
		this.posicionPremioRojo = Juego.getInstancia().getTablero().getPosicionPremioRojo();
		this.posicionPremioVida = Juego.getInstancia().getTablero().getPosicionPremioVida();
	}
	
	
	public void controlar(){
		// Sin premio en el tablero
		if (this.tiempoPremio > DURACION_PREMIO)
			this.removerPremio();
		
		// Con el premio en el tablero
		else
			this.agregarPremio();
		
		if (tiempoPremio == 0)
			this.tiempoPremio = DURACION_PREMIO + ESPERA_PREMIO;
		
		this.tiempoPremio--;
	}
	

	private void agregarPremio() {
		
		Tablero tablero = Juego.getInstancia().getTablero();
		boolean isPremioRojo = ! (tablero.getCasillero(this.posicionPremioRojo).fuePisado());
		boolean isPremioVida = ! (tablero.getCasillero(this.posicionPremioVida).fuePisado());
		
		if (isPremioRojo || isPremioVida ){
			return;
		}
		
		if (this.ultimoPremio == Premios.VIDA){
			tablero.getCasillero(this.posicionPremioRojo).setFuePisado(false);
			this.ultimoPremio = Premios.ROJO;
		}
		
		else if (this.ultimoPremio == Premios.ROJO){
			tablero.getCasillero(this.posicionPremioVida).setFuePisado(false);
			this.ultimoPremio = Premios.VIDA;
		}
		
		
	}

	/*
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
	*/

	private void removerPremio() {
		Tablero tablero = Juego.getInstancia().getTablero();
		tablero.getCasillero(this.posicionPremioRojo).setFuePisado(true);
		tablero.getCasillero(this.posicionPremioVida).setFuePisado(true);
	}

	/*
	private void removerVista() {
		this.controlador.removerDibujable(this.vista);
		
	}
	*/
}
