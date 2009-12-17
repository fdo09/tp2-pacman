package modelo.fijos;

import modelo.vista.fijos.VistaPremio;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

enum Premios{ROJO, AZUL}

public class ControladorPremios {
	
	
	public static final int DURACION_PREMIO = 20;
	public static final int ESPERA_PREMIO = 20;
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
		}
		else if (this.ultimoPremio == Premios.ROJO){
			Premio premioAzul = new PremioAzul(this.posicionPremio, tablero);
			tablero.addCasillero(this.posicionPremio, premioAzul);
			this.premioActual = premioAzul;
			this.ultimoPremio = Premios.AZUL;
		}
		
		this.agregarVistaPremio();
	}

	private void agregarVistaPremio() {
		Punto posicionVista = new Punto ( this.posicionPremio.getPuntoX() * 25, this.posicionPremio.getPuntoY() *25 );
		this.vista = new VistaPremio(this.premioActual, posicionVista);
		this.controlador.agregarDibujable(vista);
		
	}


	private void removerPremioActual() {
		// Premio ya esta removido
		if (premioActual == null){
			return;
		}
		
		Tablero tablero = Juego.getInstancia().getTablero();
		
		/*
		Semilla semilla = new Semilla(tablero.getPacman().getPosicion(), tablero);
		semilla.setFuePisado(true);
		tablero.addCasillero(tablero.getPacman().getPosicion(), semilla);
		*/
		this.premioActual = null;
		
		this.removerVista();
	}


	private void removerVista() {
		this.controlador.removerDibujable(this.vista);
		
	}
	
	/*
	private Punto calcularPosicionPremio() {
		Tablero tablero = Juego.getInstancia().getTablero();
		Punto dimension = tablero.getDimension();
		Casillero casillero = null;
		Punto posicionAux = null;
		int maxX = dimension.getPuntoX();
		int maxY = dimension.getPuntoY();
		int valorEnteroX = 0;
		int valorEnteroY = 0;
		do{
			valorEnteroX = (int) Math.floor(Math.random() * (maxX));
			valorEnteroY = (int) Math.floor(Math.random() * (maxY));
			posicionAux = new Punto(valorEnteroX, valorEnteroY);
			
			casillero = tablero.getCasillero(posicionAux);
	
		} while (!tablero.esTransitable(posicionAux) || !(casillero instanceof Semilla) );

		return posicionAux;
	}
	*/
}
